package org.dimdev.matrix;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

public class RegistrationDriver {

    @Mod.EventHandler
    public void registerBlock(RegistryEvent.Register<Block> event) {
        for (Object block : Matrix.getBlockQueue()) {
            Block b = (Block) block;
            event.getRegistry().register(b);
        }
    }

    @Mod.EventHandler
    public void registerItem(RegistryEvent.Register<Item> event) {

    }

}
