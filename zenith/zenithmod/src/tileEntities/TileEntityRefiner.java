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

package zenith.zenithmod.src.tileEntities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRefiner extends TileEntity implements IInventory
{
	
	private ItemStack[] inv;
	
	public TileEntityRefiner()
	{
		inv = new ItemStack[2];
	}
	
	@Override
	public int getSizeInventory() 
	{
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) 
	{
		return inv[var1];
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) 
	{
		ItemStack stack = getStackInSlot(var1);
		
		if(stack != null)
		{
			if(stack.stackSize <= var2)
			{
				setInventorySlotContents(var1, null);
			}
			else
			{
				stack = stack.splitStack(var2);
				if(stack.stackSize == 0)
				{
					setInventorySlotContents(var1, null);
				}
			}
		}
		
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) 
	{
		ItemStack stack = getStackInSlot(var1);
		
		if(stack != null)
		{
			setInventorySlotContents(var1, null);
		}
		
		return stack;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) 
	{
		inv[var1] = var2;
		if(var2 != null && var2.stackSize > getInventoryStackLimit())
		{
			var2.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() 
	{
		return "RefinerInventory";
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) 
	{
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this && var1.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() 
	{
		
	}

	@Override
	public void closeChest() 
	{
		
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		
		NBTTagList tagList = tag.getTagList("RefinerInventory");
		
		for(int i = 0; i<tagList.tagCount(); i++)
		{
			NBTTagCompound tagcompound = (NBTTagCompound) tagList.tagAt(i);
			
			byte slot = tagcompound.getByte("Slot");
			
			if(slot >= 0 && slot < inv.length)
			{
				inv[slot] = ItemStack.loadItemStackFromNBT(tagcompound);
			}
			
		}
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		
		NBTTagList tagList = new NBTTagList();
		
		for(int i = 0; i<inv.length; i++)
		{
			if(inv[i] != null)
			{
				NBTTagCompound tagcompound = new NBTTagCompound();
				tagcompound.setByte("Slot", (byte)i);
				inv[i].writeToNBT(tagcompound);
				tagList.appendTag(tagcompound);
			}
		}
		tag.setTag("RefinerInventory", tagList);
	}
	
}
