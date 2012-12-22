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

import zenith.zenithmod.src.*;
import zenith.zenithmod.src.containers.ContainerRefiner;
import zenith.zenithmod.src.gui.GuiRefiner;
import zenith.zenithmod.src.tileEntities.TileEntityRefiner;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class ZenithGuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		
		if(tileEntity instanceof TileEntityRefiner)
		{
			return new ContainerRefiner(player.inventory, (TileEntityRefiner)tileEntity);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityRefiner)
		{
			return new GuiRefiner(player.inventory, (TileEntityRefiner)tileEntity);	
		}
		return null;
	}

}
