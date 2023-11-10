package com.azuredoom.modernrecipes;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
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
	}

	public static final CreativeModeTab ITEMS_TAB = (new CreativeModeTab(ModernRecipesMod.MODID + ".items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.COMPRESSED_IRON_PLATE.get());
		}
	});

	public class ModItems {
		public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernRecipesMod.MODID);

		/**
		 * This is just a simple item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
		 */
		public static final RegistryObject<Item> COMPRESSED_IRON_PLATE = ITEMS.register("compressed_iron_plate", () -> new Item(new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));
		public static final RegistryObject<Item> TOOL_TOOLBOX = ITEMS.register("tool_toolbox", () -> new Item(new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));
		public static final RegistryObject<Item> PART_PLATE_SMALL_WOOD = ITEMS.register("part_plate_small_wood", () -> new Item(new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));
		public static final RegistryObject<Item> Stone_Rod = ITEMS.register("stone_rod", () -> new Item(new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));

		/**
		 * This is just a simple block item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
		 */
		public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("changeme", () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(), new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));
	}

	public class ModBlocks {
		public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernRecipesMod.MODID);

		/**
		 * This is just a simple block, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple block that exists.
		 */
		public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("changeme", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	}
}
