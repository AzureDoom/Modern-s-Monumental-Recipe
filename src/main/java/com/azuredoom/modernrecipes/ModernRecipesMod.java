package com.azuredoom.modernrecipes;

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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(ModernRecipesMod.MODID)
public class ModernRecipesMod {
	public static final String MODID = "modernrecipes";

	public ModernRecipesMod() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		MinecraftForge.EVENT_BUS.register(this);
		ModBlocks.BLOCKS.register(modEventBus);
		ModItems.ITEMS.register(modEventBus);
		ModTabs.TABS.register(modEventBus);
	}

	public class ModItems {
		public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernRecipesMod.MODID);
		public static final RegistryObject<Item> COMPRESSED_IRON_PLATE = ITEMS.register("compressed_iron_plate", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> TOOL_TOOLBOX = ITEMS.register("tool_toolbox", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> PART_PLATE_SMALL_WOOD = ITEMS.register("part_plate_small_wood", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Stone_Rod = ITEMS.register("stone_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Acacia_Rod = ITEMS.register("acacia_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Birch_Rod = ITEMS.register("birch_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Dark_Oak_Rod = ITEMS.register("dark_oak_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Jungle_Rod = ITEMS.register("jungle_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Oak_Rod = ITEMS.register("oak_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Spruce_Rod = ITEMS.register("spruce_rod", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Clay_Plate = ITEMS.register("clay_plate", () -> new Item(new Item.Properties()));

		/**
		 * This is just a simple block item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
		 */
		public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("changeme", () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(), new Item.Properties()));
	}

	public class ModBlocks {
		public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernRecipesMod.MODID);

		/**
		 * This is just a simple block, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple block that exists.
		 */
		public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("notreadyyet", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));
	}

	public class ModTabs {
		public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModernRecipesMod.MODID);

		public static final RegistryObject<CreativeModeTab> ITEMS_TAB = TABS.register("items", () -> CreativeModeTab.builder()
				.title(Component.translatable("itemGroup." + ModernRecipesMod.MODID + ".items"))
				.icon(() -> new ItemStack(ModItems.COMPRESSED_IRON_PLATE.get()))
				.icon(() -> new ItemStack(ModItems.TOOL_TOOLBOX.get()))
				.icon(() -> new ItemStack(ModItems.PART_PLATE_SMALL_WOOD.get()))
				.icon(() -> new ItemStack(ModItems.Stone_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Acacia_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Birch_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Dark_Oak_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Jungle_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Oak_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Spruce_Rod.get()))
				.icon(() -> new ItemStack(ModItems.Clay_Plate.get()))
				.displayItems((enabledFeatures, entries) -> {
					entries.accept(ModItems.COMPRESSED_IRON_PLATE.get());
					entries.accept(ModItems.TOOL_TOOLBOX.get());
					entries.accept(ModItems.PART_PLATE_SMALL_WOOD.get());
					entries.accept(ModItems.Stone_Rod.get());
					entries.accept(ModItems.Acacia_Rod.get());
					entries.accept(ModItems.Birch_Rod.get());
					entries.accept(ModItems.Dark_Oak_Rod.get());
					entries.accept(ModItems.Jungle_Rod.get());
					entries.accept(ModItems.Oak_Rod.get());
					entries.accept(ModItems.Spruce_Rod.get());
					entries.accept(ModItems.Clay_Plate.get());
					entries.accept(ModItems.EXAMPLE_BLOCK_ITEM.get());
				}).build());
	}
}
