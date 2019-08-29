package com.yourface.rocketbow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
@Mod(modid = RocketBowConstants.MODID, version = RocketBowConstants.VERSION)
public class RocketBow
{
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(this);
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.DIRT.getUnlocalizedName());
    }
    
    @SubscribeEvent
    public void boomArrows(LivingHurtEvent event) {
        System.out.println("livinghurtevent --> " + event.getEntity());	
        Entity dude = event.getEntityLiving();
        BlockPos dudePos = dude.getPosition();
        event.getSource().isProjectile();
        if (event.getSource().isProjectile()) {
        	System.out.println("we have an arrow, I think.");
        	World world = event.getEntityLiving().getEntityWorld();
        	world.createExplosion(dude, dudePos.getX(), dudePos.getY(), dudePos.getZ(), 500, true);
//            if (dude instanceof )
  //          world.playSound(dude, dudePos, RocketSounds.BOOM, SoundCategory.MASTER,  1.0f, 1.0f);
            world.playSound(dudePos.getX(),  dudePos.getY(),  dudePos.getZ(), RocketSounds.BOOM, SoundCategory.MASTER, 1.0f, 1.0f, false);
        }
/*        World world = event.getWorld();
        world.playSound(event.getEntityPlayer(), event.getEntityPlayer().getPosition(), RocketSounds.BOOM, SoundCategory.MASTER,  1.0f, 1.0f);
        System.out.println("played the gassy arrow.");	 */
    }
}
