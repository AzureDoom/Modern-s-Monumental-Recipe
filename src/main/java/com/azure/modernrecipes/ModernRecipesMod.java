package com.azure.modernrecipes;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(ModernRecipesMod.MODID)
public class ModernRecipesMod {
    public static final String MODID = "modernrecipes";
    private static final Supplier<Item> baseItem = () -> new Item(new Item.Properties());
    private static final Supplier<Item> exampleBlockItem = () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(),
            new Item.Properties());
    private static final Supplier<Block> exampleBlock = () -> new Block(
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(
                    2.5F).sound(SoundType.WOOD).ignitedByLava());

    public ModernRecipesMod(IEventBus modEventBus) {
        /**
         * Registers all the blocks from the ModBlocks class below, this doesn't need touched again.
         */
        ModBlocks.BLOCKS.register(modEventBus);
        /**
         * Registers all the items from the ModItems class below, this doesn't need touched again.
         */
        ModItems.ITEMS.register(modEventBus);
        /**
         * Registers all the tabs from the ModTabs class below, this doesn't need touched again.
         */
        ModTabs.TABS.register(modEventBus);
    }

    public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM,
                ModernRecipesMod.MODID);

        /**
         * This is just a simple item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
         */
        public static final Supplier<Item> COMPRESSED_IRON_PLATE = ITEMS.register("compressed_iron_plate", baseItem);
        public static final Supplier<Item> Tool_Toolbox = ITEMS.register("tool_toolbox", baseItem);
        public static final Supplier<Item> Stone_Rod  = ITEMS.register("stone_rod", baseItem);
        public static final Supplier<Item> Acacia_Rod = ITEMS.register("acacia_rod", baseItem);
        public static final Supplier<Item> Birch_Rod = ITEMS.register("birch_rod", baseItem);
        public static final Supplier<Item> Dark_Oak_Rod = ITEMS.register("dark_oak_rod", baseItem);
        public static final Supplier<Item> Jungle_Rod = ITEMS.register("jungle_rod", baseItem);
        public static final Supplier<Item> Oak_Rod = ITEMS.register("oak_rod", baseItem);
        public static final Supplier<Item> Spruce_Rod = ITEMS.register("spruce_rod", baseItem);
        public static final Supplier<Item> Clay_Plate = ITEMS.register("clay_plate", baseItem);
        public static final Supplier<Item> Part_Plate_Large_Wood = ITEMS.register("part_plate_large_wood", baseItem);
        public static final Supplier<Item> Part_Plate_Small_Wood = ITEMS.register("part_plate_small_wood", baseItem);
        public static final Supplier<Item> Part_Wood_Crosstie = ITEMS.register("part_wood_crosstie", baseItem);
        public static final Supplier<Item> Part_Cog_Wood = ITEMS.register("part_cog_wood", baseItem);
        public static final Supplier<Item> Part_Chainlinks = ITEMS.register("part_chainlinks", baseItem);

        /**
         * This is just a simple block item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
         */
        public static final Supplier<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("changeme", exampleBlockItem);
    }

    public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK,
                ModernRecipesMod.MODID);

        /**
         * This is just a simple block, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple block that exists.
         */
        public static final Supplier<Block> EXAMPLE_BLOCK = BLOCKS.register("notreadyyet", exampleBlock);
    }

    public class ModTabs {
        public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
                Registries.CREATIVE_MODE_TAB, ModernRecipesMod.MODID);

        public static final Supplier<CreativeModeTab> ITEMS_TAB = TABS.register("items", () -> CreativeModeTab.builder()
                // Sets the tabs lang file name
                .title(Component.translatable("itemGroup." + ModernRecipesMod.MODID + ".items"))
                // Sets tab icon item or block
                .icon(() -> new ItemStack(ModItems.COMPRESSED_IRON_PLATE.get())).icon(
                        () -> new ItemStack(ModItems.Tool_Toolbox.get())).icon(
                        () -> new ItemStack(ModItems.Stone_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Acacia_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Birch_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Dark_Oak_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Jungle_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Oak_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Spruce_Rod.get())).icon(
                        () -> new ItemStack(ModItems.Clay_Plate.get())).icon(
                        () -> new ItemStack(ModItems.Part_Wood_Crosstie.get())).icon(
                        () -> new ItemStack(ModItems.Part_Plate_Large_Wood.get())).icon(
                        () -> new ItemStack(ModItems.Part_Cog_Wood.get())).icon(
                        () -> new ItemStack(ModItems.Part_Chainlinks.get())).icon(
                        () -> new ItemStack(ModItems.Part_Plate_Small_Wood.get()))
                // Sets the items in the tab, in the order that you register them here
                .displayItems((enabledFeatures, entries) -> {
                    entries.accept(ModItems.COMPRESSED_IRON_PLATE.get());
                    entries.accept(ModItems.Tool_Toolbox.get());
                    entries.accept(ModItems.Stone_Rod.get());
                    entries.accept(ModItems.Acacia_Rod.get());
                    entries.accept(ModItems.Birch_Rod.get());
                    entries.accept(ModItems.Dark_Oak_Rod.get());
                    entries.accept(ModItems.Jungle_Rod.get());
                    entries.accept(ModItems.Oak_Rod.get());
                    entries.accept(ModItems.Spruce_Rod.get());
                    entries.accept(ModItems.Clay_Plate.get());
                    entries.accept(ModItems.Part_Wood_Crosstie.get());
                    entries.accept(ModItems.Part_Cog_Wood.get());
                    entries.accept(ModItems.Part_Chainlinks.get());
                    entries.accept(ModItems.Part_Plate_Small_Wood.get());
                    entries.accept(ModItems.Part_Plate_Large_Wood.get());
                    entries.accept(ModItems.EXAMPLE_BLOCK_ITEM.get());
                }).build());
    }
}
