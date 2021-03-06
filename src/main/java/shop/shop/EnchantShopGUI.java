package shop.shop;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.bukkit.Material.IRON_SWORD;
import static org.bukkit.enchantments.Enchantment.*;

public class EnchantShopGUI extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");
    private static Economy econ = null;
    private static Permission perms = null;
    private static Chat chat = null;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equals("인첸트상점")) {
            if (sender instanceof Player) {

                Inventory gui = Bukkit.createInventory(player, 54, ChatColor.BLACK + "인첸트상점");

                ItemStack armor = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta arm_meta = armor.getItemMeta();
                arm_meta.setDisplayName("갑옷 인첸트");

                ItemStack sword = new ItemStack(IRON_SWORD);
                ItemMeta sword_meta = sword.getItemMeta();
                sword_meta.setDisplayName("검 인첸트");

                ItemStack close = new ItemStack(Material.BARRIER);
                ItemMeta close_meta = close.getItemMeta();
                close_meta.setDisplayName(ChatColor.RED + "닫기");

                ItemStack nullslot = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta nullmeta = nullslot.getItemMeta();
                nullmeta.setDisplayName(null);

                ItemStack pro4 = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta pro4_meta = pro4.getItemMeta();
                pro4_meta.setDisplayName("보호4 인첸트책");
                pro4_meta.addEnchant(PROTECTION_ENVIRONMENTAL, 4, true);
                ArrayList<String> pro4_lore = new ArrayList<>();
                pro4_lore.add("50000원");
                pro4_meta.setLore(pro4_lore);

                ItemStack sharp5 = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta sharp_meta = sharp5.getItemMeta();
                sharp_meta.setDisplayName("날카로움5 인첸트책");
                sharp_meta.addEnchant(DAMAGE_ALL, 5, true);
                ArrayList<String> sharp_lore = new ArrayList<>();
                sharp_lore.add("52500원");
                sharp_meta.setLore(sharp_lore);

                ItemStack fall = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta fall_meta = fall.getItemMeta();
                fall_meta.addEnchant(PROTECTION_FALL, 4, true);
                fall_meta.setDisplayName("가벼운 착지4 인첸트책");
                ArrayList<String> fall_lore = new ArrayList<>();
                fall_lore.add("42500원");
                fall_meta.setLore(fall_lore);

                ItemStack water_friendly = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta wf_meta = water_friendly.getItemMeta();
                fall_meta.addEnchant(WATER_WORKER,1,true);
                wf_meta.setDisplayName("친수성 인첸트책");
                ArrayList<String> wf_lore = new ArrayList<>();
                wf_lore.add("47500원");
                wf_meta.setLore(wf_lore);

                ItemStack breath = new ItemStack(Material.ENCHANTED_BOOK);
                ItemMeta breath_meta = breath.getItemMeta();
                breath_meta.addEnchant(OXYGEN,3,true);
                breath_meta.setDisplayName("호흡3 인첸트책");
                ArrayList<String> breath_lore = new ArrayList<>();
                breath_lore.add("40000원");


                gui.setItem(0, nullslot);
                gui.setItem(1, nullslot);
                gui.setItem(2, nullslot);
                gui.setItem(3, nullslot);
                gui.setItem(4, nullslot);
                gui.setItem(5, nullslot);
                gui.setItem(6, nullslot);
                gui.setItem(7, nullslot);
                gui.setItem(8, nullslot);
                //상단 테두리
                gui.setItem(45, nullslot);
                gui.setItem(46, nullslot);
                gui.setItem(47, nullslot);
                gui.setItem(48, nullslot);
                gui.setItem(49, nullslot);
                gui.setItem(50, nullslot);
                gui.setItem(51, nullslot);
                gui.setItem(52, nullslot);
                //하단 테두리
                gui.setItem(9, nullslot);
                gui.setItem(18, nullslot);
                gui.setItem(27, nullslot);
                gui.setItem(36, nullslot);
                //좌측 테두리
                gui.setItem(17, nullslot);
                gui.setItem(26, nullslot);
                gui.setItem(35, nullslot);
                gui.setItem(44, nullslot);
                //우측테두리
                gui.setItem(11, armor);
                gui.setItem(20, sword);
                //분류

                gui.setItem(12, pro4);
                gui.setItem(13, fall);
                gui.setItem(14 , water_friendly);
                gui.setItem(15,breath);
                //갑옷 인첸트
                gui.setItem(20, sharp5);
                //칼 인첸트


                gui.setItem(53, close);
            } else {
                log.severe("이 명령어를 버킷에서 사용하실수 없습니다!");
            }
        }
        return false;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {


        ItemStack pro4 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta pro4_meta = pro4.getItemMeta();
        pro4_meta.setDisplayName("보호4 인첸트책");
        pro4_meta.addEnchant(PROTECTION_ENVIRONMENTAL, 4, true);

        ItemStack sharp5 = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta sharp_meta = sharp5.getItemMeta();
        sharp_meta.setDisplayName("날카로움5 인첸트책");
        sharp_meta.addEnchant(DAMAGE_ALL, 5, true);

        ItemStack fall = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta fall_meta = fall.getItemMeta();
        fall_meta.addEnchant(PROTECTION_FALL, 4, true);
        fall_meta.setDisplayName("가벼운 착지4 인첸트책");

        ItemStack water_friendly = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta wf_meta = water_friendly.getItemMeta();
        fall_meta.addEnchant(WATER_WORKER,1,true);
        wf_meta.setDisplayName("친수성 인첸트책");

        ItemStack breath = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta breath_meta = breath.getItemMeta();
        breath_meta.addEnchant(OXYGEN,3,true);
        breath_meta.setDisplayName("호흡3 인첸트책");



        if (e.getClickedInventory().equals("인첸트상점")) {
            Player player = (Player) e.getWhoClicked();
            int slot = e.getRawSlot();
            double money = Double.parseDouble(econ.format(econ.getBalance(player.getName())));
            switch (e.getCurrentItem().getType()) {
                case BARRIER:
                    player.closeInventory();
                    break;
                case ENCHANTED_BOOK:
                    if (slot == 12) {
                        if (e.isRightClick()) {
                            player.sendMessage(ChatColor.RED + "이 아이템은 판매할수 없습니다!");
                        } else if (e.isLeftClick()) {
                                    if (money >= 50000) {
                                    player.getInventory().addItem(pro4);
                                        EconomyResponse minus = econ.withdrawPlayer(player,50000);
                                        player.sendMessage("성공적으로 아이템을 구매하였습니다!");
                                } else if (money < 50000) {
                                    player.sendMessage(ChatColor.RED + "잔액이 부족합니다");
                                }
                            }
                    } else if (slot == 13) {
                        if (e.isRightClick()) {
                            player.sendMessage(ChatColor.RED + "이 아이템은 판매할수 없습니다!");
                        } else if(e.isLeftClick())
                            if (money >= 42500) {
                                player.getInventory().addItem(fall);
                                EconomyResponse minus = econ.withdrawPlayer(player,42500);
                                player.sendMessage("성공적으로 아이템을 구매하였습니다!");
                            } else if (money < 42500) {
                                player.sendMessage(ChatColor.RED + "잔액이 부족합니다");
                            }

                    } else if (slot == 14) {
                        if (e.isRightClick()) {
                            player.sendMessage(ChatColor.RED + "이 아이템은 판매할수 없습니다!");
                        } else if (e.isLeftClick()) {
                            if (money >= 47500) {
                                player.getInventory().addItem(water_friendly);
                                EconomyResponse minus = econ.withdrawPlayer(player,47500);
                                player.sendMessage("성공적으로 아이템을 구매하였습니다!");
                            } else if (money < 47500) {
                                player.sendMessage(ChatColor.RED + "잔액이 부족합니다");
                            }
                        }

                    } else if(slot == 15) {
                        if (e.isRightClick()) {
                            player.sendMessage(ChatColor.RED + "이 아이템은 판매할수 없습니다!");
                        } else if (e.isLeftClick()) {
                            if (money >= 40000) {
                                player.getInventory().addItem(water_friendly);
                                EconomyResponse minus = econ.withdrawPlayer(player,40000);
                                player.sendMessage("성공적으로 아이템을 구매하였습니다!");
                            } else if (money < 40000) {
                                player.sendMessage(ChatColor.RED + "잔액이 부족합니다");
                            }
                        }

                    }

                    }

                    e.setCancelled(true);
            }
        }
    }


