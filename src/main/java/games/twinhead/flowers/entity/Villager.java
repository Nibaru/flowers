package games.twinhead.flowers.entity;

import com.google.common.collect.ImmutableSet;
import games.twinhead.flowers.Flower;
import games.twinhead.flowers.Flowers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Villager {
    public static final Set<Item> tierOneSeeds = new HashSet<>(List.of(new Item[]{
            Flower.POPPY.getSeeds(),
            Flower.DANDELION.getSeeds(),
            Flower.AZURE_BLUET.getSeeds(),
            Flower.RED_TULIP.getSeeds(),
            Flower.PINK_TULIP.getSeeds(),
            Flower.WHITE_TULIP.getSeeds(),
            Flower.ORANGE_TULIP.getSeeds(),
            Flower.AZURE_BLUET.getSeeds(),
            Flower.OXEYE_DAISY.getSeeds(),
            Flower.CORNFLOWER.getSeeds()
    }));

    public static final Set<Item> tierTwoSeeds = new HashSet<>(List.of(new Item[]{
            Flower.BLUE_ORCHID.getSeeds(),
            Flower.ALLIUM.getSeeds(),
            Flower.LILY_OF_THE_VALLEY.getSeeds(),
            Items.TORCHFLOWER_SEEDS
    }));


    public static final Set<Item> tierOneFlowers = new HashSet<>(List.of(new Item[]{
            Items.POPPY,
            Items.DANDELION,
            Items.AZURE_BLUET,
            Items.RED_TULIP,
            Items.PINK_TULIP,
            Items.WHITE_TULIP,
            Items.ORANGE_TULIP,
            Items.AZURE_BLUET,
            Items.OXEYE_DAISY,
            Items.CORNFLOWER
    }));

    public static final Set<Item> tierTwoFlowers = new HashSet<>(List.of(new Item[]{
            Items.BLUE_ORCHID,
            Items.ALLIUM,
            Items.LILY_OF_THE_VALLEY,
            Items.TORCHFLOWER
    }));

    public static final Set<Item> tallFlowers = new HashSet<>(List.of(new Item[]{
            Items.ROSE_BUSH,
            Items.LILAC,
            Items.PEONY,
            Items.SUNFLOWER,
            Items.LARGE_FERN,
            Items.AZALEA,
            Items.FLOWERING_AZALEA,
    }));

    public static final Set<Item> saplings = new HashSet<>(List.of(new Item[]{
            Items.SPRUCE_SAPLING,
            Items.ACACIA_SAPLING,
            Items.BIRCH_SAPLING,
            Items.OAK_SAPLING,
            Items.JUNGLE_SAPLING,
            Items.DARK_OAK_SAPLING,
    }));




    public static final PointOfInterestType FLORIST_POI = registerPOI("florist_poi");
    public static final VillagerProfession FLORIST = registerProfession("florist", RegistryKey.of(Registries.POINT_OF_INTEREST_TYPE.getKey(), new Identifier(Flowers.modID, "florist_poi")));

    @SuppressWarnings("deprecation")
    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Flowers.modID, name),
                VillagerProfessionBuilder.create().id(new Identifier(Flowers.modID, name)).workstation(type)
                        .workSound(SoundEvents.ENTITY_VILLAGER_WORK_ARMORER).build());
    }

    public static PointOfInterestType registerPOI(String name) {
        return PointOfInterestHelper.register(new Identifier(Flowers.modID, name),
                1, 1, getAllFlowerPotStates());
    }

    public static Set<net.minecraft.block.BlockState> getAllFlowerPotStates(){
        Set<net.minecraft.block.BlockState> states = new HashSet<>();
        states.addAll(ImmutableSet.copyOf(Blocks.FLOWER_POT.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_ALLIUM.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_AZURE_BLUET.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_BLUE_ORCHID.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_DANDELION.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_POPPY.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_RED_TULIP.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_ORANGE_TULIP.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_WHITE_TULIP.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_PINK_TULIP.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_OXEYE_DAISY.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_CORNFLOWER.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_LILY_OF_THE_VALLEY.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_WITHER_ROSE.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_OAK_SAPLING.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_ACACIA_SAPLING.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_DARK_OAK_SAPLING.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_BIRCH_SAPLING.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_JUNGLE_SAPLING.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_SPRUCE_SAPLING.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_MANGROVE_PROPAGULE.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_CACTUS.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_FERN.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_DEAD_BUSH.getStateManager().getStates()));
        states.addAll(ImmutableSet.copyOf(Blocks.POTTED_TORCHFLOWER.getStateManager().getStates()));
        return states;
    }

    public static void register() {
        Flowers.LOGGER.debug("Registering Villagers for " + Flowers.modID);
        FLORIST_POI.toString();
    }

    public static void registerTrades() {
        TradeOfferHelper.registerVillagerOffers(FLORIST,1, factories -> {
            for (Item item: tierOneSeeds) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, random.nextBetween(2, 4)),
                        new ItemStack(item, random.nextBetween(2, 4)),
                        8, 1, 0.02f
                )));
            }

            for (Item item: tierOneFlowers) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(item, random.nextBetween(10, 22)),
                        new ItemStack(Items.EMERALD, 1),
                        8, 2, 0.02f
                )));
            }
        });

        TradeOfferHelper.registerVillagerOffers(FLORIST,2, factories -> {
            for (Item item: tierTwoFlowers) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(item, random.nextBetween(9, 25)),
                        new ItemStack(Items.EMERALD, 1),
                        8, 4, 0.02f
                )));
            }

            for (Item item: tallFlowers) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, random.nextBetween(2, 8)),
                        new ItemStack(item, random.nextBetween(1, 4)),
                        6, 6, 0.02f
                )));
            }

            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, random.nextBetween(1, 4)),
                    new ItemStack(Items.FLOWER_POT, 1),
                    10, 6, 0.02f
            )));
        });

        TradeOfferHelper.registerVillagerOffers(FLORIST,3, factories -> {
            for (Item item: tierTwoSeeds) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, random.nextBetween(2, 4)),
                        new ItemStack(item, random.nextBetween(2, 4)),
                        8, 6, 0.02f
                )));
            }

            for (Item item: saplings) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(Items.EMERALD, random.nextBetween(4, 10)),
                        new ItemStack(item, 1),
                        4, 4, 0.02f
                )));
            }
        });

        TradeOfferHelper.registerVillagerOffers(FLORIST,4, factories -> {
            for (Item item: tierTwoFlowers) {
                factories.add(((entity, random) -> new TradeOffer(
                        new ItemStack(item, random.nextBetween(14, 23)),
                        new ItemStack(Items.EMERALD, 1),
                        8, 10, 0.02f
                )));
            }

            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, random.nextBetween(8, 16)),
                    new ItemStack(Items.SMALL_DRIPLEAF, 1),
                    4, 8, 0.02f
            )));

            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, random.nextBetween(12, 18)),
                    new ItemStack(Items.BIG_DRIPLEAF, 1),
                    2, 12, 0.02f
            )));


        });

        TradeOfferHelper.registerVillagerOffers(FLORIST,5, factories -> {
            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, random.nextBetween(8, 16)),
                    new ItemStack(Items.SPORE_BLOSSOM, 1),
                    4, 12, 0.02f
            )));


            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, random.nextBetween(20, 64)),
                    new ItemStack(Flower.WITHER_ROSE.getSeeds(), random.nextBetween(1, 3)),
                    4, 12, 0.02f
            )));

            factories.add(((entity, random) -> new TradeOffer(
                    new ItemStack(Items.WITHER_ROSE, random.nextBetween(10, 25)),
                    new ItemStack(Items.EMERALD, random.nextBetween(1, 2)),
                    2, 12, 0.02f
            )));
        });
    }
}
