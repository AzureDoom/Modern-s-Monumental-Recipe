package com.azuredoom.modernrecipes;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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

	public static final ItemGroup ITEMS_TAB = (new ItemGroup(ModernRecipesMod.MODID + ".items") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.COMPRESSED_IRON_PLATE.get());
		}
	});

	public static class ModItems {
		public final static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModernRecipesMod.MODID);

		/**
		 * This is just a simple item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
		 */
		public static final RegistryObject<Item> COMPRESSED_IRON_PLATE = ITEMS.register("compressed_iron_plate", () -> new Item(new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));

		/**
		 * This is just a simple block item, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple item that exists.
		 */
		public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("changeme", () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(), new Item.Properties().tab(ModernRecipesMod.ITEMS_TAB)));
	}

	public static class ModBlocks {
		public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModernRecipesMod.MODID);

		/**
		 * This is just a simple block, allowing you to register it for use in your recipes. Doesn't do anything fancy, is just a simple block that exists.
		 */
		public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("changeme", () -> new Block(AbstractBlock.Properties.of(Material.WOOD).strength(2.5F).sound(SoundType.WOOD)));
	}
}
