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

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import zenith.zenithmod.src.mod_zenith;
import zenith.zenithmod.src.tileEntities.TileEntityRefiner;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
        super.setRequiresSelfNotify();
		LanguageRegistry.addName(this, "Refiner Machine");
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
	{
		return this.blockID;
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
    	TileEntityRefiner tileEntity = (TileEntityRefiner) world.getBlockTileEntity(x, y, z);
    	
    	if(player.isSneaking()) return false;
    	
    	player.openGui(mod_zenith.instance, 0, world, x, y, z);
    	
        return true;
    }
    
    public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
    {
    	int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4.0F) / 360F) + 2.5D) & 3;
    	world.setBlockMetadataWithNotify(i, j, k, l);
    }
    
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	if(i == 0)
    	{
	        switch(j)
	        {
	        	case 0:
	        	{
	        		return this.blockIndexInTexture + 2;
	        	}
	        	
	        	case 1:
	        	{
	        		return this.blockIndexInTexture + 2;
	        	}
	        	
	        	case 2:
	        	{
	        		return this.blockIndexInTexture + 2;
	        	}
	        	
	        	case 3:
	        	{
	        		return this.blockIndexInTexture + 2;
	        	}
	        }
    	}
    	
    	if(i == 1)
    	{
	        switch(j)
	        {
	        	case 0:
	        	{
	        		return this.blockIndexInTexture + 3;
	        	}
	        	
	        	case 1:
	        	{
	        		return this.blockIndexInTexture + 3;
	        	}
	        	
	        	case 2:
	        	{
	        		return this.blockIndexInTexture + 3;
	        	}
	        	
	        	case 3:
	        	{
	        		return this.blockIndexInTexture + 3;
	        	}
	        }
    	}
    	
    	if(i == 2)
    	{
	        switch(j)
	        {
	        	case 0:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 1:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 2:
	        	{
	        		return this.blockIndexInTexture + 0;
	        	}
	        	
	        	case 3:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        }
    	}
    	
    	if(i == 3)
    	{
	        switch(j)
	        {
	        	case 0:
	        	{
	        		return this.blockIndexInTexture + 0;
	        	}
	        	
	        	case 1:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 2:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 3:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        }
    	}
    	
    	if(i == 4)
    	{
	        switch(j)
	        {
	        	case 0:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 1:
	        	{
	        		return this.blockIndexInTexture + 0;
	        	}
	        	
	        	case 2:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 3:
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        }
    	}
    	
    	if(i == 5)
    	{
	        switch(j)
	        {
	        	case 0://north
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 1://east
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 2://south
	        	{
	        		return this.blockIndexInTexture + 1;
	        	}
	        	
	        	case 3://west
	        	{
	        		return this.blockIndexInTexture + 0;
	        	}
	        }
    	}
    	return this.blockIndexInTexture + 0;
    }
    
	public String getTextureFile() 
	{
		return "/textures/zenithblocks2.png";
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityRefiner();
	}
}
