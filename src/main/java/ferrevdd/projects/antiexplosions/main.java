package ferrevdd.projects.antiexplosions;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.java.JavaPlugin;

    public final class main extends JavaPlugin implements Listener {
        @Override
        public void onEnable() {
            System.out.println("[Anti Explosions] Plugin started");
            getServer().getPluginManager().registerEvents(this, this);
        }
        @Override
        public void onDisable() {
            System.out.println("[Anti Explosions] Plugin stopped");
        }

        @EventHandler
        public void onEntityExplode(EntityExplodeEvent e) {
            if (e.getEntity().getType().equals(EntityType.PRIMED_TNT)
                    || e.getEntity().getType().equals(EntityType.MINECART_TNT)
                    || e.getEntity().getType().equals(EntityType.ENDER_CRYSTAL)) {
                e.blockList().clear();
                e.setCancelled(true);
            }
        }
    }
