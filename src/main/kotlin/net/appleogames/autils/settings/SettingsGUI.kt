package net.appleogames.autils.settings

import net.appleogames.autils.colors
import net.appleogames.autils.prfixes
import net.appleogames.autils.prfixes.plugin as prefix
import net.appleogames.autils.settings.settings.alowEnd
import net.appleogames.autils.settings.settings.alowNether
import net.appleogames.autils.utils.viewDistanz
import net.appleogames.autils.settings.settings.challenges.onlyCave as onlyCaveSetting

import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.appleogames.autils.challange.onlyCave
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.items.*
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class SettingsGUI {
    val gui = kSpigotGUI(GUIType.THREE_BY_NINE){
        title = "Settings"
        defaultPage = 0
        page(0){
            this.pageChanger(Slots.RowTwoSlotFour, SettingsDisplyItem.generel.generel(), 1){}
            this.pageChanger(Slots.RowTwoSlotSix, SettingsDisplyItem.challenges.challenges(), 2){}
        }

        // ---------- World -----------
        //   alow end
        page(1){
            button(Slots.RowTwoSlotTwo, SettingsDisplyItem.generel.alowNether()){
                if (alowNether) {
                    alowNether = false
                    it.player.sendMessage(
                        "${prefix}Der ${col(colors.akzent)}Nether " +
                                "${col(colors.main)}wurde " +
                                "${col("red")}deaktiviert${col(colors.main)}."
                    )
                } else {
                    alowNether = true
                    it.player.sendMessage(
                        "${prefix}Der ${col(colors.akzent)}Nether " +
                                "${col(colors.main)}wurde " +
                                "${col("green")}aktiviert${col(colors.main)}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.generel.alowNether()
            }

            //   alow Nether
            button(Slots.RowTwoSlotFour, SettingsDisplyItem.generel.alowEnd()){
                if (alowEnd) {
                    alowEnd = false
                    it.player.sendMessage(
                        "${prefix}Das ${col(colors.akzent)}End " +
                                "${col(colors.main)}wurde " +
                                "${col("red")}deaktiviert${col(colors.main)}."
                    )
                } else {
                    alowEnd = true
                    it.player.sendMessage(
                        "${prefix}Das ${col(colors.akzent)}End " +
                                "${col(colors.main)}wurde " +
                                "${col("green")}aktiviert${col(colors.main)}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.generel.alowEnd()
            }

            // view Distanz
            placeholder(Slots.RowTwoSlotSeven, itemStack(Material.SPYGLASS){amount = 1; meta {name = "${col(colors.akzent)}Sichtweite ${col(colors.error)}is temporary disabled!"}})
            /*button(Slots.RowTwoSlotSeven, SettingsDisplyItem.generel.viewDistanz()) {
                    if (it.bukkitEvent.isShiftClick){
                        if (it.bukkitEvent.isLeftClick) {
                            settings.viewDistance = 12
                            viewDistanz()
                            it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks gesetzt.")
                        } else if (it.bukkitEvent.isRightClick) {
                            settings.viewDistance = 6
                            viewDistanz()
                            it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks gesetzt.")
                        }
                    }else{
                        if (it.bukkitEvent.isLeftClick){
                            if (settings.viewDistance < 32){
                                settings.viewDistance++
                                viewDistanz()
                                it.player.sendMessage("${prfixes.plugin}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks erhöht.")
                                broadcast("${settings.viewDistance}")
                            }
                        }
                        else if (it.bukkitEvent.isRightClick){
                            if (settings.viewDistance > 2){
                                settings.viewDistance--
                                viewDistanz()
                                it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks gesenkt.")
                                broadcast("${settings.viewDistance}")
                            }
                        }
                    }
                    it.bukkitEvent.currentItem = SettingsDisplyItem.generel.viewDistanz()
                }*/

            // ------- Back -------
            this.pageChanger(Slots.RowOneSlotNine, SettingsDisplyItem.back, 0){}
        }
        // ---------- Challenges -----------
        page(2){
            button(Slots.RowTwoSlotFive, SettingsDisplyItem.challenges.onlyCave()){
                if (onlyCaveSetting) {
                    onlyCaveSetting = false
                    it.player.sendMessage(
                        "${prefix}${col(colors.akzent)}Only Cave " +
                                "${col(colors.main)}wurde " +
                                "${col("red")}deaktiviert${col(colors.main)}."
                    )
                } else {
                    onlyCaveSetting = true
                    onlyCave()
                    it.player.sendMessage(
                        "${prefix}${col(colors.akzent)}Only Cave " +
                                "${col(colors.main)}wurde " +
                                "${col("green")}aktiviert${col(colors.main)}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.challenges.onlyCave()
            }
            this.pageChanger(Slots.RowOneSlotNine, SettingsDisplyItem.back, 0){}
        }
    }
}