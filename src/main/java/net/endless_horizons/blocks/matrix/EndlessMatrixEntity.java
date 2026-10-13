package net.endless_horizons.blocks.matrix;

import net.endless_horizons.blocks.EndlessEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Objects;

import static net.endless_horizons.EndlessHorizons.EndlessMatrixEntity;

public class EndlessMatrixEntity extends BlockEntity implements EndlessEntity {

    public EndlessMatrixEntity(BlockPos pos, BlockState state) {
        super(EndlessMatrixEntity, pos, state);
    }

    @Override
    public boolean shouldDrawSide(Direction direction) {
        BlockPos.Mutable mutable = getPos().mutableCopy();
        mutable.set(pos, direction);
        return Block.shouldDrawSide(getCachedState(), Objects.requireNonNull(getWorld()).getBlockState(getPos()), direction);
    }
}
