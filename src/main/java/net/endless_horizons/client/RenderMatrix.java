package net.endless_horizons.client;

//import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.world.ClientWorld;

import static net.endless_horizons.EndlessHorizons.EndlessMatrixEntity;
//import static net.endless_horizons.client.EndlessHorizonsClient.matrixFramebuffer;

public class RenderMatrix {
    protected static int shouldRenderMatrix = 0;
    public static void onLoad(BlockEntity blockEntity, ClientWorld clientWorld) {
        if (blockEntity.getType() == EndlessMatrixEntity) { shouldRenderMatrix += 1; }
    }

    public static void onUnload(BlockEntity blockEntity, ClientWorld clientWorld) {
        if (blockEntity.getType() == EndlessMatrixEntity) { shouldRenderMatrix -= 1; }
    }

    //public static void render(WorldRenderContext context) {
    //    if (shouldRenderMatrix <= 0) { return; }
//
    //    MinecraftClient client = MinecraftClient.getInstance();
    //    Framebuffer mainFramebuffer = client.getFramebuffer();
//
    //    client.gameRenderer.setBlockOutlineEnabled(false);
    //    matrixFramebuffer.beginWrite(true);
//
    //    matrixFramebuffer.endRead(); matrixFramebuffer.endWrite();
    //    client.gameRenderer.setBlockOutlineEnabled(true);
    //    mainFramebuffer.beginWrite(true);
    //}
//
    //public static void resetFramebuffer(int w, int h) {
    //    matrixFramebuffer = new SimpleFramebuffer(w, h, true, MinecraftClient.IS_SYSTEM_MAC);
    //}


}
