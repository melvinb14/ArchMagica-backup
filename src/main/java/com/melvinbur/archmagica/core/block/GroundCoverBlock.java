package com.melvinbur.archmagica.core.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GroundCoverBlock extends HorizontalDirectionalBlock implements SimpleWaterloggedBlock {
    public static final IntegerProperty MODEL = IntegerProperty.create("model", 0, 4);
    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;


    public GroundCoverBlock() {
        super(Properties.of(Material.DIRT).strength(0.05F, 0.0F).noOcclusion());
        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) ((BlockState) this.stateDefinition.any()).setValue(MODEL, 0)).setValue(FACING, Direction.NORTH)).setValue(WATERLOGGED, false));
    }

    public GroundCoverBlock(Material material, SoundType soundType) {
        super(Properties.of(material).strength(0.1F, 0.0F).sound(soundType).noOcclusion());
        this.registerDefaultState((BlockState) ((BlockState) ((BlockState) this.defaultBlockState().setValue(MODEL, 0)).setValue(FACING, Direction.NORTH)).setValue(WATERLOGGED, false));
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        int model = context.getLevel().getRandom().nextInt(5);
        Direction facing = Plane.HORIZONTAL.getRandomDirection(context.getLevel().getRandom());
        FluidState ifluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return (BlockState) ((BlockState) ((BlockState) this.defaultBlockState().setValue(MODEL, model)).setValue(FACING, facing)).setValue(WATERLOGGED, ifluidstate.getType() == Fluids.WATER);
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean) state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return state;
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return Block.canSupportRigidBlock(world, pos.below());
    }

    public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (!this.canSurvive(state, world, pos)) {
            world.destroyBlock(pos, false);
        }

    }

    public VoxelShape getCollisionShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult brt) {
        world.removeBlock(pos, true);
        if (!player.isCreative() && player.mayBuild()) {
            Containers.dropItemStack(world, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), new ItemStack(this));
        }

        return InteractionResult.SUCCESS;
    }

    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }



    public FluidState getFluidState(BlockState state) {
        return (Boolean) state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{MODEL, FACING, WATERLOGGED});
    }

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;

    }
}