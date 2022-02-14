package org.dimdev.matrix.test;

import net.minecraft.core.Registry;
import org.dimdev.matrix.Matrix;

public class Test {
	public static final String MOD_ID = "matrix_test";

	public static void init() {
		Matrix.register(ModBlocks.class, Registry.BLOCK_REGISTRY);
		Matrix.register(ModItems.class, Registry.ITEM_REGISTRY);
	}
}
