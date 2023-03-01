package me.harsh.hypixelmigratoraddon.utils;

import de.marcely.bedwars.libraries.com.cryptomorin.xseries.XMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;


public enum ItemManager {
    WOOL("wool", XMaterial.WHITE_WOOL.parseItem()),
    CLAY( "hardened_clay", XMaterial.TERRACOTTA.parseItem()),
    GLASS("blast-proof_glass", new ItemStack(Material.GLASS)),
    END_STONE( "end_stone", null),
    LADDER("ladder", null),
    WOOD("oak_wood_planks", XMaterial.OAK_PLANKS.parseItem()),
    OBSIDIAN("obsidian", null),
    STONE_SWORD("stone_sword", null),
    IRON_SWORD("iron_sword", null),
    DIAMOND_SWORD("diamond_sword", null),
    KNOCKBACK_STICK("stick_(knockback_i)", new ItemStack(Material.STICK)),
    CHAINMAIL_ARMOR("chainmail_boots", null),
    IRON_ARMOR("iron_boots", null),
    DIAMOND_ARMOR("diamond_boots", null),
    SHEARS("shears", null),
    WOODEN_PICKAXE("wooden_pickaxe", null),
    WOODEN_AXE("wooden_axe", null),
    ARROW("arrow", null),
    BOW_ONE("bow", Utils.getBow(false, false)),
    BOW_TWO("bow_(power_i)", Utils.getBow(true, false)),
    BOW_THREE("bow_(power_i__punch_i)", Utils.getBow(true, true)),
    SPEED_POTION("speed_ii_potion_(45_seconds)", Utils.getPotion("speed")),
    JUMP_POTION("jump_v_potion_(45_seconds)", Utils.getPotion("jump")),
    INVISIBILITY_POTION("invisibility_potion_(30_seconds)", Utils.getPotion("invis")),
    GOLDEN_APPLE("golden_apple", null),
    BEDBUG("bedbug", null),
    DREAM_DEFENDER("dream_defender", XMaterial.GHAST_SPAWN_EGG.parseItem()),
    FIREBALL("fireball", XMaterial.FIRE_CHARGE.parseItem()),
    TNT("tnt", null),
    ENDER_PEARL("ender_pearl", null),
    WATER_BUCKET("water_bucket", null),
    BRIDGE_EGG("bridge_egg", XMaterial.EGG.parseItem()),
    MAGIC_MILK("magic_milk", XMaterial.MILK_BUCKET.parseItem()),
    SPONGE("sponge", null),
    POPUP_TOWER("compact_pop-up_tower", new ItemStack(Material.CHEST));

    ItemManager(String id, ItemStack icon) {
        this.materialName = id;
        this.privateItem = icon;
    }

    private final String materialName;
    private final ItemStack privateItem;
    public String getMaterialName() {
        return this.materialName;
    }

    public ItemStack getPrivateItem() {
        return privateItem;
    }

    public Material getMaterial() {
        if (privateItem == null)
            return Material.matchMaterial(materialName);
        return getPrivateItem().getType();
    }
    public ItemStack getItem() {
        if (privateItem == null) {
            if (Material.matchMaterial(materialName) == null)
                return new ItemStack(Material.BEDROCK);

            return new ItemStack(Material.matchMaterial(materialName));
        }
        return getPrivateItem();
    }

    public static ItemManager matchItem(String item) {
        return Arrays.stream(values()).filter(layoutItem -> layoutItem.getMaterialName().equals(item)).findAny().orElse(null);
    }
}
