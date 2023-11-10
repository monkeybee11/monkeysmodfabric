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
import name.modid.items.Coconut_food;
import name.modid.items.Coconut_shell;
import name.modid.items.Frozen_apple_item;
import name.modid.items.Peeled_banana;
import name.modid.items.Pineapple;
import name.modid.items.Pineapple_cored;
import name.modid.items.Pineapple_ring;
import name.modid.items.William_tell_apple;
import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.AppleEntity;
import name.modid.monsters.custom.BananaEntity;
import name.modid.monsters.custom.CoconutEntity;
import name.modid.monsters.custom.PineappleEntity;
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
	public static final Item PINEAPPLE_SPAWN_EGG = new SpawnEggItem(ModEntities.PINEAPPLEMONSTER, 29100100, 2910066, new FabricItemSettings());
	public static final Item COCONUT_SPAWN_EGG = new SpawnEggItem(ModEntities.COOCNUTMONSTER, 124423421 ,423241,new FabricItemSettings());
	public static final William_tell_apple WILLIAM_TELL_APPLE = new William_tell_apple(new  FabricItemSettings());
	public static final Frozen_apple_item FROZEN_APPLE_ITEM = new Frozen_apple_item(new FabricItemSettings(), 0, 0);
	public static final Pineapple PINEAPPLE = new Pineapple(new FabricItemSettings());
	public static final Item PINEAPPLE_STEM = new Item(new FabricItemSettings());
	public static final Pineapple_ring PINEAPPLE_RING = new Pineapple_ring(new FabricItemSettings());
	public static final Pineapple_cored PINEAPPLE_CORED = new Pineapple_cored(new FabricItemSettings());
	public static final Coconut_shell COCONUT_SHELL = new Coconut_shell(new FabricItemSettings(), 0, 0);
	public static final Coconut_food COCONUT_FOOD = new Coconut_food(new FabricItemSettings());
	



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
		entries.add(PINEAPPLE_SPAWN_EGG);
		entries.add(PINEAPPLE);
		entries.add(PINEAPPLE_STEM);
		entries.add(PINEAPPLE_RING);
		entries.add(PINEAPPLE_CORED);
		entries.add(COCONUT_SPAWN_EGG);
		entries.add(COCONUT_SHELL);
		entries.add(COCONUT_FOOD);
	
	
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
		CompostingChanceRegistry.INSTANCE.add(PINEAPPLE_STEM, (float) 20);
		FabricDefaultAttributeRegistry.register(ModEntities.BANANAMONSTER, BananaEntity.createBananaAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.APPLEMONSTER, AppleEntity.createAppleAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.PINEAPPLEMONSTER, PineappleEntity.createPineappleAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.COOCNUTMONSTER, CoconutEntity.createCoconutAttributeBuilder());
		ModCustomTrades.registerCustomTrades();
		ModEntityGeneration.addSpawns();
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "william_tell_apple"), WILLIAM_TELL_APPLE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_spawn_egg"),BANANA_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "apple_spawn_egg"), APPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_spawn_egg"), PINEAPPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_spawn_egg"), COCONUT_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "frozen_apple_item"),FROZEN_APPLE_ITEM);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple"), PINEAPPLE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_stem"), PINEAPPLE_STEM);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_ring"), PINEAPPLE_RING);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_cored"), PINEAPPLE_CORED);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_shell"), COCONUT_SHELL);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_food"), COCONUT_FOOD);



		
		
	}
}