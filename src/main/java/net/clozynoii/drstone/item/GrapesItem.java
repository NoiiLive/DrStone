
package net.clozynoii.drstone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class GrapesItem extends Item {
	public GrapesItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(1f).build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 35;
	}
}
