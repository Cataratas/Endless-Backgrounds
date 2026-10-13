package net.endless_horizons.blocks.matrix;

import net.endless_horizons.blocks.EndlessRenderState;
import net.endless_horizons.blocks.EndlessRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;

//import static net.endless_horizons.client.EndlessHorizonsClient.matrixRenderLayer;


@Environment(EnvType.CLIENT)
public class EndlessMatrixEntityRenderer extends EndlessRenderer<EndlessMatrixEntity> implements BlockEntityRenderer<EndlessMatrixEntity, EndlessRenderState> {
    @Override
    public void render(EndlessRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        //queue.submitCustom(
        //        matrices, matrixRenderLayer,
        //        (entry, vertices) -> renderSides(
        //                direction -> state.sides.getOrDefault(direction, false),
        //                entry.getPositionMatrix(),
        //                vertices
        //        )
        //);
    }

    @Override
    public EndlessRenderState createRenderState() {
        return new EndlessRenderState();
    }

    @Override
    public int getRenderDistance() {
        return 256;
    }
}
