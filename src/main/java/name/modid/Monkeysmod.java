package name.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import name.modid.block.Appleblock;
import name.modid.block.Bananabunch;
import name.modid.block.Cheese_block;
import name.modid.block.Coconut_crop;
import name.modid.block.Meat_crop;
import name.modid.block.Milk_cauldron;
import name.modid.block.Mince_pie_crop;
import name.modid.block.Pineapple_crop;
import name.modid.block.Pizza_block;
import name.modid.block.Wheelie_bin;
import name.modid.event.Cheese_cauldron_event;
import name.modid.items.Banana;
import name.modid.items.Carrot_drill;
import name.modid.items.Coconut_food;
import name.modid.items.Coconut_shell;
import name.modid.items.Cooked_meat;
import name.modid.items.Frozen_apple_item;
import name.modid.items.Golden_carrot_drill;
import name.modid.items.Peeled_banana;
import name.modid.items.Pineapple;
import name.modid.items.Pineapple_cored;
import name.modid.items.Pineapple_ring;
import name.modid.items.Raw_meat;
import name.modid.items.William_tell_apple;
import name.modid.items.Cheese_slice;
import name.modid.items.Grated_cheese;
import name.modid.items.Meat_mats;
import name.modid.items.Mince_pie_item;
import name.modid.items.Raw_pizza;
import name.modid.items.Cooked_pizza;
import name.modid.items.Seed_wand;
import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.AppleEntity;
import name.modid.monsters.custom.BananaEntity;
import name.modid.monsters.custom.CoconutEntity;
import name.modid.monsters.custom.MeatEntity;
import name.modid.monsters.custom.MincepieEntity;
import name.modid.monsters.custom.PineappleEntity;
import name.modid.world.gen.ModEntityGeneration;

public class Monkeysmod implements ModInitializer {



