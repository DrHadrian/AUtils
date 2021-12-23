package net.appleogames.autils.settings

import net.appleogames.autils.colors
import net.appleogames.autils.prfixes.plugin as prefix
import net.appleogames.autils.settings.settings.alowEnd
import net.appleogames.autils.settings.settings.alowNether
import net.appleogames.autils.settings.settings.challenges.onlyCave as onlyCaveSetting

import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.appleogames.autils.challenge.onlyCave
import net.appleogames.autils.prfixes
import net.appleogames.autils.utils.viewDistance
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.server
import net.axay.kspigot.items.*
import org.bukkit.Material

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

            // view Distance
            placeholder(Slots.RowTwoSlotSeven, itemStack(Material.SPYGLASS){amount = 1; meta {
                name = "${col(colors.main)}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}beträgt ${server.viewDistance} Chunks."
                addLore {+"${col(colors.error)}Verändern, aktuell deaktiviert!" }
            }})
            button(Slots.RowTwoSlotSeven, SettingsDisplyItem.generel.viewDistance()) {
                    if (it.bukkitEvent.isShiftClick){
                        if (it.bukkitEvent.isLeftClick) {
                            settings.viewDistance = 12
                            viewDistance()
                            it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks gesetzt.")
                        } else if (it.bukkitEvent.isRightClick) {
                            settings.viewDistance = 6
                            viewDistance()
                            it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks gesetzt.")
                        }
                    }else{
                        if (it.bukkitEvent.isLeftClick){
                            if (settings.viewDistance < 32){
                                settings.viewDistance++
                                viewDistance()
                                it.player.sendMessage("${prfixes.plugin}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks erhöht.")
                            }
                        }
                        else if (it.bukkitEvent.isRightClick){
                            if (settings.viewDistance > 2){
                                settings.viewDistance--
                                viewDistance()
                                it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistance} Chunks gesenkt.")
                            }
                        }
                    }
                    it.bukkitEvent.currentItem = SettingsDisplyItem.generel.viewDistance()
                }

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