package net.appleogames.autils.settings

import net.appleogames.autils.colors
import net.appleogames.autils.settings.settings.alowEnd
import net.axay.kspigot.chat.col
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import net.appleogames.autils.settings.settings.alowNether
import net.appleogames.autils.settings.settings.viewDistanz
import net.axay.kspigot.items.*

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
                    name = "${col(colors.main)}Der ${col(colors.akzent)}Nether ${col(colors.main)}ist " +
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
                    name = "${col(colors.main)}Das ${col(colors.akzent)}End${col(colors.main)} ist " +
                            if (alowEnd) {
                                "${col("green")}aktiviert"
                            } else {
                                "${col("red")}deaktiviert"
                            }
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                }
            }
        }
        fun viewDistanz(): ItemStack{
            return itemStack(Material.SPYGLASS){
                amount = 1
                meta {
                    name = "${col(colors.main)}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}beträgt $viewDistanz Chunks. "
                    flag(ItemFlag.HIDE_ATTRIBUTES)
                    addLore {
                        +"${col(colors.second)}Left Click to Up"
                        +"${col(colors.second)}Right Click to Down"
                        +""
                        +"${col(colors.akzent)}Optimized Defaults:"
                        +"${col(colors.second)}Shift Left Click: 6 Chunks - for Minigames"
                        +"${col(colors.second)}Shift Right Click: 12 Chunks - for Survival"
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
                    name = "${col(colors.akzent)}Only Cave ${col(colors.main)}ist " +
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