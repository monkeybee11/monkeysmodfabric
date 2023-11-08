package name.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import name.modid.block.Bananabunch;
import name.modid.items.Banana;
import name.modid.items.Frozen_apple_item;
import name.modid.items.Peeled_banana;
import name.modid.items.William_tell_apple;
import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.AppleEntity;
import name.modid.monsters.custom.BananaEntity;
import name.modid.world.gen.ModEntityGeneration;

public class Monkeysmod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.



	public static final Banana BANANA = new Banana(new FabricItemSettings());
	public static final Peeled_banana PEELED_BANANA = new Peeled_banana(new FabricItemSettings());
	public static final Item BANANA_PEEL = new Item(new FabricItemSettings());
	public static final Item BANANA_PICKER = new Item(new FabricItemSettings());
	public static final Bananabunch BANANA_BUNCH = new Bananabunch(FabricBlockSettings.create().strength(1.0f));
	public static final Item BANANA_SPAWN_EGG = new SpawnEggItem(ModEntities.BANANAMONSTER, 16700985, 16509870, new FabricItemSettings());
	public static final Item APPLE_SPAWN_EGG = new SpawnEggItem(ModEntities.APPLEMONSTER, 03163, 00222, new FabricItemSettings());
	public static final William_tell_apple WILLIAM_TELL_APPLE = new William_tell_apple(new  FabricItemSettings());
	public static final Frozen_apple_item FROZEN_APPLE_ITEM = new Frozen_apple_item(new FabricItemSettings(), 0, 0);
	



	//this is my tab in the creative menu
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder().icon(() -> new ItemStack(BANANA)).displayName(Text.translatable("itemgroup.monkeysmod_itemgroup")).entries((context, entries) -> {
		entries.add(BANANA);
		entries.add(BANANA_PICKER);
		entries.add(PEELED_BANANA);
		entries.add(BANANA_PEEL);
		entries.add(BANANA_BUNCH);
		entries.add(WILLIAM_TELL_APPLE);
		entries.add(BANANA_SPAWN_EGG);
		entries.add(APPLE_SPAWN_EGG);
		entries.add(FROZEN_APPLE_ITEM);
	
	
	}).build();
	


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		Registry.register(Registries.ITEM_GROUP, new Identifier("monkeysmod", "monkeysmod"), ITEM_GROUP);


		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana"), BANANA);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_peel"), BANANA_PEEL);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "peeled_banana"), PEELED_BANANA);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_picker"), BANANA_PICKER);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "banana_bunch"), BANANA_BUNCH);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_bunch"), new BlockItem(BANANA_BUNCH, new FabricItemSettings()));
		CompostingChanceRegistry.INSTANCE.add(BANANA_PEEL, (float) 20);
		FabricDefaultAttributeRegistry.register(ModEntities.BANANAMONSTER, BananaEntity.createBananaAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.APPLEMONSTER, AppleEntity.createAppleAttributeBuilder());
		ModCustomTrades.registerCustomTrades();
		ModEntityGeneration.addSpawns();
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "william_tell_apple"), WILLIAM_TELL_APPLE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_spawn_egg"),BANANA_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "apple_spawn_egg"), APPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "frozen_apple_item"),FROZEN_APPLE_ITEM);


		
		
	}
}