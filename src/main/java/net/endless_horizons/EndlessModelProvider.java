package net.endless_horizons;

//import net.endless_horizons.blocks.models.*;
//import net.fabricmc.fabric.api.client.model.ModelProviderContext;
//import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.BiConsumer;

import static net.endless_horizons.EndlessHorizons.MOD_ID;
import static net.endless_horizons.blocks.EndlessBlocks.*;
import static net.minecraft.client.data.BlockStateModelGenerator.*;


public class EndlessModelProvider extends FabricModelProvider {
    private static final Model NO_SHADE = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_no_shade")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_BOTTOM_LEFT = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_bottom_left")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_BOTTOM_LEFT_OPEN = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_bottom_left_open")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_BOTTOM_RIGHT = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_bottom_right")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_BOTTOM_RIGHT_OPEN = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_bottom_right_open")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_TOP_LEFT = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_top_left")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_TOP_LEFT_OPEN = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_top_left_open")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_TOP_RIGHT = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_top_right")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model DOOR_TOP_RIGHT_OPEN = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_door_top_right_open")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model TRAPDOOR_TOP = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_trapdoor_top")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model TRAPDOOR_BOTTOM = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_trapdoor_bottom")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model TRAPDOOR_OPEN = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_trapdoor_open")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model PRESSURE_PLATE = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_pressure_plate")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model PRESSURE_PLATE_DOWN = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_pressure_plate_down")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model BUTTON = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_button")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);
    private static final Model BUTTON_PRESSED = new Model(Optional.of(Identifier.of(MOD_ID, "block/template_button_pressed")), Optional.empty(), TextureKey.ALL, TextureKey.PARTICLE);



    public EndlessModelProvider(FabricDataOutput output) {
        super(output);
    }

    private Identifier getPath(Block block, String suffix) {
        return Identifier.of(MOD_ID, "block/" + Registries.BLOCK.getId(block).getPath() + suffix);
    }

    private void registerDoor(BlockStateModelGenerator generator, Block doorBlock, Block block) {
        WeightedVariant weightedVariant = createWeightedVariant(DOOR_BOTTOM_LEFT.upload(getPath(doorBlock, "_bottom_left"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant2 = createWeightedVariant(DOOR_BOTTOM_LEFT_OPEN.upload(getPath(doorBlock, "_bottom_left_open"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant3 = createWeightedVariant(DOOR_BOTTOM_RIGHT.upload(getPath(doorBlock, "_bottom_right"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant4 = createWeightedVariant(DOOR_BOTTOM_RIGHT_OPEN.upload(getPath(doorBlock, "_bottom_right_open"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant5 = createWeightedVariant(DOOR_TOP_LEFT.upload(getPath(doorBlock, "_top_left"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant6 = createWeightedVariant(DOOR_TOP_LEFT_OPEN.upload(getPath(doorBlock, "_top_left_open"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant7 = createWeightedVariant(DOOR_TOP_RIGHT.upload(getPath(doorBlock, "_top_right"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant8 = createWeightedVariant(DOOR_TOP_RIGHT_OPEN.upload(getPath(doorBlock, "_top_right_open"), TextureMap.all(block), generator.modelCollector));
        generator.registerItemModel(doorBlock.asItem());
        generator.blockStateCollector.accept(createDoorBlockState(doorBlock, weightedVariant, weightedVariant2, weightedVariant3, weightedVariant4, weightedVariant5, weightedVariant6, weightedVariant7, weightedVariant8));
    }

    private void registerTrapdoor(BlockStateModelGenerator generator, Block trapdoorBlock, Block block) {
        WeightedVariant weightedVariant = createWeightedVariant(TRAPDOOR_TOP.upload(getPath(trapdoorBlock, "_trapdoor_top"), TextureMap.all(block), generator.modelCollector));
        Identifier identifier = TRAPDOOR_BOTTOM.upload(getPath(trapdoorBlock, "_trapdoor_bottom"), TextureMap.all(block), generator.modelCollector);
        WeightedVariant weightedVariant2 = createWeightedVariant(TRAPDOOR_OPEN.upload(getPath(trapdoorBlock, "_trapdoor_open"), TextureMap.all(block), generator.modelCollector));
        generator.blockStateCollector.accept(createTrapdoorBlockState(trapdoorBlock, weightedVariant, createWeightedVariant(identifier), weightedVariant2));
        generator.registerParentedItemModel(trapdoorBlock, identifier);
    }

    private void registerPressurePlate(BlockStateModelGenerator generator, Block plateBlock, Block block) {
        Identifier identifier = PRESSURE_PLATE.upload(getPath(plateBlock, "_pressure_plate"), TextureMap.all(block), generator.modelCollector);
        WeightedVariant weightedVariant = createWeightedVariant(identifier);
        WeightedVariant weightedVariant2 = createWeightedVariant(PRESSURE_PLATE_DOWN.upload(getPath(plateBlock, "_pressure_plate_down"), TextureMap.all(block), generator.modelCollector));
        generator.blockStateCollector.accept(createPressurePlateBlockState(plateBlock, weightedVariant, weightedVariant2));
        generator.registerParentedItemModel(plateBlock, identifier);
    }

    private void registerButton(BlockStateModelGenerator generator, Block buttonBlock, Block block) {
        WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(BUTTON.upload(getPath(buttonBlock, "_button"), TextureMap.all(block), generator.modelCollector));
        WeightedVariant weightedVariant2 = BlockStateModelGenerator.createWeightedVariant(BUTTON_PRESSED.upload(getPath(buttonBlock, "_button_pressed"), TextureMap.all(block), generator.modelCollector));

        generator.blockStateCollector.accept(BlockStateModelGenerator.createButtonBlockState(buttonBlock, weightedVariant, weightedVariant2));
        Identifier identifier = Models.BUTTON_INVENTORY.upload(getPath(buttonBlock, "_button_inventory"), TextureMap.all(block), generator.modelCollector);
        generator.registerParentedItemModel(buttonBlock, identifier);
    }

    @Override
    public void generateBlockStateModels(@NotNull BlockStateModelGenerator blockStateModelGenerator) {
        for (var color : DyeColor.values()) {
            Block block = BLOCKS.get(color);

            blockStateModelGenerator.registerSimpleState(block);
            NO_SHADE.upload(ModelIds.getBlockModelId(block), TextureMap.all(block), blockStateModelGenerator.modelCollector);

            registerDoor(blockStateModelGenerator, DOORS.get(color), block);
            registerTrapdoor(blockStateModelGenerator, TRAPDOORS.get(color), block);
            registerPressurePlate(blockStateModelGenerator, PRESSURE_PLATES.get(color), block);
            registerButton(blockStateModelGenerator, BUTTONS.get(color), block);
        }
    }

    @Override
    public void generateItemModels(@NotNull ItemModelGenerator itemModelGenerator) {

    }

    @Override
    public String getName() {
        return "EndlessModelProvider";
    }
}
