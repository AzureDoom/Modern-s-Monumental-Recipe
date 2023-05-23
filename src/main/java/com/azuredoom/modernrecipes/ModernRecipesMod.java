package com.azuredoom.modernrecipes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ModernRecipesMod.MODID)
public class ModernRecipesMod {
	public static final String MODID = "modernrecipes";

	public ModernRecipesMod() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
