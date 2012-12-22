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

package zenith.zenithmod.src.containers;

import zenith.zenithmod.src.tileEntities.TileEntityRefiner;
import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;

public class ContainerRefiner extends Container
{
	protected TileEntityRefiner refinerEntity;
	
	public ContainerRefiner(InventoryPlayer playerInventory, TileEntityRefiner te)
	{
		refinerEntity = te;
		
        this.addSlotToContainer(new Slot(te, 0, 56, 17));
        this.addSlotToContainer(new Slot(te, 1, 56, 53));
		
		bindPlayerInventory(playerInventory);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return refinerEntity.isUseableByPlayer(player);
	}
	
	protected void bindPlayerInventory(InventoryPlayer playerInventory)
	{
		for (int i = 0; i < 3; i++)
		{
            for (int j = 0; j < 9; j++)
            {
                    addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
		}

		for (int i = 0; i < 9; i++)
		{
            addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
		}
	}
	
    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slot) 
    {
            ItemStack stack = null;
            Slot slotObject = (Slot) inventorySlots.get(slot);

            if (slotObject != null && slotObject.getHasStack()) 
            {
                    ItemStack stackInSlot = slotObject.getStack();
                    stack = stackInSlot.copy();
                    
                    if (slot == 0) 
                    {
                            if (!mergeItemStack(stackInSlot, 1, inventorySlots.size(), true)) 
                            {
                                    return null;
                            }
                    } 
                    else if (!mergeItemStack(stackInSlot, 0, 1, false))
                    {
                            return null;
                    }

                    if (stackInSlot.stackSize == 0) 
                    {
                            slotObject.putStack(null);
                    } 
                    else 
                    {
                            slotObject.onSlotChanged();
                    }
            }
            return stack;
    }
}
