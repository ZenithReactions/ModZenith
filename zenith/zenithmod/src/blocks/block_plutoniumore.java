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

package zenith.zenithmod.src.blocks;

import java.util.Random;

import zenith.zenithmod.src.ZenithItems;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class block_plutoniumore extends Block
{

	public block_plutoniumore(int par, int index) 
	{
		super(par, index, Material.rock);
		super.setResistance(3.0F);
		super.setHardness(4.0F);
		super.setStepSound(soundStoneFootstep);
		super.setBlockName("orePlutonium");
		super.setCreativeTab(CreativeTabs.tabBlock);
		LanguageRegistry.addName(this, "Plutonium Ore");
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return ZenithItems.unstableplutonium.shiftedIndex; 
    }
	
	public String getTextureFile() 
	{
		return "/textures/zenithblocks.png";
	}
	
	
	
}
