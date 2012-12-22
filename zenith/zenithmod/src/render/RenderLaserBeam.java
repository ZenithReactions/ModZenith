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

package zenith.zenithmod.src.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import zenith.zenithmod.src.entities.EntityLaserBeam;

public class RenderLaserBeam extends Render
{
    public void renderLaserBeam(EntityLaserBeam entityLaserBeam, double par2, double par4, double par6, float par8, float par9)
    {
        this.loadTexture("/textures/misc/laserbeam.png");
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(entityLaserBeam.prevRotationYaw + (entityLaserBeam.rotationYaw - entityLaserBeam.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(entityLaserBeam.prevRotationPitch + (entityLaserBeam.rotationPitch - entityLaserBeam.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        Tessellator var10 = Tessellator.instance;
        byte var11 = 0;
        float var12 = 0.0F;
        float var13 = 0.5F;
        float var14 = (float)(0 + var11 * 10) / 32.0F;
        float var15 = (float)(5 + var11 * 10) / 32.0F;
        float var16 = 0.0F;
        float var17 = 0.15625F;
        float var18 = (float)(5 + var11 * 10) / 32.0F;
        float var19 = (float)(10 + var11 * 10) / 32.0F;
        float var20 = 0.05625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        
        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(var20, var20, var20);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(var20, 0.0F, 0.0F);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)var16, (double)var18);
        var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)var17, (double)var18);
        var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)var17, (double)var19);
        var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)var16, (double)var19);
        var10.draw();
        GL11.glNormal3f(-var20, 0.0F, 0.0F);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)var16, (double)var18);
        var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)var17, (double)var18);
        var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)var17, (double)var19);
        var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)var16, (double)var19);
        var10.draw();

        for (int var23 = 0; var23 < 4; ++var23)
        {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, var20);
            var10.startDrawingQuads();
            var10.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)var12, (double)var14);
            var10.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)var13, (double)var14);
            var10.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)var13, (double)var15);
            var10.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)var12, (double)var15);
            var10.draw();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderLaserBeam((EntityLaserBeam)par1Entity, par2, par4, par6, par8, par9);
    }
}
