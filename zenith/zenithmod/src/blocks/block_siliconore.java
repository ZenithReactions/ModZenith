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

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class block_siliconore extends Block 
{
	
	public block_siliconore(int par, int index) 
	{
		super(par, index, Material.rock);
		super.setResistance(5.0F);
		super.setHardness(3.5F);
		super.setStepSound(soundStoneFootstep);
		super.setBlockName("oreSilicon");
		super.setCreativeTab(CreativeTabs.tabBlock);
		LanguageRegistry.addName(this, "Silicon Ore");
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID; 
    }
	
	public String getTextureFile() 
	{
		return "/textures/zenithblocks.png";
	}
}
