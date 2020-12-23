package com.KodiakTE.ReturnToSpawn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "returntospawn", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventManager {
    private static Minecraft mc = Minecraft.getInstance();
    private boolean worldLoaded = false;
    double X;
    double Y;
    double Z;

    @SubscribeEvent
    public void waitForWorldLoad(EntityJoinWorldEvent event){
        //InvisibleMobs.LOGGER.info("World Loaded");
        if(event.getEntity() == mc.player && !this.worldLoaded){
            this.worldLoaded = true;
            this.X = mc.world.getWorldInfo().getSpawnX();
            this.Y = mc.world.getWorldInfo().getSpawnY();
            this.Z = mc.world.getWorldInfo().getSpawnZ();
            System.out.println(this.X);
            System.out.println(this.Y);
            System.out.println(this.Z);
            System.out.println("world Load DETECTED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );

        }
    }

/**
    @SubscribeEvent
    public void playerSetSpawn(PlayerSetSpawnEvent event){
        if(event.getEntity().getType() == EntityType.PLAYER ){
            //System.out.println("spawn set");
            this.X = mc.player.getPosX();
            this.Y = mc.player.getPosY();
            this.Z = mc.player.getPosZ();
            System.out.println(this.X);
            System.out.println(this.Y);
            System.out.println(this.Z);
            //System.out.println(this.X);
            //System.out.println(this.Y);
            //System.out.println(this.Z);
        }
    }
    */

    @SubscribeEvent
    public void playerSleep(PlayerSleepInBedEvent event){
        if(event.getEntity().getType() == EntityType.PLAYER ){
            //System.out.println("spawn set");
            this.X = mc.player.getPosX();
            this.Y = mc.player.getPosY();
            this.Z = mc.player.getPosZ();
            System.out.println(this.X);
            System.out.println(this.Y);
            System.out.println(this.Z);
        }
    }

    @SubscribeEvent
    public void playerWake(PlayerWakeUpEvent event){
        if(event.getEntity().getType() == EntityType.PLAYER ){
            System.out.println("spawn set");
            this.X = mc.player.getPosX();
            this.Y = mc.player.getPosY();
            this.Z = mc.player.getPosZ();
            System.out.println(this.X);
            System.out.println(this.Y);
            System.out.println(this.Z);
        }
    }

    @SubscribeEvent
    public void playerHurt(LivingHurtEvent livingEntity){

            if ( livingEntity.getEntity().getType() == EntityType.PLAYER ) {

                /** if( !player.getBedPosition().isPresent() ){
                 System.out.println("Bed Gone");
                 this.X = mc.world.getWorldInfo().getSpawnX() + 0.5;
                 this.Y = mc.world.getWorldInfo().getSpawnY();
                 this.Z = mc.world.getWorldInfo().getSpawnZ() + 0.5;
                 }
                 */

                //System.out.println(this.X);
                //System.out.println(this.Y);
                //System.out.println(this.Z);

                //System.out.println("Player Hurt");

                if (livingEntity.getAmount() > 0){
                    //mc.player.sendChatMessage("/tp " + livingEntity.getEntity().getName().getString() + " " + this.X + " " + this.Y + " " + this.Z);
                    mc.player.sendChatMessage("/execute as " + livingEntity.getEntity().getName().getString() +" in minecraft:overworld run teleport " + this.X + " " + this.Y + " " + this.Z);
            }
                //server.getCommandManager().handleCommand( server.getCommandSource() , "/tp " + mc.player.getName() + " " + X + " " + Y + " " + Z );


        }
    }

}
