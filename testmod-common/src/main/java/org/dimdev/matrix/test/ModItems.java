package org.dimdev.matrix.test;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.dimdev.matrix.Registrar;
import org.dimdev.matrix.RegistryEntry;


@Registrar(element = Item.class, modid = "matrix-test")
public class ModItems {
	@RegistryEntry("test_item")
	public static final Item ITEM = new BlockItem(ModBlocks.BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_FOOD));
}
