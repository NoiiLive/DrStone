
package net.clozynoii.drstone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class CookedClayCupItem extends Item {
	public CookedClayCupItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
