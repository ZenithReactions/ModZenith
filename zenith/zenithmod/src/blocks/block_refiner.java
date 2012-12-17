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

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityFurnace;
import net.minecraft.src.World;

public class block_refiner extends BlockContainer
{

	public block_refiner(int par1, int textIndex) 
	{
		super(par1, textIndex, Material.rock);
		super.setResistance(5.0F);
		super.setHardness(3.0F);
		super.setStepSound(soundStoneFootstep);
		super.setBlockName("refiner");
		super.setCreativeTab(CreativeTabs.tabDecorations);
		LanguageRegistry.addName(this, "Refiner Machine");
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        return false;
    }

	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return null;
	}
	
}
