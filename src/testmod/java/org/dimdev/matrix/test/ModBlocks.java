package org.dimdev.matrix.test;

import org.dimdev.matrix.Registrar;
import org.dimdev.matrix.RegistryEntry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

@Registrar(element = Block.class, modid = "matrix-test")
public class ModBlocks {
	@RegistryEntry("test_block")
	public static final Block BLOCK = new Block(AbstractBlock.Settings.copy(Blocks.DIRT));
}
