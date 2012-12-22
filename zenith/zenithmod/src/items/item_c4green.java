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

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class item_c4green extends Item
{

	public item_c4green(int par, int index) 
	{
		super(par);
		super.setFull3D();
		super.setItemName("c4green");
		super.setCreativeTab(CreativeTabs.tabCombat);
		super.setMaxStackSize(16);
		super.setIconIndex(index);
		LanguageRegistry.addName(this, "Green C4");
	}
	
	
	public String getTextureFile() 
	{
		return "/textures/zenithitems.png";
	}
	
}
