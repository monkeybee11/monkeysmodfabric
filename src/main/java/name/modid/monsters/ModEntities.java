package name.modid.monsters;

import name.modid.monsters.custom.BananaEntity;
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
                        .dimensions(EntityDimensions.fixed(1f, 2f)).build());

        public static final EntityType<AppleEntity> APPLEMONSTER = Registry.register(Registries.ENTITY_TYPE,
                new Identifier("monkeysmod", "apple_monster"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AppleEntity::new)
                        .dimensions(EntityDimensions.fixed(1f, 2f)).build());
}
