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

package zenith.zenithmod.src.entities;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityLaserBeam extends Entity
{
	
	private EntityPlayer playerShooting;
	
    public EntityLaserBeam(World par1World)
    {
        super(par1World);
        this.setSize(0.5F, 0.5F);
    }

	public EntityLaserBeam(World world, EntityLiving player) 
	{
		super(world);
		
		playerShooting = (EntityPlayer)player;
		
        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight() - 0.3f, player.posZ, player.rotationYaw, player.rotationPitch);
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, 3.0f, 1.0F);
        
        this.setPosition(posX + motionX, posY + motionY, posZ + motionZ);
	}
	
    public void onUpdate()
    {
        super.onUpdate();
    
        Vec3 var17 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
        Vec3 var3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        MovingObjectPosition var4 = this.worldObj.rayTraceBlocks_do_do(var17, var3, false, true);
        var17 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
        var3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

        if (var4 != null)
        {
            var3 = this.worldObj.getWorldVec3Pool().getVecFromPool(var4.hitVec.xCoord, var4.hitVec.yCoord, var4.hitVec.zCoord);
            Random rand = new Random();
            int chance = rand.nextInt(10000);
            
            if(chance == 9999) this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0f, true);
            
            this.setDead();
        }
        
        Entity var5 = null;
        List var6 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
        double var7 = 0.0D;
        float var11;
        
        for (int i = 0; i < var6.size(); i++)
        {
            Entity var10 = (Entity)var6.get(i);
            
            if (var10.canBeCollidedWith() && var10 != this.playerShooting)
            {
                var11 = 0.3F;
                AxisAlignedBB var12 = var10.boundingBox.expand((double)var11, (double)var11, (double)var11);
                MovingObjectPosition var13 = var12.calculateIntercept(var17, var3);

                if (var13 != null)
                {
                    double var14 = var17.distanceTo(var13.hitVec);

                    if (var14 < var7 || var7 == 0.0D)
                    {
                        var5 = var10;
                        var7 = var14;
                    }
                }
            }
        }
        
        if (var5 != null)
        {
            var4 = new MovingObjectPosition(var5);
        }

        if (var4 != null)
        {
            if (var4.entityHit != null)
            {
                
                if(var4.entityHit instanceof EntityLiving)
                {
                	
                	EntityLiving entity = (EntityLiving)var4.entityHit;
	            	entity.knockBack(entity, 0, -motionX, -motionZ);
	            	entity.setFire(2);
	            	entity.attackEntityFrom(DamageSource.causePlayerDamage(playerShooting), 3);
	            	this.setDead();
                }
            }
        }
        
        this.posX += this.motionX;
        this.posY += this.motionY;
        this.posZ += this.motionZ;
        
        this.setPosition(this.posX, this.posY, this.posZ);
        this.doBlockCollisions();
    }
    
    public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8)
    {
        float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)var9;
        par3 /= (double)var9;
        par5 /= (double)var9;
        par1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
        par3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
        par5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)var10) * 180.0D / Math.PI);
    }

	@Override
	protected void entityInit()
	{
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound var1) 
	{
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound var1) 
	{
		
	}

}
