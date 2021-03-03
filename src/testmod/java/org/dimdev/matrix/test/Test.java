package org.dimdev.matrix.test;

import org.dimdev.matrix.Matrix;

import net.minecraft.util.registry.Registry;

import net.fabricmc.api.ModInitializer;

public class Test implements ModInitializer {
	@Override
	public void onInitialize() {
		Matrix.register(ModBlocks.class, Registry.BLOCK);
		Matrix.register(ModItems.class, Registry.ITEM);
	}
}
