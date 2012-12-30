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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import zenith.zenithmod.src.entities.EntityLaserBeam;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class item_LaserPistol extends Item
{

	public item_LaserPistol(int id, int index)
	{
		super(id);
		super.setIconIndex(index);
		super.setFull3D();
		super.setItemName("LaserGunPistol");
		super.setCreativeTab(CreativeTabs.tabCombat);
		super.setMaxStackSize(1);
		LanguageRegistry.addName(this, "Laser Pistol");
	}
	
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	if(!world.isRemote)
    	{   
    		EntityLaserBeam laser = new EntityLaserBeam(world, player);
    		world.spawnEntityInWorld(laser);
    	}
    	return itemstack;
    }
    
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 50;
    }
    
	public String getTextureFile() 
	{
		return "/textures/zenithitems2.png";
	}
	
	
}
