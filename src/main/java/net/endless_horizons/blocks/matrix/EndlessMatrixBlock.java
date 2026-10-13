package net.endless_horizons.blocks.matrix;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class EndlessMatrixBlock extends Block implements BlockEntityProvider {
    public EndlessMatrixBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EndlessMatrixEntity(pos, state);
    }

}
