package net.endless_horizons.blocks;

import net.endless_horizons.blocks.end.EndlessEndBlock;
import net.endless_horizons.blocks.sky.EndlessSkyBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import java.util.EnumMap;
import java.util.List;
import java.util.function.Function;

import static net.endless_horizons.EndlessHorizons.MOD_ID;


public class EndlessBlocks {
    public static final TagKey<Block> NO_OUTLINE = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, "no_outline"));
    public static final RegistryKey<ItemGroup> endlessHorizonsGroup = RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "endless_blocks"));

    public static final EnumMap<DyeColor, Block> BLOCKS = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> DOORS = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> TRAPDOORS = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> PRESSURE_PLATES = new EnumMap<>(DyeColor.class);
    public static final EnumMap<DyeColor, Block> BUTTONS = new EnumMap<>(DyeColor.class);

    public static Block ENDLESS_END;
    public static Block ENDLESS_SKY;
    //public static final EndlessMatrixBlock ENDLESS_MATRIX_BLOCK = new EndlessMatrixBlock(blockSettings.sounds(BlockSoundGroup.GLASS));

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(MOD_ID, "endless_" + path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        ItemGroupEvents.modifyEntriesEvent(endlessHorizonsGroup).register(content -> content.add(block));
        return block;
    }

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, endlessHorizonsGroup, FabricItemGroup.builder()
                       .icon(() -> new ItemStack(BLOCKS.get(DyeColor.WHITE)))
                       .displayName(Text.translatable("itemGroup." + MOD_ID + ".endless_blocks"))
                       .build());

        for (var color : DyeColor.values()) {
            BLOCKS.put(color, register(color.asString(), Block::new, Block.Settings.create()
                    .mapColor(color.getMapColor())
                    .strength(1.5f, 6.0f)
                    .luminance(state -> 15)
                    .sounds(BlockSoundGroup.STONE)
            ));
            DOORS.put(color, register(color.asString() + "_door",
                    settings -> new DoorBlock(BlockSetType.STONE, settings), AbstractBlock.Settings.create()
                            .mapColor(color.getMapColor())
                            .luminance(state -> 15)
            ));
            TRAPDOORS.put(color, register(color.asString() + "_trapdoor",
                    settings -> new TrapdoorBlock(BlockSetType.STONE, settings), AbstractBlock.Settings.create()
                            .mapColor(color.getMapColor())
                            .luminance(state -> 15)
            ));
            PRESSURE_PLATES.put(color, register(
                    color.asString() + "_pressure_plate",
                    settings -> new PressurePlateBlock(BlockSetType.STONE, settings), AbstractBlock.Settings.create()
                            .mapColor(color.getMapColor())
                            .luminance(state -> 15)
                            .noCollision()
            ));
            BUTTONS.put(color, register(
                    color.asString() + "_button",
                    settings -> new ButtonBlock(BlockSetType.STONE, 20, settings), AbstractBlock.Settings.create()
                            .mapColor(color.getMapColor())
                            .luminance(state -> 15)
                            .noCollision()
            ));
        }
        ENDLESS_END = register("end", EndlessEndBlock::new, Block.Settings.create().sounds(BlockSoundGroup.STONE));
        ENDLESS_SKY = register("sky", EndlessSkyBlock::new, Block.Settings.create().sounds(BlockSoundGroup.STONE));
        //register(ENDLESS_SKY_BLOCK, "sky");
        //register(ENDLESS_MATRIX_BLOCK, "matrix");

    }
}
