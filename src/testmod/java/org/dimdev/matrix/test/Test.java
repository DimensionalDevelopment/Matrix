package org.dimdev.matrix.test;

import org.dimdev.matrix.Matrix;

import net.minecraft.registry.Registries;

import net.fabricmc.api.ModInitializer;

public class Test implements ModInitializer {
	@Override
	public void onInitialize() {
		Matrix.register(ModBlocks.class, Registries.BLOCK);
		Matrix.register(ModItems.class, Registries.ITEM);
	}
}
