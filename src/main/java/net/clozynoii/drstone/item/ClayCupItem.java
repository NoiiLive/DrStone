
package net.clozynoii.drstone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ClayCupItem extends Item {
	public ClayCupItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
