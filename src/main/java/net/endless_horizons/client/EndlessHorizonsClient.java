package net.endless_horizons.client;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
//import org.ladysnake.satin.api.event.ResolutionChangeCallback;
import net.endless_horizons.blocks.matrix.EndlessMatrixEntityRenderer;
import net.endless_horizons.blocks.sky.EndlessSkyEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientBlockEntityEvents;
//import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.endless_horizons.blocks.end.EndlessEndEntityRenderer;
//import net.fabricmc.fabric.api.client.rendering.v1.CoreShaderRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.SimpleFramebuffer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

import static net.endless_horizons.EndlessHorizons.*;


@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class EndlessHorizonsClient implements ClientModInitializer {
    //public static ShaderProgram skyShaderProgram;
    //public static ShaderProgram matrixShaderProgram;
    //public static SimpleFramebuffer matrixFramebuffer;
//
    //public static ShaderProgram getSkyShader() { return skyShaderProgram; }
    //public static ShaderProgram getMatrixShader() { return matrixShaderProgram; }
//
    //private static final RenderPipeline FILLED_THROUGH_WALLS = RenderPipelines.register(RenderPipeline.builder(RenderPipelines.RENDERTYPE_CLOUDS_SNIPPET)
    //        .withLocation(Identifier.of(MOD_ID, "pipeline/sky"))
    //        .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
    //        .build()
    //);
    //private static void setSkyTexture() { RenderSystem.setShaderTexture(0, matrixFramebuffer != null ? matrixFramebuffer.getColorAttachment() : 0); }
    //private static void setMatrixTexture() { RenderSystem.setShaderTexture(0, matrixFramebuffer.getColorAttachment()); }

    //public static final RenderLayer skyRenderLayer = RenderLayer.of(MOD_ID + "_sky", VertexFormats.POSITION, VertexFormat.DrawMode.QUADS, 256, false, false,
    //        RenderLayer.MultiPhaseParameters.builder()
    //                .program(new RenderPhase.ShaderProgram(EndlessHorizonsClient::getSkyShader))
    //                .texture(new RenderPhase.TextureBase(EndlessHorizonsClient::setSkyTexture, () -> {}))
    //                .build(false)
    //);
    //public static final RenderLayer matrixRenderLayer = RenderLayer.of(MOD_ID + "_matrix", VertexFormats.POSITION_TEXTURE_COLOR_NORMAL, VertexFormat.DrawMode.QUADS, 256, false, false,
    //        RenderLayer.MultiPhaseParameters.builder()
    //                .program(new RenderPhase.ShaderProgram(EndlessHorizonsClient::getMatrixShader))
    //                .texture(new RenderPhase.TextureBase(EndlessHorizonsClient::setMatrixTexture, () -> {}))
    //                .build(false)
    //);

    @Override
    public void onInitializeClient() {
        //ModelLoadingRegistry.INSTANCE.registerResourceProvider(rm -> new ModelProvider());
        BlockEntityRendererFactories.register(EndlessEndEntity, ctx -> new EndlessEndEntityRenderer());
        BlockEntityRendererFactories.register(EndlessSkyEntity, ctx -> new EndlessSkyEntityRenderer());
        //BlockEntityRendererFactories.register(EndlessMatrixEntity, ctx -> new EndlessMatrixEntityRenderer());
//
        //ClientBlockEntityEvents.BLOCK_ENTITY_LOAD.register(RenderSky::onLoad);
        //ClientBlockEntityEvents.BLOCK_ENTITY_UNLOAD.register(RenderSky::onUnload);
        //WorldRenderEvents.END_MAIN.register(RenderSky::render);
        //ResolutionChangeCallback.EVENT.register(RenderSky::resetFramebuffer);
//
        //ClientBlockEntityEvents.BLOCK_ENTITY_LOAD.register(RenderMatrix::onLoad);
        //ClientBlockEntityEvents.BLOCK_ENTITY_UNLOAD.register(RenderMatrix::onUnload);
        //WorldRenderEvents.LAST.register(RenderMatrix::render);
        //ResolutionChangeCallback.EVENT.register(RenderMatrix::resetFramebuffer);
//
        //CoreShaderRegistrationCallback.EVENT.register(context -> {
        //    Identifier id = Identifier.of(MOD_ID, "sky");
        //    context.register(id, VertexFormats.POSITION, program -> skyShaderProgram = program);
        //});
        //CoreShaderRegistrationCallback.EVENT.register(context -> {
        //    Identifier id = Identifier.of(MOD_ID, "matrix");
        //    context.register(id, VertexFormats.POSITION, program -> matrixShaderProgram = program);
        //});
    }
}
