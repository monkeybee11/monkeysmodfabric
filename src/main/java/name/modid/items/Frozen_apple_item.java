package name.modid.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import java.util.function.Consumer;
import name.modid.throwing_things.Frozen_apple;

public class Frozen_apple_item extends Item {
	
	private final int damage;
	private final int cooldown;
	private final Consumer<Frozen_apple> onCollide;
	
	public Frozen_apple_item(Settings settings, int damage, int cooldown) {
		this(settings, damage, cooldown, ball -> {});
	}
	
	public Frozen_apple_item(Settings settings, int damage, int cooldown, Consumer<Frozen_apple> onCollide) {
		super(settings);
		this.damage = damage;
		this.cooldown = cooldown;
		this.onCollide = onCollide;
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
		user.getItemCooldownManager().set(this, cooldown);
		if (!world.isClient) {
			Frozen_apple frozenappleentity = new Frozen_apple(world, user, damage, onCollide);
			frozenappleentity.setItem(itemStack);
			frozenappleentity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
			world.spawnEntity(frozenappleentity);
		}
		
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.decrement(1);
		}
		
		return TypedActionResult.success(itemStack, world.isClient());
	}
}
