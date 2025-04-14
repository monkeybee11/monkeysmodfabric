package name.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
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
import name.modid.block.Cookie_plate_wood;
import name.modid.block.Head_printer;
import name.modid.block.Meat_crop;
import name.modid.block.Milk_cauldron;
import name.modid.block.Mince_pie_crop;
import name.modid.block.Pineapple_crop;
import name.modid.block.Pizza_block;
import name.modid.block.Stocking;
import name.modid.block.Wheelie_bin;
import name.modid.event.Bubble_bottleing;
import name.modid.event.Cheese_cauldron_event;
import name.modid.event.Christmas_tree_event;
import name.modid.event.naughty_nice_list_event;
import name.modid.event.Santa_event;
import name.modid.event.Stocking_event;
import name.modid.event.Wash_Skull;
import name.modid.items.Banana;
import name.modid.items.Banana_peel_item;
import name.modid.items.Bubble_bottle;
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
import name.modid.items.Pizza_shield;
import name.modid.items.Raw_meat;
import name.modid.items.William_tell_apple;
import name.modid.items.Cheese_slice;
import name.modid.items.Grated_cheese;
import name.modid.items.Lighting_bottle;
import name.modid.items.Meat_mats;
import name.modid.items.Mince_pie_item;
import name.modid.items.Raw_pizza;
import name.modid.items.Cooked_pizza;
import name.modid.items.Copy_of_santas_list;
import name.modid.items.Digger;
import name.modid.items.Seed_wand;
import name.modid.items.Tape;
import name.modid.monsters.ModEntities;
import name.modid.monsters.custom.AppleEntity;
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
import name.modid.world.gen.ModEntityGeneration;
import name.modid.block.Lighting_catcher;

public class Monkeysmod implements ModInitializer {

