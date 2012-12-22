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

package zenith.zenithmod.src.items;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import cpw.mods.fml.common.registry.LanguageRegistry;

/*
 
 There is currently no way to obtain the standard plutonium ore in survival.
 We could make a machine that refines unstable ores or use the same method as the magainiam, up to you.
 I was thinking that the plutonium ingot could be used in conjunction (or instead of) uranium when it
 comes to nuclear power.
 
 */

public class item_plutonium extends Item
{

	public item_plutonium() 
	{
		super(5005);
		super.setFull3D();
		super.setItemName("plutonium");
		super.setCreativeTab(CreativeTabs.tabMaterials);
		super.setMaxStackSize(16);
		super.setIconIndex(5);
		LanguageRegistry.addName(this, "Plutonium Ingot");
	}
	
	
	public String getTextureFile() 
	{
		return "/textures/zenithitems.png";
	}
	
	
	
}
