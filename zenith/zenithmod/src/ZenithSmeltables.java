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

import net.minecraft.src.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ZenithSmeltables 
{

	public void smelting()
	{
		
		GameRegistry.addSmelting(ZenithBlocks.tantalumore.blockID, new ItemStack(ZenithItems.tantalum), 10.0F);
		GameRegistry.addSmelting(ZenithBlocks.siliconore.blockID, new ItemStack(ZenithItems.silicon), 10.0F);
	}
	
}
