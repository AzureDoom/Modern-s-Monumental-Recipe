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
		public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernRecipesMod.MODID);

		/**
		 * This is just a simple item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
		 */
		public static final RegistryObject<Item> COMPRESSED_IRON_PLATE = ITEMS.register("compressed_iron_plate", () -> new Item(new Item.Properties()));
		public static final RegistryObject<Item> Tool_Toolbox = ITEMS.register("tool_toolbox", () -> new Item(new Item.Properties()));

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
				// Sets the tabs lang file name
				.title(Component.translatable("itemGroup." + ModernRecipesMod.MODID + ".items"))
				// Sets tab icon item or block
				.icon(() -> new ItemStack(ModItems.COMPRESSED_IRON_PLATE.get()))
				// Sets the items in the tab, in the order that you register them here
				.displayItems((enabledFeatures, entries) -> {
					entries.accept(ModItems.COMPRESSED_IRON_PLATE.get());
					entries.accept(ModItems.Tool_Toolbox.get());
					entries.accept(ModItems.EXAMPLE_BLOCK_ITEM.get());
				}).build());
	}
}