	public static final Banana BANANA = new Banana(new FabricItemSettings());
	public static final Peeled_banana PEELED_BANANA = new Peeled_banana(new FabricItemSettings());
	public static final Banana_peel_item BANANA_PEEL = new Banana_peel_item(new FabricItemSettings(), 0, 0);
	public static final Item BANANA_PICKER = new Item(new FabricItemSettings());
	public static final Bananabunch BANANA_BUNCH = new Bananabunch(FabricBlockSettings.create().strength(1.0f));
	public static final Milk_cauldron MILK_CAULDRON = new Milk_cauldron(FabricBlockSettings.create().strength(2.0F).nonOpaque().ticksRandomly());
	public static final Item BANANA_SPAWN_EGG = new SpawnEggItem(ModEntities.BANANAMONSTER, 16700985, 16509870, new FabricItemSettings());
	public static final Item APPLE_SPAWN_EGG = new SpawnEggItem(ModEntities.APPLEMONSTER, 03163, 00222, new FabricItemSettings());
	public static final Item PINEAPPLE_SPAWN_EGG = new SpawnEggItem(ModEntities.PINEAPPLEMONSTER, 29100100, 2910066, new FabricItemSettings());
	public static final Item COCONUT_SPAWN_EGG = new SpawnEggItem(ModEntities.COOCNUTMONSTER, 124423421 ,423241,new FabricItemSettings());
	public static final Item MEAT_SPAWN_EGG = new SpawnEggItem(ModEntities.MEATMONSTER, 135653, 23521, new FabricItemSettings());
	public static final Item PIZZABOSS_SPAWN_EGG = new SpawnEggItem(ModEntities.PIZZABOSS, 121212, 212121, new FabricItemSettings());
	public static final Item MINCE_PIE_EGG = new SpawnEggItem(ModEntities.MINCEPIE, 12321, 23432, new FabricItemSettings());
	public static final Item SANTA_PIG_SPAWN_EGG = new SpawnEggItem(ModEntities.SANTA_PIG, 12322, 121212,new FabricItemSettings());
	public static final Item CHERRY_BOMB_SPAWN_EGG = new SpawnEggItem(ModEntities.CHERRY_BOMB, 12332, 23332,new FabricItemSettings());
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
	public static final Coconut_crop COCONUT_CROP = new Coconut_crop(FabricBlockSettings.create().strength(1.0f));
	public static final Appleblock APPLEBLOCK = new Appleblock(FabricBlockSettings.create().strength(1.0f));
	public static final Wheelie_bin WHEELIE_BIN = new Wheelie_bin(FabricBlockSettings.create().strength(1.0f));
	public static final Pizza_shield PIZZA_SHIELD = new Pizza_shield(new FabricItemSettings().maxDamage(336));
	public static final Cookie_plate_wood COOKIE_PLATE_WOOD = new Cookie_plate_wood(FabricBlockSettings.create().strength(1.0f).nonOpaque());
	public static final Stocking STOCKING = new Stocking(FabricBlockSettings.create().strength(1.0f).nonOpaque());
    public static final Copy_of_santas_list SANTAS_LIST = new Copy_of_santas_list(new FabricItemSettings());
	public static final Digger DIGGER = new Digger(ToolMaterials.DIAMOND, 0, 0, new FabricItemSettings());
	public static final Head_printer HEAD_PRINTER = new Head_printer(FabricBlockSettings.create().strength(1.0f).nonOpaque());
	public static final Bubble_bottle BUBBLE_BOTTLE = new Bubble_bottle( new FabricItemSettings());
	public static final Block BLOCK_CHARCOAL = new Block(FabricBlockSettings.create());
	public static final Tape TAPE_ITEM = new Tape(new FabricItemSettings());
	private static final Identifier DUGEON_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/simple_dungeon");
	public static final Lighting_catcher LIGHTING_CATCHER = new Lighting_catcher(FabricBlockSettings.create().strength(1.0f).nonOpaque());
	public static final Lighting_bottle LIGHTING_BOTTLE = new Lighting_bottle(new FabricItemSettings(), 0, 0);



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
		entries.add(PIZZA_SHIELD);
		//entries.add(PIZZABOSS_SPAWN_EGG);
		entries.add(COOKIE_PLATE_WOOD);
		entries.add(STOCKING);
		entries.add(SANTAS_LIST);
		entries.add(SANTA_PIG_SPAWN_EGG);
		entries.add(CHERRY_BOMB_SPAWN_EGG);
		entries.add(DIGGER);
		entries.add(HEAD_PRINTER);
		entries.add(BUBBLE_BOTTLE);
		entries.add(BLOCK_CHARCOAL);
		entries.add(TAPE_ITEM);
		entries.add(LIGHTING_CATCHER);
		entries.add(LIGHTING_BOTTLE);

	}).build();

	@Override
	public void onInitialize() {

		new Cheese_cauldron_event().onInitialize();
		new Christmas_tree_event().onInitialize();
		Santa_event.register();
		new Stocking_event().onInitialize();
		new naughty_nice_list_event().onInitialize();
		new Bubble_bottleing().onInitialize();
		new Wash_Skull().onInitialize();

		//no more accadental budding braking
		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
			ItemStack itemStack = player.getMainHandStack();
			if (state.getBlock() == Blocks.BUDDING_AMETHYST && !itemStack.isEmpty()) {
				world.setBlockState(pos, Blocks.BUDDING_AMETHYST.getDefaultState());

			}
		});

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
			if (VILLAGER_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
				.conditionally(RandomChanceLootCondition.builder(0.5f))
					.rolls(ConstantLootNumberProvider.create(1))
					.with(ItemEntry.builder(Monkeysmod.CARROT_DRILL));
		
				supplier.pool(poolBuilder);
			} else if (ANCHENT_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
					.conditionally(RandomChanceLootCondition.builder(0.10f))
					.rolls(ConstantLootNumberProvider.create(1))
					.with(ItemEntry.builder(Monkeysmod.GOLDEN_CARROT_DRILL));
		
				supplier.pool(poolBuilder);
			} else if (DUGEON_CHEST_LOOT_TABLE_ID.equals(id)) {
				LootPool.Builder poolBuilder = LootPool.builder()
					.conditionally(RandomChanceLootCondition.builder(0.5f))
					.rolls(ConstantLootNumberProvider.create(1))
					.with(ItemEntry.builder(Monkeysmod.DIGGER));
			
				supplier.pool(poolBuilder);
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
		FabricDefaultAttributeRegistry.register(ModEntities.PIZZABOSS, PizzaBoss.createPizzaBossAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.CHRISTMAS_TREE, ChristmasTreeEntity.createChristmasTreeAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.SANTA_PIG, SantaPigEntity.createSantaPigAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.CHERRY_BOMB, CherryBombEntity.createCherryAttributeBuilder());
		FabricDefaultAttributeRegistry.register(ModEntities.BANANAPEEL, BananaPeelEntity.createBananaPeelAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TAPE, TapeEntity.createTapeAttributeBuilder());
		ModCustomTrades.registerCustomTrades();
		ModEntityGeneration.addSpawns();
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "william_tell_apple"), WILLIAM_TELL_APPLE);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "banana_spawn_egg"),BANANA_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "apple_spawn_egg"), APPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pineapple_spawn_egg"), PINEAPPLE_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "coconut_spawn_egg"), COCONUT_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "meat_spawn_egg"), MEAT_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "mincepie_spawn_egg"), MINCE_PIE_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod" , "pizzaboss_spawn_egg"), PIZZABOSS_SPAWN_EGG);
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
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "pizza_shield"), PIZZA_SHIELD);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "cookie_plate_wood"), COOKIE_PLATE_WOOD);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "cookie_plate_wood"), new BlockItem(COOKIE_PLATE_WOOD, new FabricItemSettings()));
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "stocking"), STOCKING);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "stocking"),new BlockItem(STOCKING, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "santa_list"), SANTAS_LIST);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "santa_pig_spawn_egg"), SANTA_PIG_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "cherry_bomb_egg"), CHERRY_BOMB_SPAWN_EGG);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "digger"), DIGGER);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "head_printer"), HEAD_PRINTER);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "head_printer"), new BlockItem(HEAD_PRINTER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "bubble_bottle"), BUBBLE_BOTTLE);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod" , "charcoal_block"), BLOCK_CHARCOAL);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "charcoal_block"), new BlockItem(BLOCK_CHARCOAL, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "tape_item"), TAPE_ITEM);
		Registry.register(Registries.BLOCK, new Identifier("monkeysmod", "lighting_catcher"), LIGHTING_CATCHER);
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "lighting_catcher"), new BlockItem(LIGHTING_CATCHER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("monkeysmod", "lighting_bottle"), LIGHTING_BOTTLE);

		FuelRegistry.INSTANCE.add(BLOCK_CHARCOAL, 16000);
	}
}