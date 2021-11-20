package net.appleogames.autils.settings

import net.appleogames.autils.settings.settings.alowEnd
import net.axay.kspigot.chat.col
import net.axay.kspigot.items.flag
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import net.axay.kspigot.items.name
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import net.appleogames.autils.settings.settings.alowNether

object SettingsDisplyItem {
    val back = itemStack(Material.RED_STAINED_GLASS_PANE) {
        amount = 1
        meta {
            name = "${col("dark_red")}<- ${col("gray")}Settings"
            flag(ItemFlag.HIDE_ATTRIBUTES)
        }
    }
    object generel{
        fun generel(): ItemStack{
            return itemStack(Material.COMMAND_BLOCK){
                amount = 1
                meta {
                    name = "${col("gray")}World Settings ${col("dark_green")}->"
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun alowNether(): ItemStack{
            return itemStack(Material.OBSIDIAN){
                amount = 1
                meta {
                    name = "${col("gray")}Der Nether ist " +
                            if (alowNether) {
                                    "${col("green")}aktiviert"
                                } else {
                                    "${col("red")}deaktiviert"
                                }
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun alowEnd(): ItemStack{
            return itemStack(Material.END_STONE){
                amount = 1
                meta {
                    name = "${col("gray")}Das End ist " +
                            if (alowEnd) {
                                "${col("green")}aktiviert"
                            } else {
                                "${col("red")}deaktiviert"
                            }
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
    }
    object challenges{
        fun challenges(): ItemStack{
            return itemStack(Material.COMPASS){
                amount = 1
                meta {
                    name = "${col("gray")}Challenges ${col("dark_green")}->"
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun onlyCave(): ItemStack{
            return itemStack(Material.MOSSY_COBBLESTONE){
                amount = 1
                meta {
                    name = "${col("gray")}Only Cave ist " +
                            if (settings.challenges.onlyCave) {
                                "${col("green")}aktiviert"
                            } else {
                                "${col("red")}deaktiviert"
                            }
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
    }
}