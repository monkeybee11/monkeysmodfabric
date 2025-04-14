package name.modid.monsters;

import name.modid.monsters.custom.BananaEntity;
import name.modid.monsters.custom.BananaPeelEntity;
import name.modid.monsters.custom.CherryBombEntity;
import name.modid.monsters.custom.ChristmasTreeEntity;
import name.modid.monsters.custom.CoconutEntity;
import name.modid.monsters.custom.MeatEntity;
import name.modid.monsters.custom.MincepieEntity;
import name.modid.monsters.custom.PineappleEntity;
import name.modid.monsters.custom.PizzaBoss;
import name.modid.monsters.custom.SantaPigEntity;
import name.modid.monsters.custom.TapeEntity;
import name.modid.monsters.pizzatopping.PizzaTopping;
import name.modid.monsters.custom.AppleEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
        public static final EntityType<BananaEntity> BANANAMONSTER = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "banana_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, BananaEntity::new)
                        .dimensions(EntityDimensions.fixed(0.8f, 1.4f)).build());

        public static final EntityType<AppleEntity> APPLEMONSTER = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "apple_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AppleEntity::new)
                        .dimensions(EntityDimensions.fixed(0.8f, 1.4f)).build());

        public static final EntityType<PineappleEntity> PINEAPPLEMONSTER = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "pineapple_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PineappleEntity::new)
                        .dimensions(EntityDimensions.fixed(0.8f, 1.5f)).build());

        public static final EntityType<CoconutEntity> COOCNUTMONSTER = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "coconut_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CoconutEntity::new)
                        .dimensions(EntityDimensions.fixed(1, 1)).build());

        public static final EntityType<MeatEntity> MEATMONSTER = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "meat_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MeatEntity::new)
                        .dimensions(EntityDimensions.fixed(1, 1.5f)).build());

        public static final EntityType<MincepieEntity> MINCEPIE = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "mincepie_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MincepieEntity::new)
                        .dimensions(EntityDimensions.fixed(1, 1.5f)).build());

        public static final EntityType<PizzaBoss> PIZZABOSS = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "pizza_boss"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, PizzaBoss::new)
                        .dimensions(EntityDimensions.fixed(3, 1)).build());

        public static final EntityType<PizzaTopping> PIZZA_TOPPING = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "pizza_topping"),
                FabricEntityTypeBuilder.<PizzaTopping>create(SpawnGroup.MISC, (type, world) -> new PizzaTopping(type, world, 1, 1, 1))
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                        .trackRangeBlocks(4).trackedUpdateRate(10)
                        .build());

        public static final EntityType<ChristmasTreeEntity> CHRISTMAS_TREE = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "christmas_tree"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, ChristmasTreeEntity::new)
                        .dimensions(EntityDimensions.fixed(1, 2)).build());

        public static final EntityType<SantaPigEntity> SANTA_PIG = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "santa_pig"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, SantaPigEntity::new)
                        .dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build());

        public static final EntityType<CherryBombEntity> CHERRY_BOMB = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "cherry_bomb"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CherryBombEntity::new)
                        .dimensions(EntityDimensions.fixed(1, 1.4f)).build());

        public static final EntityType<BananaPeelEntity> BANANAPEEL = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "banana_peel_entity"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, BananaPeelEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

        public static final EntityType<TapeEntity> TAPE = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "tape_entity"),
                FabricEntityTypeBuilder.create(SpawnGroup.MISC, TapeEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());


}
