package org.dimdev.matrix.test;

import dev.architectury.registry.block.BlockProperties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.dimdev.matrix.Registrar;
import org.dimdev.matrix.RegistryEntry;

@Registrar(element = Block.class, modid = "matrix-test")
public class ModBlocks {
	@RegistryEntry("test_block")
	public static final Block BLOCK = new Block(BlockBehaviour.Properties.copy(Blocks.DIRT));
}
