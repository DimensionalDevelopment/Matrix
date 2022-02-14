package dev.architectury.test.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.dimdev.matrix.test.Test;

@Mod(Test.MOD_ID)
public class TestModForge {
    public TestModForge() {
        EventBuses.registerModEventBus(Test.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        Test.init();
    }
}
