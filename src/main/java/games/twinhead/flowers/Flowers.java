package games.twinhead.flowers;

import net.fabricmc.api.ModInitializer;

public class Flowers implements ModInitializer {
    public static final String modID = "flowers";

    @Override
    public void onInitialize() {
        BlockRegistry.register();
    }
}
