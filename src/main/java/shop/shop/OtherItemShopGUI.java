package shop.shop;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class OtherItemShopGUI extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd ,String Label,String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equals("기타상점")) {
            if(sender instanceof Player) {

                Inventory gui = Bukkit.createInventory(player, 54, ChatColor.BLACK + "기타아이템상점");


                ItemStack close = new ItemStack(Material.BARRIER);
                ItemMeta close_meta = close.getItemMeta();
                close_meta.setDisplayName(ChatColor.RED + "닫기");

                ItemStack block = new ItemStack(Material.GRASS_BLOCK);

                gui.setItem(53, close);
            } else {
                log.severe("이 명령어를 버킷에서 사용하실수 없습니다");
            }
        }
        return false;
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if(e.getClickedInventory().equals("기타아이템상점")) {
            switch (e.getCurrentItem().getType()) {
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            e.setCancelled(true);
        }
    }


}

