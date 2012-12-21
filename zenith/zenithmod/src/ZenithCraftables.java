/**
 * 	This program is a plugin for Minecraft
 *  Copyright (c) 2012 Bums735 & TechnoTantalum
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 **/

package zenith.zenithmod.src;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;


public class ZenithCraftables 
{
	public void crafting()
	{
		GameRegistry.addRecipe(new ItemStack(ZenithItems.copperwire), "   ", "xxx", "   ", 'x', new ItemStack(ZenithItems.copper));
		GameRegistry.addRecipe(new ItemStack(ZenithItems.c4blue), "xax", "xyx", "xxx", 'x', new ItemStack(ZenithItems.plastic), 'a', new ItemStack(Item.dyePowder, 2, 12), 'y', new ItemStack(Item.gunpowder));
		GameRegistry.addRecipe(new ItemStack(ZenithItems.c4green), "xax", "xyx", "xxx", 'x', new ItemStack(ZenithItems.plastic), 'a', new ItemStack(Item.dyePowder, 2, 2), 'y', new ItemStack(Item.gunpowder));
		GameRegistry.addRecipe(new ItemStack(ZenithItems.c4red), "xax", "xyx", "xxx", 'x', new ItemStack(ZenithItems.plastic), 'a', new ItemStack(Item.dyePowder, 2, 1), 'y', new ItemStack(Item.gunpowder));
		GameRegistry.addRecipe(new ItemStack(ZenithItems.c4yellow), "xax", "xyx", "xxx", 'x', new ItemStack(ZenithItems.plastic), 'a', new ItemStack(Item.dyePowder, 2, 11), 'y', new ItemStack(Item.gunpowder));
	}
	
}
