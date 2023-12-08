package games.twinhead.flowers;

import games.twinhead.flowers.registry.LootTablesRegistry;
import games.twinhead.flowers.registry.ModRegistry;
import games.twinhead.flowers.entity.EntityRegistry;
import games.twinhead.flowers.entity.Villager;
import net.fabricmc.api.ModInitializer;

public class Flowers implements ModInitializer {
    public static final String MOD_ID = "flowers";

    @Override
    public void onInitialize() {
        ModRegistry.register();
        EntityRegistry.register();
        LootTablesRegistry.register();

        Villager.register();
        Villager.registerTrades();
    }


}
