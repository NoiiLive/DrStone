
package net.clozynoii.drstone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FiredClayBrickItem extends Item {
	public FiredClayBrickItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
