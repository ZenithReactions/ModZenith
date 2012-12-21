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


import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Gui;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

	public class item_unstablemagainiam extends Item
	{

		public item_unstablemagainiam(int par, int index) 
		{
			super(par);
			super.setFull3D();
			super.setItemName("unstablemagainiam");
			super.setCreativeTab(CreativeTabs.tabMaterials);
			super.setMaxStackSize(16);
			super.setIconIndex(index);
			LanguageRegistry.addName(this, "Unstable Magainiam Powder");
		}
		
		 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par3World, EntityPlayer par2EntityPlayer)
		 {
			 //checks to see if player is on the ground and creates an explosion if player is.
			 if(par2EntityPlayer.onGround)
			 {
				 par3World.createExplosion(par2EntityPlayer, par2EntityPlayer.posX, par2EntityPlayer.posY, par2EntityPlayer.posZ, 8.0F, true);
			 }
			 
			 //checks to see if player is in creative mode, damages player and knocks him back if player isnt in creative mode.
			 if(!par2EntityPlayer.capabilities.isCreativeMode)
			 {
				 --par1ItemStack.stackSize;
				 par2EntityPlayer.knockBack(par2EntityPlayer, 15, 15, 15);
				 par2EntityPlayer.setEntityHealth(par2EntityPlayer.getHealth()-20);
			 }
			 	//returns an item stack param because it requires a return
			 	return par1ItemStack;
		 }
		
		public String getTextureFile() 
		{
			return "/textures/zenithitems.png";
		}
		

	}



