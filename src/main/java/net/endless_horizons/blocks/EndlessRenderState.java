package net.endless_horizons.blocks;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.util.math.Direction;

import java.util.EnumMap;
import java.util.Map;

public class EndlessRenderState extends BlockEntityRenderState {
    public final Map<Direction, Boolean> sides = new EnumMap<>(Direction.class);
}
