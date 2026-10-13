package net.endless_horizons.blocks.end;

import net.endless_horizons.blocks.EndlessRenderState;
import net.endless_horizons.blocks.EndlessRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

@Environment(EnvType.CLIENT)
public class EndlessEndEntityRenderer extends EndlessRenderer<EndlessEndEntity> implements BlockEntityRenderer<EndlessEndEntity, EndlessRenderState> {
    @Override
    public void render(EndlessRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        queue.submitCustom(
                matrices, RenderLayers.endGateway(),
                (entry, vertices) -> renderSides(
                        direction -> state.sides.getOrDefault(direction, false),
                        entry.getPositionMatrix(),
                        vertices
                )
        );
    }

    @Override
    public EndlessRenderState createRenderState() {
        return new EndlessRenderState();
    }

    @Override
    public void updateRenderState(EndlessEndEntity entity, EndlessRenderState state, float tickProgress, Vec3d cameraPos, ModelCommandRenderer.CrumblingOverlayCommand overlay) {
        BlockEntityRenderer.super.updateRenderState(entity, state, tickProgress, cameraPos, overlay);

        for (Direction direction : Direction.values()) {
            state.sides.put(direction, entity.shouldDrawSide(direction));
        }
    }

    @Override
    public int getRenderDistance() {
        return 256;
    }
}