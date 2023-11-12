package name.modid.world.gen;

import name.modid.monsters.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {

        //banana
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE), SpawnGroup.MONSTER, ModEntities.BANANAMONSTER, 35, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE), SpawnGroup.MONSTER, ModEntities.BANANAMONSTER, 35, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SPARSE_JUNGLE), SpawnGroup.MONSTER, ModEntities.BANANAMONSTER, 35, 1, 5);
        SpawnRestriction.register(ModEntities.BANANAMONSTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        //apple
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.MONSTER, ModEntities.APPLEMONSTER, 35, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.MONSTER, ModEntities.APPLEMONSTER, 35, 1, 5);
        SpawnRestriction.register(ModEntities.APPLEMONSTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        //pineapple
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.MONSTER, ModEntities.PINEAPPLEMONSTER, 35, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE), SpawnGroup.MONSTER, ModEntities.PINEAPPLEMONSTER, 35, 1, 5);
        SpawnRestriction.register(ModEntities.PINEAPPLEMONSTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        //coconut
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.MONSTER, ModEntities.COOCNUTMONSTER, 35, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT), SpawnGroup.MONSTER, ModEntities.COOCNUTMONSTER, 25, 1, 5);
        SpawnRestriction.register(ModEntities.COOCNUTMONSTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        //meat
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.MONSTER, ModEntities.MEATMONSTER, 35, 1, 5);
        SpawnRestriction.register(ModEntities.MEATMONSTER, SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark); 
        
    }
    
}
