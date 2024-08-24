
package net.clozynoii.drstone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PetrificationDeviceItem extends Item {
	public PetrificationDeviceItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE));
	}
}
