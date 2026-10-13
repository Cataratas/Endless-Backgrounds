package net.endless_horizons;

import net.endless_horizons.blocks.EndlessBlocks;
import net.endless_horizons.blocks.end.EndlessEndEntity;
import net.endless_horizons.blocks.sky.EndlessSkyEntity;
import net.endless_horizons.blocks.matrix.EndlessMatrixEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static net.endless_horizons.blocks.EndlessBlocks.ENDLESS_END;
import static net.endless_horizons.blocks.EndlessBlocks.ENDLESS_SKY;

public class EndlessHorizons implements ModInitializer {
    public static String MOD_ID = "endless_horizons";
    public static BlockEntityType<EndlessEndEntity> EndlessEndEntity;
    public static BlockEntityType<EndlessSkyEntity> EndlessSkyEntity;
    public static BlockEntityType<EndlessMatrixEntity> EndlessMatrixEntity;

    @Override
    public void onInitialize() {
        EndlessBlocks.register();
        EndlessEndEntity = Registry.register(Registries.BLOCK_ENTITY_TYPE, MOD_ID + ":endless_end_entity", FabricBlockEntityTypeBuilder.create(EndlessEndEntity::new, ENDLESS_END).build());
        EndlessSkyEntity = Registry.register(Registries.BLOCK_ENTITY_TYPE, MOD_ID + ":endless_sky_entity", FabricBlockEntityTypeBuilder.create(EndlessSkyEntity::new, ENDLESS_SKY).build());
        //EndlessMatrixEntity = Registry.register(Registries.BLOCK_ENTITY_TYPE, MOD_ID + ":endless_matrix_entity", FabricBlockEntityTypeBuilder.create(EndlessMatrixEntity::new, ENDLESS_MATRIX_BLOCK).build(null));
    }
}
