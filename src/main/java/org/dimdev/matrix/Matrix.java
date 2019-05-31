package org.dimdev.matrix;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Matrix {

    Logger LOG = LogManager.getLogger("Matrix");

    private static ArrayList blockQueue;
    private static ArrayList itemQueue;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        LOG.info("Preinitialization Stage");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        LOG.info("Initialization Stage");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        LOG.info("Post Initialization Stage");
    }

    public static void initializeBlockQueue() {
        blockQueue = new ArrayList<>();
    }

    public static void initializeItemQueue() {
        itemQueue = new ArrayList<>();
    }

    public static void addBlock(Object block) {
        blockQueue.add(block);
    }

    public static void addItem(Object item) {
        itemQueue.add(item);
    }

    public static ArrayList getBlockQueue() {
        return blockQueue;
    }

    public static ArrayList getItemQueue() {
        return itemQueue;
    }

}
