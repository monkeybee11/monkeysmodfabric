package name.modid.monsters;

import name.modid.monsters.custom.BananaEntity;
import name.modid.monsters.custom.CoconutEntity;
import name.modid.monsters.custom.MeatEntity;
import name.modid.monsters.custom.MincepieEntity;
import name.modid.monsters.custom.PineappleEntity;
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


}
