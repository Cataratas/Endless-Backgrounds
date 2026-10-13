package net.endless_horizons.blocks;

import net.endless_horizons.blocks.end.EndlessEndEntity;
import net.endless_horizons.blocks.matrix.EndlessMatrixEntity;
import net.endless_horizons.blocks.sky.EndlessSkyEntity;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import org.joml.Matrix4f;

import java.util.function.Predicate;

public abstract class EndlessRenderer<T extends EndlessEntity> {

    protected void renderSides(Predicate<Direction> shouldDrawSide, Matrix4f matrix, VertexConsumer vertexConsumer) {
        renderSide(shouldDrawSide, matrix, vertexConsumer, 0, 1, 0, 1, 1, 1, 1, 1, Direction.SOUTH);
        renderSide(shouldDrawSide, matrix, vertexConsumer, 0, 1, 1, 0, 0, 0, 0, 0, Direction.NORTH);
        renderSide(shouldDrawSide, matrix, vertexConsumer, 1, 1, 1, 0, 0, 1, 1, 0, Direction.EAST);
        renderSide(shouldDrawSide, matrix, vertexConsumer, 0, 0, 0, 1, 0, 1, 1, 0, Direction.WEST);
        renderSide(shouldDrawSide, matrix, vertexConsumer, 0, 1, 0, 0, 0, 0, 1, 1, Direction.DOWN);
        renderSide(shouldDrawSide, matrix, vertexConsumer, 0, 1, 1, 1, 1, 1, 0, 0, Direction.UP);
    }

    private void renderSide(Predicate<Direction> shouldDrawSide, Matrix4f model, VertexConsumer vertices,
                            float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4, Direction direction) {
        if (shouldDrawSide.test(direction)) {
            vertices.vertex(model, x1, y1, z1).texture(0,0);
            vertices.vertex(model, x2, y1, z2).texture(0,0);
            vertices.vertex(model, x2, y2, z3).texture(0,0);
            vertices.vertex(model, x1, y2, z4).texture(0,0);
        }
    }
}