	public static final Banana BANANA = new Banana(new FabricItemSettings());
	public static final Peeled_banana PEELED_BANANA = new Peeled_banana(new FabricItemSettings());
	public static final Item BANANA_PEEL = new Item(new FabricItemSettings());
	public static final Item BANANA_PICKER = new Item(new FabricItemSettings());
	public static final Bananabunch BANANA_BUNCH = new Bananabunch(FabricBlockSettings.create().strength(1.0f));
	public static final Milk_cauldron MILK_CAULDRON = new Milk_cauldron(FabricBlockSettings.create().strength(2.0F).nonOpaque().ticksRandomly());
	public static final Item BANANA_SPAWN_EGG = new SpawnEggItem(ModEntities.BANANAMONSTER, 16700985, 16509870, new FabricItemSettings());
	public static final Item APPLE_SPAWN_EGG = new SpawnEggItem(ModEntities.APPLEMONSTER, 03163, 00222, new FabricItemSettings());
	public static final Item PINEAPPLE_SPAWN_EGG = new SpawnEggItem(ModEntities.PINEAPPLEMONSTER, 29100100, 2910066, new FabricItemSettings());
	public static final Item COCONUT_SPAWN_EGG = new SpawnEggItem(ModEntities.COOCNUTMONSTER, 124423421 ,423241,new FabricItemSettings());
	public static final Item MEAT_SPAWN_EGG = new SpawnEggItem(ModEntities.MEATMONSTER, 135653, 23521, new FabricItemSettings());
	public static final Item MINCE_PIE_EGG = new SpawnEggItem(ModEntities.MINCEPIE, 12321, 23432, new FabricItemSettings());
	public static final William_tell_apple WILLIAM_TELL_APPLE = new William_tell_apple(new  FabricItemSettings());
	public static final Frozen_apple_item FROZEN_APPLE_ITEM = new Frozen_apple_item(new FabricItemSettings(), 0, 0);
	public static final Pineapple PINEAPPLE = new Pineapple(new FabricItemSettings());
	public static final Item PINEAPPLE_STEM = new Item(new FabricItemSettings());
	public static final Pineapple_ring PINEAPPLE_RING = new Pineapple_ring(new FabricItemSettings());
	public static final Pineapple_cored PINEAPPLE_CORED = new Pineapple_cored(new FabricItemSettings());
	public static final Coconut_shell COCONUT_SHELL = new Coconut_shell(new FabricItemSettings(), 0, 0);
	public static final Coconut_food COCONUT_FOOD = new Coconut_food(new FabricItemSettings());
	public static final Cheese_block CHEESE_BLOCK = new Cheese_block(FabricBlockSettings.create().strength(1.0f));
	public static final Cheese_slice CHEESE_SLICE = new Cheese_slice(new FabricItemSettings());
	public static final Grated_cheese GRATED_CHEESE = new Grated_cheese(new FabricItemSettings());
	public static final Raw_meat RAW_MEAT = new Raw_meat(new FabricItemSettings());
	public static final Cooked_meat COOKED_MEAT = new Cooked_meat(new FabricItemSettings());
	public static final SwordItem HARM_BAT = new SwordItem(Meat_mats.INSTANCE, 0, 2.0f, new FabricItemSettings());
	public static final Raw_pizza RAW_PIZZA = new Raw_pizza(new FabricItemSettings());
	public static final Cooked_pizza COOKED_PIZZA = new Cooked_pizza(new FabricItemSettings());
	public static final Pizza_block PIZZA_BLOCK = new Pizza_block(FabricBlockSettings.create().strength(1.0f));
	public static final Carrot_drill CARROT_DRILL = new Carrot_drill(ToolMaterials.NETHERITE, 0, 0, new FabricItemSettings());
	private static final Identifier VILLAGER_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/village/village_plains_house");
	public static final Mince_pie_item MINCE_PIE_ITEM = new Mince_pie_item(new FabricItemSettings());
	public static final Golden_carrot_drill GOLDEN_CARROT_DRILL = new Golden_carrot_drill(ToolMaterials.NETHERITE, 0, 0, new FabricItemSettings());
	private static final Identifier ANCHENT_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/ancient_city");
	public static final Seed_wand SEED_WAND = new Seed_wand(new FabricItemSettings().maxDamage(15));
	public static final Meat_crop MEAT_CROP = new Meat_crop(FabricBlockSettings.copyOf(Blocks.WHEAT).nonOpaque());
	public static final Pineapple_crop PINEAPPLE_CROP = new Pineapple_crop(FabricBlockSettings.copyOf(Blocks.WHEAT).nonOpaque());
	public static final Mince_pie_crop MINCE_PIE_CROP = new Mince_pie_crop(FabricBlockSettings.copyOf(Blocks.WHEAT));
	public static final Coconut_crop COCONUT_CROP = new Coconut_crop(FabricBlockSettings.copyOf(Blocks.WHEAT).nonOpaque());
	public static final Appleblock APPLEBLOCK = new Appleblock(FabricBlockSettings.create().strength(1.0f));
	public static final Wheelie_bin WHEELIE_BIN = new Wheelie_bin(FabricBlockSettings.create().strength(1.0f));
	



	

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
		entries.add(CHEESE_BLOCK);
		entries.add(CHEESE_SLICE);
		entries.add(GRATED_CHEESE);
		entries.add(MEAT_SPAWN_EGG);
		entries.add(RAW_MEAT);
		entries.add(COOKED_MEAT);
		entries.add(HARM_BAT);
		entries.add(RAW_PIZZA);
		entries.add(COOKED_PIZZA);
		entries.add(PIZZA_BLOCK);
		entries.add(CARROT_DRILL);
		entries.add(GOLDEN_CARROT_DRILL);
		entries.add(MINCE_PIE_ITEM);
		entries.add(MINCE_PIE_EGG);
		entries.add(SEED_WAND);
		entries.add(MEAT_CROP);
		entries.add(PINEAPPLE_CROP);
		entries.add(MINCE_PIE_CROP);
		entries.add(COCONUT_CROP);
		entries.add(APPLEBLOCK);
		entries.add(WHEELIE_BIN);
	
	}).build();	


	@Override
	public void onInitialize() {

		new Cheese_cauldron_event().onInitialize();



		//no more accadental budding braking
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			ItemStack itemStack = player.getMainHandStack();
			if (state.getBlock() == Blocks.BUDDING_AMETHYST && !itemStack.isEmpty()) {
				world.setBlockState(pos, Blocks.BUDDING_AMETHYST.getDefaultState());

			}
		});


        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (VILLAGER_CHEST_LOOT_TABLE_ID.equals(id)) {
                LootPool pool = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .with(ItemEntry.builder(Monkeysmod.CARROT_DRILL))
                    .build();

                supplier.pool(pool);
            } else if (ANCHENT_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool pool = LootPool.builder()
					.rolls(ConstantLootNumberProvider.create(1))
					.with(ItemEntry.builder(Monkeysmod.GOLDEN_CARROT_DRILL))
					.build();


				supplier.pool(pool);

			}
        });

		
		

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
		FabricDefaultAttributeRegistry.register(ModEntities.MEATMONSTER, MeatEntity.createMeatAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.MINCEPIE, MincepieEntity.createMincepieAttributeBuilder());
		ModCustomTrades.registerCustomTrades();
		ModEntityGeneration.addSpawns();
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "william_tell_apple"), WILLIAM_TELL_APPLE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_spawn_egg"),BANANA_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "apple_spawn_egg"), APPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_spawn_egg"), PINEAPPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_spawn_egg"), COCONUT_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "meat_spawn_egg"), MEAT_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "mincepie_spawn_egg"), MINCE_PIE_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "frozen_apple_item"),FROZEN_APPLE_ITEM);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple"), PINEAPPLE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_stem"), PINEAPPLE_STEM);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_ring"), PINEAPPLE_RING);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_cored"), PINEAPPLE_CORED);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_shell"), COCONUT_SHELL);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_food"), COCONUT_FOOD);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "milk_cauldron"), MILK_CAULDRON);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "cheese_block"), CHEESE_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "cheese_block"), new BlockItem(CHEESE_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "cheese_slice"), CHEESE_SLICE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "grated_cheese"), GRATED_CHEESE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "raw_meat"), RAW_MEAT);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "cooked_meat"), COOKED_MEAT);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "harm_on_bone"), HARM_BAT);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "raw_pizza"), RAW_PIZZA);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "cooked_pizza"), COOKED_PIZZA);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "pizza_block"), PIZZA_BLOCK);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pizza_block"), new BlockItem(PIZZA_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "carrot_drill"), CARROT_DRILL);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "mince_pie_item"), MINCE_PIE_ITEM);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "golden_carrot_drill"), GOLDEN_CARROT_DRILL);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "seed_wand"), SEED_WAND);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "meat_crop"), MEAT_CROP);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "meat_seed"), new BlockItem(MEAT_CROP, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "pineapple_crop"), PINEAPPLE_CROP);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_seed"), new BlockItem(PINEAPPLE_CROP, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "mincepie_crop"), MINCE_PIE_CROP);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "mincepie_seed"), new BlockItem(MINCE_PIE_CROP, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "coconut_crop"), COCONUT_CROP);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_seed"), new BlockItem(COCONUT_CROP, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "appleblock"), APPLEBLOCK);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "appleblock"), new BlockItem(APPLEBLOCK, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "wheelie_bin"), WHEELIE_BIN);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "wheelie_bin"), new BlockItem(WHEELIE_BIN,new FabricItemSettings()));

	}
}