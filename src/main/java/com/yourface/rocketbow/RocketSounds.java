package com.yourface.rocketbow;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

@ObjectHolder(RocketBowConstants.MODID)
public class RocketSounds {
	
	@ObjectHolder("boom")
	public static final SoundEvent BOOM = createSoundEvent("boom");

	public static SoundEvent createSoundEvent(String soundName) {
		ResourceLocation location = new ResourceLocation(RocketBowConstants.MODID, soundName);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(location);
	    return event;	
	}
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
			event.getRegistry().registerAll(
				BOOM
			);
		}
	}
}
