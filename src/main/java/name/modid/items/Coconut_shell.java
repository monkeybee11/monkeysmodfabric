package name.modid.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import java.util.function.Consumer;

import name.modid.Monkeysmod;
import name.modid.throwing_things.Coconut_Shell;

public class Coconut_shell extends Item {
	
	private final int damage;
	private final int cooldown;
	private final Consumer<Coconut_Shell> onCollide;
	
	public Coconut_shell(Settings settings, int damage, int cooldown) {
		this(settings, damage, cooldown, coconut_shell -> {});
	}
	
	public Coconut_shell(Settings settings, int damage, int cooldown, Consumer<Coconut_Shell> onCollide) {
		super(settings);
		this.damage = damage;
		this.cooldown = cooldown;
		this.onCollide = onCollide;
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		ItemStack offHandStack = user.getStackInHand(Hand.OFF_HAND);

		if (user.isSneaking() && offHandStack.isOf(Items.BRICK)) {
			if (!world.isClient) {
				user.getInventory().offerOrDrop(new ItemStack(Monkeysmod.COCONUT_FOOD,2));
				
				itemStack.decrement(1);
			}
			return TypedActionResult.success(itemStack, world.isClient());
		} else {
			world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
			user.getItemCooldownManager().set(this, cooldown);
			if (!world.isClient) {
				Coconut_Shell coconut_shell = new Coconut_Shell(world, user, damage, onCollide);
				coconut_shell.setItem(itemStack);
				coconut_shell.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
				world.spawnEntity(coconut_shell);
			}
			
			user.incrementStat(Stats.USED.getOrCreateStat(this));
			if (!user.getAbilities().creativeMode) {
				itemStack.decrement(1);
			}
			
			return TypedActionResult.success(itemStack, world.isClient());
		}
	}
}
