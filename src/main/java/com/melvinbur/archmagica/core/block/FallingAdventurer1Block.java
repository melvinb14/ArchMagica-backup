package com.melvinbur.archmagica.core.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.stream.Stream;


public class FallingAdventurer1Block extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;




    public FallingAdventurer1Block(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));



    }


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(15.449999999999998, 0, 3.4749999999999996, 16.800000000000004, 1.625, 10.899999999999999),
            Block.box(4, 3, 9, 6, 4, 10),
            Block.box(3.9000000000000004, 8.604228440844963e-16, 18.800000000000054, 11.7, 6.949999999999994, 26.000000000000068),
            Block.box(5, 4, 6, 7, 5, 7),
            Block.box(5.254, 5.699999999999999, 12.450000000000001, 8.673999999999998, 6.84, 13.590000000000005),
            Block.box(8.673999999999998, 5.699999999999999, 13.590000000000005, 12.093999999999998, 6.84, 14.73),
            Block.box(5, 5, 3, 8, 6, 4),
            Block.box(8, 5, 4, 11, 6, 5),
            Block.box(9, 4, 7, 11, 5, 8),
            Block.box(9, 4, 9, 11, 5, 10),
            Block.box(-1.5000000000000004, 9.71445146547012e-16, 10.299999999999995, -0.1750000000000016, 7.625, 11.899999999999995),
            Block.box(3, 0, 9, 4, 3, 10),
            Block.box(4, 0, 6, 5, 4, 7),
            Block.box(4.114000000000001, 0, 12.450000000000001, 5.254, 5.699999999999999, 13.590000000000005),
            Block.box(4, 0, 3, 5, 5, 4),
            Block.box(11, 0, 9, 12, 4, 10),
            Block.box(12.093999999999998, 0, 13.590000000000005, 13.233999999999996, 5.699999999999999, 14.73),
            Block.box(11, 0, 7, 12, 4, 8),
            Block.box(11, 0, 4, 12, 5, 5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(6.100000000000001, 0, 16.65, 13.524999999999991, 1.625, 18.00000000000003),
            Block.box(7, 3, 5.200000000000004, 8, 4, 7.200000000000004),
            Block.box(-9.00000000000007, 0, 5.100000000000003, -1.8000000000000576, 6.949999999999992, 12.899999999999997),
            Block.box(10, 4, 6.200000000000004, 11, 5, 8.200000000000001),
            Block.box(3.409999999999992, 5.699999999999999, 6.454000000000003, 4.549999999999997, 6.84, 9.873999999999997),
            Block.box(2.2699999999999942, 5.699999999999999, 9.873999999999997, 3.409999999999992, 6.84, 13.293999999999995),
            Block.box(12.99999999999999, 5, 6.200000000000004, 13.999999999999986, 6, 9.200000000000001),
            Block.box(11.99999999999999, 5, 9.200000000000001, 12.99999999999999, 6, 12.200000000000001),
            Block.box(9, 4, 10.200000000000001, 10, 5, 12.200000000000001),
            Block.box(7, 4, 10.200000000000001, 8, 5, 12.200000000000001),
            Block.box(5.100000000000001, 0, -0.29999999999999805, 6.700000000000006, 7.625, 1.025000000000003),
            Block.box(7, 0, 4.200000000000004, 8, 3, 5.200000000000004),
            Block.box(10, 0, 5.200000000000004, 11, 4, 6.200000000000004),
            Block.box(3.409999999999992, 0, 5.3140000000000045, 4.549999999999997, 5.699999999999999, 6.454000000000003),
            Block.box(12.99999999999999, 0, 5.200000000000004, 13.999999999999986, 5, 6.200000000000004),
            Block.box(7, 0, 12.200000000000001, 8, 4, 13.199999999999998),
            Block.box(2.2699999999999942, 0, 13.293999999999995, 3.409999999999992, 5.699999999999999, 14.433999999999996),
            Block.box(9, 0, 12.200000000000001, 10, 4, 13.199999999999998),
            Block.box(11.99999999999999, 0, 12.200000000000001, 12.99999999999999, 5, 13.199999999999998)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(2.4750000000000085, 0, 16.65, 9.899999999999999, 1.625, 18.00000000000003),
            Block.box(8, 3, 5.200000000000004, 9, 4, 7.200000000000004),
            Block.box(17.800000000000058, 0, 5.100000000000003, 25.00000000000007, 6.949999999999992, 12.899999999999997),
            Block.box(5, 4, 6.200000000000004, 6, 5, 8.200000000000001),
            Block.box(11.450000000000003, 5.699999999999999, 6.454000000000003, 12.590000000000007, 6.84, 9.873999999999997),
            Block.box(12.590000000000007, 5.699999999999999, 9.873999999999997, 13.730000000000006, 6.84, 13.293999999999995),
            Block.box(2.000000000000014, 5, 6.200000000000004, 3.0000000000000107, 6, 9.200000000000001),
            Block.box(3.0000000000000107, 5, 9.200000000000001, 4.000000000000011, 6, 12.200000000000001),
            Block.box(6, 4, 10.200000000000001, 7, 5, 12.200000000000001),
            Block.box(8, 4, 10.200000000000001, 9, 5, 12.200000000000001),
            Block.box(9.299999999999994, 0, -0.29999999999999805, 10.899999999999999, 7.625, 1.025000000000003),
            Block.box(8, 0, 4.200000000000004, 9, 3, 5.200000000000004),
            Block.box(5, 0, 5.200000000000004, 6, 4, 6.200000000000004),
            Block.box(11.450000000000003, 0, 5.3140000000000045, 12.590000000000007, 5.699999999999999, 6.454000000000003),
            Block.box(2.000000000000014, 0, 5.200000000000004, 3.0000000000000107, 5, 6.200000000000004),
            Block.box(8, 0, 12.200000000000001, 9, 4, 13.199999999999998),
            Block.box(12.590000000000007, 0, 13.293999999999995, 13.730000000000006, 5.699999999999999, 14.433999999999996),
            Block.box(6, 0, 12.200000000000001, 7, 4, 13.199999999999998),
            Block.box(3.0000000000000107, 0, 12.200000000000001, 4.000000000000011, 5, 13.199999999999998)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(15.449999999999998, 0, 5.100000000000001, 16.800000000000004, 1.625, 12.525),
            Block.box(4, 3, 6, 6, 4, 7),
            Block.box(3.9000000000000004, -2.599999999999959, -10.7500000000001, 11.7, 4.600000000000055, -3.8000000000001073),
            Block.box(5, 4, 9, 7, 5, 10),
            Block.box(5.254, 5.699999999999999, 2.409999999999995, 8.673999999999998, 6.84, 3.549999999999999),
            Block.box(8.673999999999998, 5.699999999999999, 1.2699999999999996, 12.093999999999998, 6.84, 2.409999999999995),
            Block.box(5, 5, 12, 8, 6, 13),
            Block.box(8, 5, 11, 11, 6, 12),
            Block.box(9, 4, 8, 11, 5, 9),
            Block.box(9, 4, 6, 11, 5, 7),
            Block.box(-1.5000000000000004, 9.71445146547012e-16, 4.100000000000005, -0.1750000000000016, 7.625, 5.700000000000005),
            Block.box(3, 0, 6, 4, 3, 7),
            Block.box(4, 0, 9, 5, 4, 10),
            Block.box(4.114000000000001, 0, 2.409999999999995, 5.254, 5.699999999999999, 3.549999999999999),
            Block.box(4, 0, 12, 5, 5, 13),
            Block.box(11, 0, 6, 12, 4, 7),
            Block.box(12.093999999999998, 0, 1.2699999999999996, 13.233999999999996, 5.699999999999999, 2.409999999999995),
            Block.box(11, 0, 8, 12, 4, 9),
            Block.box(11, 0, 11, 12, 5, 12)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();


    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }



    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }



        @Override
        public BlockState rotate(BlockState pState, Rotation pRotation) {
            return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
        }

        @Override
        public BlockState mirror(BlockState pState, Mirror pMirror) {
            return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
        }
        @Override
        protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
            pBuilder.add(FACING);
        }






}




















