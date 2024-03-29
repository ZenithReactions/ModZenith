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

import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;


public class block_c4blue extends Block
{
	
	public block_c4blue(int par, int index) 
	{
		super(par, index, Material.clay);
		super.setResistance(2.0F);
		super.setHardness(0.5F);
		super.setStepSound(soundStoneFootstep);
		super.setBlockName("blockBlueC4");
		super.setCreativeTab(CreativeTabs.tabBlock);
		LanguageRegistry.addName(this, "Blue C4 Block");
	}
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID; 
    }
	
	public String getTextureFile() 
	{
		return "/textures/zenithblocks.png";
	}

	public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
    {
        ForgeDirection dir = ForgeDirection.getOrientation(par5);
        return (dir == NORTH && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH)) ||
               (dir == SOUTH && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (dir == WEST  && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST)) ||
               (dir == EAST  && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST));
    }
    
    private boolean canBePlacedOn(int par1)
    {
        if (par1 == 0)
        {
            return false;
        }
        else
        {
            Block var2 = Block.blocksList[par1];
            return var2.renderAsNormalBlock() && var2.blockMaterial.blocksMovement();
        }
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
   
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST)) ||
               (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST)) ||
               (par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH)) ||
               (par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH));
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int metadatai = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		 
		 float var4 = 0.2F;
		 float var3 = 0.8F;
		 float var6 = 0.35F;
		 float var7 = 0.125F;
		 
		 if (metadatai == 0)//north
		 {
		     this.setBlockBounds(0.125f, 0.1875f, 0.0f, 0.875f, 0.8125f, 0.1f);
		 }
		 
		 if (metadatai == 1)//east
		 {
		     this.setBlockBounds(0.9f, 0.1875f, 0.125f, 1.0f, 0.8125f, 0.875f);
		 }
		 
		 if (metadatai == 2)//south
		 {
		     this.setBlockBounds(0.125f, 0.1875f, 0.9f, 0.875f, 0.8125f, 1.0f);
		 }
		 
		 if (metadatai == 3)//west
		 {
		     this.setBlockBounds(0.0f, 0.1875f, 0.125f, 0.1f, 0.8125f, 0.875f);
		 }
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
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 1:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 2:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 3:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		     }
		 }
		 
		 if(i == 1)
		 {
		     switch(j)
		     {
		      case 0:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 1:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 2:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 3:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		     }
		 }
		 
		 if(i == 2)
		 {
		     switch(j)
		     {
		      case 0:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 1:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 2:
		      {
		       return this.blockIndexInTexture + 0;
		      }
		      
		      case 3:
		      {
		       return this.blockIndexInTexture + 4;
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
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 2:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 3:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		     }
		 }
		 
		 if(i == 4)
		 {
		     switch(j)
		     {
		      case 0:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 1:
		      {
		       return this.blockIndexInTexture + 0;
		      }
		      
		      case 2:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		      
		      case 3:
		      {
		       return this.blockIndexInTexture + 4;
		      }
		     }
		 }
		 
		 if(i == 5)
		 {
		     switch(j)
		     {
			      case 0://north
				  {
				   return this.blockIndexInTexture + 4;
				  }
				  
				  case 1://east
				  {
				   return this.blockIndexInTexture + 4;
				  }
				  
				  case 2://south
				  {
				   return this.blockIndexInTexture + 4;
				  }
				  
				  case 3://west
				  {
				   return this.blockIndexInTexture + 0;
				  }
		     }
		 }
		 
		 return this.blockIndexInTexture + 0;
	}
}