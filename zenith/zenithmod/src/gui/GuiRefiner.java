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

package zenith.zenithmod.src.gui;

import org.lwjgl.opengl.GL11;

import zenith.zenithmod.src.containers.ContainerRefiner;
import zenith.zenithmod.src.tileEntities.TileEntityRefiner;

import net.minecraft.src.Container;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.StatCollector;
import net.minecraft.src.TileEntity;

public class GuiRefiner extends GuiContainer
{

	public GuiRefiner(InventoryPlayer playerInventory, TileEntityRefiner tileEntity) 
	{
		super(new ContainerRefiner(playerInventory, tileEntity));
	}
	
	protected void drawGuiContainerForegroundLayer(int x, int y) 
	{
        fontRenderer.drawString("Refiner Machine", 8, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		int text = this.mc.renderEngine.getTexture("/textures/gui/furnace.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.renderEngine.bindTexture(text);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
