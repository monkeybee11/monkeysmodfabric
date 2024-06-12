package name.modid.items;

import java.util.function.Consumer;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import name.modid.throwing_things.Banana_peel;



public class Banana_peel_item extends Item {

    
	private final int cooldown;
	private final Consumer<Banana_peel> onCollide;
	
	public Banana_peel_item(Settings settings, int damage, int cooldown) {
		this(settings, damage, cooldown, ball -> {});
	}
	
	public Banana_peel_item(Settings settings, int damage, int cooldown, Consumer<Banana_peel> onCollide) {
		super(settings);
		this.cooldown = cooldown;
		this.onCollide = onCollide;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
		user.getItemCooldownManager().set(this, cooldown);
		if (!world.isClient) {
			Banana_peel bananapeelentity = new Banana_peel(world, user, onCollide);
			bananapeelentity.setItem(itemStack);
			bananapeelentity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
			world.spawnEntity(bananapeelentity);
		}
		
		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.decrement(1);
		}
		
		return TypedActionResult.success(itemStack, world.isClient());
	}
    
}
