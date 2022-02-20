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


public class WaterplantBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;




    public WaterplantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));



    }


    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(4.200000000000001, -9.799999999999988, 2.825, 4.200000000000001, 5.975000000000005, 4.774999999999999),
            Block.box(4.200000000000001, -9.799999999999988, 2.825, 4.200000000000001, 5.975000000000005, 4.774999999999999),
            Block.box(0.19999999999999313, 13.499999999999995, 1.8250000000000002, 5.724999999999996, 13.499999999999995, 5.774999999999995),
            Block.box(0.5, 8.400000000000018, 1.8250000000000002, 0.5, 13.924999999999992, 5.774999999999995),
            Block.box(5.7, -6.074999999999999, 3.3000000000000007, 6.700000000000001, 24.775000000000002, 4.3000000000000025),
            Block.box(2.700000000000005, -6.375, 8.699999999999996, 3.700000000000011, 26.375, 9.7),
            Block.box(9.4, -6.175000000000001, 10.100000000000001, 10.400000000000004, 17.275000000000002, 11.099999999999998),
            Block.box(13.49999999999999, -5.850000000000001, 2.6000000000000036, 14.499999999999993, 19.950000000000003, 3.599999999999999),
            Block.box(5.25, 24.800000000000033, 2.625, 7.249999999999999, 29.600000000000033, 4.85),
            Block.box(2.250000000000001, 25.90000000000003, 8.124999999999998, 4.250000000000005, 31.95000000000003, 10.349999999999994),
            Block.box(12.950000000000005, 19.70000000000001, 2.0249999999999995, 14.950000000000005, 24.500000000000014, 4.250000000000002),
            Block.box(8.950000000000015, 17.299999999999986, 9.525000000000011, 10.950000000000015, 23.64999999999999, 11.750000000000012),
            Block.box(12.72499999999999, -4.20000000000001, 0.8999999999999996, 14.67499999999998, 11.574999999999987, 0.8999999999999996),
            Block.box(12.72499999999999, -4.20000000000001, 0.8999999999999996, 14.67499999999998, 11.574999999999987, 0.8999999999999996),
            Block.box(11.724999999999996, 19.10000000000003, -3.100000000000011, 15.674999999999974, 19.10000000000003, 2.4249999999999963),
            Block.box(11.724999999999996, 13.999999999999998, -2.8000000000000025, 15.674999999999974, 19.525000000000034, -2.8000000000000025),
            Block.box(1.4000000000000008, -6.100000000000001, 8.125000000000002, 1.4000000000000008, 9.674999999999994, 10.075000000000008),
            Block.box(1.4000000000000008, -6.100000000000001, 8.125000000000002, 1.4000000000000008, 9.674999999999994, 10.075000000000008),
            Block.box(-2.6000000000000085, 17.200000000000003, 7.125000000000006, 2.924999999999998, 17.200000000000003, 11.075000000000001),
            Block.box(-2.3, 12.100000000000005, 7.125000000000006, -2.3, 17.625000000000007, 11.075000000000001),
            Block.box(16.199999999999946, -10.299999999999994, 2.3249999999999855, 16.199999999999946, 5.475000000000003, 4.274999999999995),
            Block.box(16.199999999999946, -10.299999999999994, 2.3249999999999855, 16.199999999999946, 5.475000000000003, 4.274999999999995),
            Block.box(14.67499999999997, 13, 1.324999999999991, 20.199999999999967, 13, 5.274999999999995),
            Block.box(19.899999999999956, 7.900000000000017, 1.324999999999991, 19.899999999999956, 13.424999999999997, 5.274999999999995),
            Block.box(11.899999999999944, -6.100000000000001, 9.924999999999985, 11.899999999999944, 9.674999999999994, 11.874999999999988),
            Block.box(11.899999999999944, -6.100000000000001, 9.924999999999985, 11.899999999999944, 9.674999999999994, 11.874999999999988),
            Block.box(10.374999999999966, 17.200000000000003, 8.924999999999988, 15.89999999999994, 17.200000000000003, 12.874999999999988),
            Block.box(15.599999999999932, 12.100000000000005, 8.924999999999988, 15.599999999999932, 17.625000000000007, 12.874999999999988),
            Block.box(8.924999999999997, -4.1000000000000085, 13.899999999999954, 10.875000000000009, 11.674999999999986, 13.899999999999954),
            Block.box(8.924999999999997, -4.1000000000000085, 13.899999999999954, 10.875000000000009, 11.674999999999986, 13.899999999999954),
            Block.box(7.924999999999984, 19.20000000000003, 12.374999999999984, 11.875000000000005, 19.20000000000003, 17.899999999999928),
            Block.box(7.924999999999984, 14.099999999999998, 17.599999999999923, 11.875000000000005, 19.625000000000036, 17.599999999999923),
            Block.box(5.699999999999948, -13.799999999999986, 5.624999999999989, 5.699999999999948, 1.9750000000000068, 7.574999999999996),
            Block.box(5.699999999999948, -13.799999999999986, 5.624999999999989, 5.699999999999948, 1.9750000000000068, 7.574999999999996),
            Block.box(4.1749999999999705, 9.5, 4.624999999999995, 9.699999999999944, 9.5, 8.574999999999996),
            Block.box(9.399999999999936, 4.400000000000017, 4.624999999999995, 9.399999999999936, 9.924999999999994, 8.574999999999996)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(11.799999999999999, -9.799999999999988, 2.825, 11.799999999999999, 5.975000000000005, 4.774999999999999),
            Block.box(11.799999999999999, -9.799999999999988, 2.825, 11.799999999999999, 5.975000000000005, 4.774999999999999),
            Block.box(10.275000000000004, 13.499999999999995, 1.8250000000000002, 15.800000000000008, 13.499999999999995, 5.774999999999995),
            Block.box(15.5, 8.400000000000018, 1.8250000000000002, 15.5, 13.924999999999992, 5.774999999999995),
            Block.box(9.299999999999999, -6.074999999999999, 3.3000000000000007, 10.3, 24.775000000000002, 4.3000000000000025),
            Block.box(12.29999999999999, -6.375, 8.699999999999996, 13.299999999999995, 26.375, 9.7),
            Block.box(5.599999999999996, -6.175000000000001, 10.100000000000001, 6.6, 17.275000000000002, 11.099999999999998),
            Block.box(1.500000000000007, -5.850000000000001, 2.6000000000000036, 2.5000000000000107, 19.950000000000003, 3.599999999999999),
            Block.box(8.75, 24.800000000000033, 2.625, 10.75, 29.600000000000033, 4.85),
            Block.box(11.749999999999995, 25.90000000000003, 8.124999999999998, 13.75, 31.95000000000003, 10.349999999999994),
            Block.box(1.0499999999999954, 19.70000000000001, 2.0249999999999995, 3.0499999999999954, 24.500000000000014, 4.250000000000002),
            Block.box(5.049999999999985, 17.299999999999986, 9.525000000000011, 7.049999999999985, 23.64999999999999, 11.750000000000012),
            Block.box(1.3250000000000206, -4.20000000000001, 0.8999999999999996, 3.2750000000000092, 11.574999999999987, 0.8999999999999996),
            Block.box(1.3250000000000206, -4.20000000000001, 0.8999999999999996, 3.2750000000000092, 11.574999999999987, 0.8999999999999996),
            Block.box(0.32500000000002593, 19.10000000000003, -3.100000000000011, 4.275000000000004, 19.10000000000003, 2.4249999999999963),
            Block.box(0.32500000000002593, 13.999999999999998, -2.8000000000000025, 4.275000000000004, 19.525000000000034, -2.8000000000000025),
            Block.box(14.6, -6.100000000000001, 8.125000000000002, 14.6, 9.674999999999994, 10.075000000000008),
            Block.box(14.6, -6.100000000000001, 8.125000000000002, 14.6, 9.674999999999994, 10.075000000000008),
            Block.box(13.075000000000003, 17.200000000000003, 7.125000000000006, 18.60000000000001, 17.200000000000003, 11.075000000000001),
            Block.box(18.3, 12.100000000000005, 7.125000000000006, 18.3, 17.625000000000007, 11.075000000000001),
            Block.box(-0.199999999999946, -10.299999999999994, 2.3249999999999855, -0.199999999999946, 5.475000000000003, 4.274999999999995),
            Block.box(-0.199999999999946, -10.299999999999994, 2.3249999999999855, -0.199999999999946, 5.475000000000003, 4.274999999999995),
            Block.box(-4.199999999999967, 13, 1.324999999999991, 1.3250000000000295, 13, 5.274999999999995),
            Block.box(-3.899999999999956, 7.900000000000017, 1.324999999999991, -3.899999999999956, 13.424999999999997, 5.274999999999995),
            Block.box(4.1000000000000565, -6.100000000000001, 9.924999999999985, 4.1000000000000565, 9.674999999999994, 11.874999999999988),
            Block.box(4.1000000000000565, -6.100000000000001, 9.924999999999985, 4.1000000000000565, 9.674999999999994, 11.874999999999988),
            Block.box(0.10000000000006004, 17.200000000000003, 8.924999999999988, 5.625000000000034, 17.200000000000003, 12.874999999999988),
            Block.box(0.40000000000006786, 12.100000000000005, 8.924999999999988, 0.40000000000006786, 17.625000000000007, 12.874999999999988),
            Block.box(5.124999999999991, -4.1000000000000085, 13.899999999999954, 7.075000000000003, 11.674999999999986, 13.899999999999954),
            Block.box(5.124999999999991, -4.1000000000000085, 13.899999999999954, 7.075000000000003, 11.674999999999986, 13.899999999999954),
            Block.box(4.124999999999995, 19.20000000000003, 12.374999999999984, 8.075000000000017, 19.20000000000003, 17.899999999999928),
            Block.box(4.124999999999995, 14.099999999999998, 17.599999999999923, 8.075000000000017, 19.625000000000036, 17.599999999999923),
            Block.box(10.300000000000052, -13.799999999999986, 5.624999999999989, 10.300000000000052, 1.9750000000000068, 7.574999999999996),
            Block.box(10.300000000000052, -13.799999999999986, 5.624999999999989, 10.300000000000052, 1.9750000000000068, 7.574999999999996),
            Block.box(6.300000000000056, 9.5, 4.624999999999995, 11.82500000000003, 9.5, 8.574999999999996),
            Block.box(6.600000000000064, 4.400000000000017, 4.624999999999995, 6.600000000000064, 9.924999999999994, 8.574999999999996)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(4.200000000000001, -9.799999999999988, 2.8249999999999993, 4.200000000000001, 5.975000000000005, 4.774999999999999),
            Block.box(4.200000000000001, -9.799999999999988, 2.8249999999999993, 4.200000000000001, 5.975000000000005, 4.774999999999999),
            Block.box(0.19999999999999313, 13.499999999999995, 1.8249999999999993, 5.724999999999996, 13.499999999999995, 5.774999999999995),
            Block.box(0.5, 8.400000000000018, 1.8249999999999993, 0.5, 13.924999999999992, 5.774999999999995),
            Block.box(5.7, -6.074999999999999, 3.3000000000000007, 6.700000000000001, 24.775000000000002, 4.3000000000000025),
            Block.box(2.700000000000005, -6.375, 8.699999999999996, 3.700000000000011, 26.375, 9.7),
            Block.box(9.4, -6.175000000000001, 10.100000000000001, 10.400000000000004, 17.275000000000002, 11.099999999999998),
            Block.box(13.49999999999999, -5.850000000000001, 2.600000000000003, 14.499999999999993, 19.950000000000003, 3.5999999999999996),
            Block.box(5.25, 24.800000000000033, 2.625, 7.249999999999999, 29.600000000000033, 4.85),
            Block.box(2.250000000000001, 25.90000000000003, 8.124999999999998, 4.250000000000005, 31.95000000000003, 10.349999999999994),
            Block.box(12.950000000000005, 19.70000000000001, 2.0249999999999986, 14.950000000000005, 24.500000000000014, 4.250000000000002),
            Block.box(8.950000000000015, 17.299999999999986, 9.525000000000011, 10.950000000000015, 23.64999999999999, 11.750000000000012),
            Block.box(12.72499999999999, -4.20000000000001, 0.8999999999999986, 14.67499999999998, 11.574999999999987, 0.8999999999999986),
            Block.box(12.72499999999999, -4.20000000000001, 0.8999999999999986, 14.67499999999998, 11.574999999999987, 0.8999999999999986),
            Block.box(11.724999999999996, 19.10000000000003, -3.100000000000012, 15.674999999999974, 19.10000000000003, 2.424999999999997),
            Block.box(11.724999999999996, 13.999999999999998, -2.8000000000000043, 15.674999999999974, 19.525000000000034, -2.8000000000000043),
            Block.box(1.4000000000000008, -6.100000000000001, 8.125000000000002, 1.4000000000000008, 9.674999999999994, 10.075000000000008),
            Block.box(1.4000000000000008, -6.100000000000001, 8.125000000000002, 1.4000000000000008, 9.674999999999994, 10.075000000000008),
            Block.box(-2.6000000000000085, 17.200000000000003, 7.125000000000007, 2.924999999999998, 17.200000000000003, 11.075000000000001),
            Block.box(-2.3, 12.100000000000005, 7.125000000000007, -2.3, 17.625000000000007, 11.075000000000001),
            Block.box(16.199999999999946, -10.299999999999994, 2.324999999999985, 16.199999999999946, 5.475000000000003, 4.274999999999995),
            Block.box(16.199999999999946, -10.299999999999994, 2.324999999999985, 16.199999999999946, 5.475000000000003, 4.274999999999995),
            Block.box(14.67499999999997, 13, 1.3249999999999922, 20.199999999999967, 13, 5.274999999999995),
            Block.box(19.899999999999956, 7.900000000000017, 1.3249999999999922, 19.899999999999956, 13.424999999999997, 5.274999999999995),
            Block.box(11.899999999999944, -6.100000000000001, 9.924999999999985, 11.899999999999944, 9.674999999999994, 11.874999999999988),
            Block.box(11.899999999999944, -6.100000000000001, 9.924999999999985, 11.899999999999944, 9.674999999999994, 11.874999999999988),
            Block.box(10.374999999999966, 17.200000000000003, 8.924999999999988, 15.89999999999994, 17.200000000000003, 12.874999999999988),
            Block.box(15.599999999999932, 12.100000000000005, 8.924999999999988, 15.599999999999932, 17.625000000000007, 12.874999999999988),
            Block.box(8.924999999999997, -4.1000000000000085, 13.899999999999954, 10.875000000000009, 11.674999999999986, 13.899999999999954),
            Block.box(8.924999999999997, -4.1000000000000085, 13.899999999999954, 10.875000000000009, 11.674999999999986, 13.899999999999954),
            Block.box(7.924999999999984, 19.20000000000003, 12.374999999999984, 11.875000000000005, 19.20000000000003, 17.899999999999928),
            Block.box(7.924999999999984, 14.099999999999998, 17.599999999999923, 11.875000000000005, 19.625000000000036, 17.599999999999923),
            Block.box(5.699999999999948, -13.799999999999986, 5.624999999999989, 5.699999999999948, 1.9750000000000068, 7.574999999999996),
            Block.box(5.699999999999948, -13.799999999999986, 5.624999999999989, 5.699999999999948, 1.9750000000000068, 7.574999999999996),
            Block.box(4.1749999999999705, 9.5, 4.624999999999995, 9.699999999999944, 9.5, 8.574999999999996),
            Block.box(9.399999999999936, 4.400000000000017, 4.624999999999995, 9.399999999999936, 9.924999999999994, 8.574999999999996)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(4.200000000000001, -9.799999999999988, 11.225000000000001, 4.200000000000001, 5.975000000000005, 13.175),
            Block.box(4.200000000000001, -9.799999999999988, 11.225000000000001, 4.200000000000001, 5.975000000000005, 13.175),
            Block.box(0.19999999999999313, 13.499999999999995, 10.225000000000005, 5.724999999999996, 13.499999999999995, 14.175),
            Block.box(0.5, 8.400000000000018, 10.225000000000005, 0.5, 13.924999999999992, 14.175),
            Block.box(5.7, -6.074999999999999, 11.699999999999998, 6.700000000000001, 24.775000000000002, 12.7),
            Block.box(2.700000000000005, -6.375, 6.300000000000001, 3.700000000000011, 26.375, 7.300000000000004),
            Block.box(9.4, -6.175000000000001, 4.900000000000002, 10.400000000000004, 17.275000000000002, 5.899999999999999),
            Block.box(13.49999999999999, -5.850000000000001, 12.4, 14.499999999999993, 19.950000000000003, 13.399999999999997),
            Block.box(5.25, 24.800000000000033, 11.15, 7.249999999999999, 29.600000000000033, 13.375),
            Block.box(2.250000000000001, 25.90000000000003, 5.650000000000006, 4.250000000000005, 31.95000000000003, 7.875000000000002),
            Block.box(12.950000000000005, 19.70000000000001, 11.749999999999998, 14.950000000000005, 24.500000000000014, 13.975000000000001),
            Block.box(8.950000000000015, 17.299999999999986, 4.249999999999988, 10.950000000000015, 23.64999999999999, 6.474999999999989),
            Block.box(12.72499999999999, -4.20000000000001, 15.100000000000001, 14.67499999999998, 11.574999999999987, 15.100000000000001),
            Block.box(12.72499999999999, -4.20000000000001, 15.100000000000001, 14.67499999999998, 11.574999999999987, 15.100000000000001),
            Block.box(11.724999999999996, 19.10000000000003, 13.575000000000003, 15.674999999999974, 19.10000000000003, 19.100000000000012),
            Block.box(11.724999999999996, 13.999999999999998, 18.800000000000004, 15.674999999999974, 19.525000000000034, 18.800000000000004),
            Block.box(1.4000000000000008, -6.100000000000001, 5.924999999999992, 1.4000000000000008, 9.674999999999994, 7.874999999999998),
            Block.box(1.4000000000000008, -6.100000000000001, 5.924999999999992, 1.4000000000000008, 9.674999999999994, 7.874999999999998),
            Block.box(-2.6000000000000085, 17.200000000000003, 4.924999999999999, 2.924999999999998, 17.200000000000003, 8.874999999999993),
            Block.box(-2.3, 12.100000000000005, 4.924999999999999, -2.3, 17.625000000000007, 8.874999999999993),
            Block.box(16.199999999999946, -10.299999999999994, 11.725000000000005, 16.199999999999946, 5.475000000000003, 13.675000000000015),
            Block.box(16.199999999999946, -10.299999999999994, 11.725000000000005, 16.199999999999946, 5.475000000000003, 13.675000000000015),
            Block.box(14.67499999999997, 13, 10.725000000000005, 20.199999999999967, 13, 14.675000000000008),
            Block.box(19.899999999999956, 7.900000000000017, 10.725000000000005, 19.899999999999956, 13.424999999999997, 14.675000000000008),
            Block.box(11.899999999999944, -6.100000000000001, 4.125000000000012, 11.899999999999944, 9.674999999999994, 6.075000000000015),
            Block.box(11.899999999999944, -6.100000000000001, 4.125000000000012, 11.899999999999944, 9.674999999999994, 6.075000000000015),
            Block.box(10.374999999999966, 17.200000000000003, 3.1250000000000124, 15.89999999999994, 17.200000000000003, 7.075000000000012),
            Block.box(15.599999999999932, 12.100000000000005, 3.1250000000000124, 15.599999999999932, 17.625000000000007, 7.075000000000012),
            Block.box(8.924999999999997, -4.1000000000000085, 2.100000000000046, 10.875000000000009, 11.674999999999986, 2.100000000000046),
            Block.box(8.924999999999997, -4.1000000000000085, 2.100000000000046, 10.875000000000009, 11.674999999999986, 2.100000000000046),
            Block.box(7.924999999999984, 19.20000000000003, -1.8999999999999275, 11.875000000000005, 19.20000000000003, 3.625000000000016),
            Block.box(7.924999999999984, 14.099999999999998, -1.5999999999999233, 11.875000000000005, 19.625000000000036, -1.5999999999999233),
            Block.box(5.699999999999948, -13.799999999999986, 8.425000000000004, 5.699999999999948, 1.9750000000000068, 10.37500000000001),
            Block.box(5.699999999999948, -13.799999999999986, 8.425000000000004, 5.699999999999948, 1.9750000000000068, 10.37500000000001),
            Block.box(4.1749999999999705, 9.5, 7.425000000000004, 9.699999999999944, 9.5, 11.375000000000005),
            Block.box(9.399999999999936, 4.400000000000017, 7.425000000000004, 9.399999999999936, 9.924999999999994, 11.375000000000005)
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




















