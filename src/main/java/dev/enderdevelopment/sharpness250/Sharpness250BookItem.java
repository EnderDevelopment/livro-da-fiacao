package dev.enderdevelopment.sharpness250;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public final class Sharpness250BookItem extends Item {
    public Sharpness250BookItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack book = user.getStackInHand(hand);
        ItemStack target = user.getStackInHand(Hand.OFF_HAND);

        if (hand == Hand.OFF_HAND || !(target.getItem() instanceof SwordItem)) {
            return TypedActionResult.fail(book);
        }

        if (!world.isClient) {
            target.addEnchantment(Enchantments.SHARPNESS, 250);
            if (!user.getAbilities().creativeMode) {
                book.decrement(1);
            }
            user.incrementStat(Stats.USED.getOrCreateStat(Sharpness250BookMod.SHARPNESS_250_BOOK));
            world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                    SoundCategory.PLAYERS, 1.0F, 1.0F);
        }

        return TypedActionResult.success(book, world.isClient);
    }
}
