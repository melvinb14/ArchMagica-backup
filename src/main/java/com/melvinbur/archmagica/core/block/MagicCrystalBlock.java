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


public class MagicCrystalBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;




    public MagicCrystalBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));



    }


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(6.849999999999999, 6.5, 12.049999999999997, 9.149999999999999, 9.699999999999985, 14.350000000000007),
            Block.box(6.049999999999999, -1.6999999999999993, 6.0499999999999945, 9.95, 16.9, 10.049999999999994),
            Block.box(6.549999999999999, 16.9, 6.449999999999994, 9.45, 22.999999999999993, 9.549999999999994),
            Block.box(1.0500000000000052, -1.700000000000001, 6.0499999999999945, 4.95000000000001, 6.399999999999997, 10.049999999999994),
            Block.box(6.049999999999999, -1.700000000000001, 1.0499999999999936, 9.95, 6.399999999999997, 5.0500000000000025),
            Block.box(6.049999999999999, -1.700000000000001, 11.24999999999999, 9.95, 6.399999999999997, 15.249999999999961),
            Block.box(11.249999999999996, -1.700000000000001, 6.0499999999999945, 15.149999999999991, 6.399999999999997, 10.049999999999994),
            Block.box(6.849999999999999, 6.5, 1.8499999999999934, 9.149999999999999, 9.699999999999985, 4.0500000000000025),
            Block.box(1.7499999999999991, 6.5, 6.95000000000001, 4.049999999999999, 9.699999999999985, 9.150000000000018),
            Block.box(12.15, 6.5, 6.9499999999999815, 14.450000000000001, 9.699999999999985, 9.14999999999999)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(6.849999999999998, 6.5, 12.049999999999997, 9.149999999999999, 9.699999999999985, 14.350000000000007),
            Block.box(6.049999999999999, -1.6999999999999993, 6.0499999999999945, 9.95, 16.9, 10.049999999999994),
            Block.box(6.549999999999999, 16.9, 6.449999999999994, 9.45, 22.999999999999993, 9.549999999999994),
            Block.box(1.0500000000000043, -1.700000000000001, 6.0499999999999945, 4.95000000000001, 6.399999999999997, 10.049999999999994),
            Block.box(6.049999999999999, -1.700000000000001, 1.0499999999999936, 9.95, 6.399999999999997, 5.0500000000000025),
            Block.box(6.049999999999999, -1.700000000000001, 11.24999999999999, 9.95, 6.399999999999997, 15.249999999999961),
            Block.box(11.249999999999996, -1.700000000000001, 6.0499999999999945, 15.149999999999991, 6.399999999999997, 10.049999999999994),
            Block.box(6.849999999999998, 6.5, 1.8499999999999934, 9.149999999999999, 9.699999999999985, 4.0500000000000025),
            Block.box(1.75, 6.5, 6.95000000000001, 4.049999999999999, 9.699999999999985, 9.150000000000018),
            Block.box(12.15, 6.5, 6.9499999999999815, 14.450000000000001, 9.699999999999985, 9.14999999999999)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(6.850000000000001, 6.5, 12.049999999999997, 9.150000000000002, 9.699999999999985, 14.350000000000007),
            Block.box(6.050000000000001, -1.6999999999999993, 6.0499999999999945, 9.950000000000001, 16.9, 10.049999999999994),
            Block.box(6.550000000000001, 16.9, 6.449999999999994, 9.450000000000001, 22.999999999999993, 9.549999999999994),
            Block.box(11.04999999999999, -1.700000000000001, 6.0499999999999945, 14.949999999999996, 6.399999999999997, 10.049999999999994),
            Block.box(6.050000000000001, -1.700000000000001, 1.0499999999999936, 9.950000000000001, 6.399999999999997, 5.0500000000000025),
            Block.box(6.050000000000001, -1.700000000000001, 11.24999999999999, 9.950000000000001, 6.399999999999997, 15.249999999999961),
            Block.box(0.8500000000000085, -1.700000000000001, 6.0499999999999945, 4.7500000000000036, 6.399999999999997, 10.049999999999994),
            Block.box(6.850000000000001, 6.5, 1.8499999999999934, 9.150000000000002, 9.699999999999985, 4.0500000000000025),
            Block.box(11.950000000000001, 6.5, 6.95000000000001, 14.25, 9.699999999999985, 9.150000000000018),
            Block.box(1.549999999999999, 6.5, 6.9499999999999815, 3.8499999999999996, 9.699999999999985, 9.14999999999999)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(6.849999999999999, 6.5, 1.6499999999999932, 9.149999999999999, 9.699999999999985, 3.950000000000003),
            Block.box(6.049999999999999, -1.6999999999999993, 5.950000000000006, 9.95, 16.9, 9.950000000000006),
            Block.box(6.549999999999999, 16.9, 6.450000000000006, 9.45, 22.999999999999993, 9.550000000000006),
            Block.box(1.0500000000000052, -1.700000000000001, 5.950000000000006, 4.95000000000001, 6.399999999999997, 9.950000000000006),
            Block.box(6.049999999999999, -1.700000000000001, 10.949999999999998, 9.95, 6.399999999999997, 14.950000000000006),
            Block.box(6.049999999999999, -1.700000000000001, 0.7500000000000391, 9.95, 6.399999999999997, 4.750000000000011),
            Block.box(11.249999999999996, -1.700000000000001, 5.950000000000006, 15.149999999999991, 6.399999999999997, 9.950000000000006),
            Block.box(6.849999999999999, 6.5, 11.949999999999998, 9.149999999999999, 9.699999999999985, 14.150000000000006),
            Block.box(1.7499999999999991, 6.5, 6.849999999999982, 4.049999999999999, 9.699999999999985, 9.04999999999999),
            Block.box(12.15, 6.5, 6.85000000000001, 14.450000000000001, 9.699999999999985, 9.050000000000018)
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




















