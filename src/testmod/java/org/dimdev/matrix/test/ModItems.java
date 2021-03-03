package org.dimdev.matrix.test;

import org.dimdev.matrix.Registrar;
import org.dimdev.matrix.RegistryEntry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

@Registrar(element = Item.class, modid = "matrix-test")
public class ModItems {
	@RegistryEntry("test_item")
	public static final Item ITEM = new BlockItem(ModBlocks.BLOCK, new Item.Settings().group(ItemGroup.FOOD));
}
