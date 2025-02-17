package fr.nocsy.mcpets.mythicmobs;

import fr.nocsy.mcpets.MCPets;
import fr.nocsy.mcpets.mythicmobs.mechanics.GivePetMechanic;
import fr.nocsy.mcpets.mythicmobs.targeters.TargeterPetOwner;
import io.lumine.mythic.bukkit.events.MythicMechanicLoadEvent;
import io.lumine.mythic.bukkit.events.MythicTargeterLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MythicListener implements Listener {

    @EventHandler
    public void onMythicTargeterLoad(MythicTargeterLoadEvent paramMythicTargeterLoadEvent) {

        String str = paramMythicTargeterLoadEvent.getTargeterName();

        if ("PETOWNER".equalsIgnoreCase(str)) {
            paramMythicTargeterLoadEvent.register(new TargeterPetOwner(paramMythicTargeterLoadEvent.getConfig()));
        }

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onMythicMechanicLoad(MythicMechanicLoadEvent event) {
        if (event.getMechanicName().equalsIgnoreCase("GivePet")) {
            GivePetMechanic givePetMechanic = new GivePetMechanic(event.getConfig());
            event.register(givePetMechanic);

            MCPets.getLog().info("[MCPets] : GivePet Mechanic loaded successfully");

        }
    }

}
