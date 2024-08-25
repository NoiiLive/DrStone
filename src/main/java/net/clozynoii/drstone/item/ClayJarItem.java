
package net.clozynoii.drstone.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ClayJarItem extends Item {
	public ClayJarItem() {
		super(new Item.Properties().stacksTo(16).rarity(Rarity.COMMON));
	}
}
