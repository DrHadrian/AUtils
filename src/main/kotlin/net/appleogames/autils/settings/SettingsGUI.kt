package net.appleogames.autils.settings

import net.appleogames.autils.prefix
import net.appleogames.autils.settings.settings.alowEnd
import net.appleogames.autils.settings.settings.alowNether
import net.appleogames.autils.settings.settings.challenges.onlyCave as onlyCaveSetting

import net.axay.kspigot.chat.col
import net.axay.kspigot.gui.GUIType
import net.axay.kspigot.gui.Slots
import net.axay.kspigot.gui.kSpigotGUI
import net.spurkomet.adrian.utils.onlyCave

class SettingsGUI {
    val gui = kSpigotGUI(GUIType.THREE_BY_NINE){
        title = "Settings"
        defaultPage = 0
        page(0){
            this.pageChanger(Slots.RowTwoSlotOne, SettingsDisplyItem.generel.generel(), 1){}
            this.pageChanger(Slots.RowTwoSlotThree, SettingsDisplyItem.challenges.challenges(), 2){}
        }

        // ---------- World -----------
        page(1){
            button(Slots.RowThreeSlotOne, SettingsDisplyItem.generel.alowNether()){
                if (alowNether) {
                    alowNether = false
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Der Nether " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}."
                    )
                } else {
                    alowNether = true
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Der Nether " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.generel.alowNether()
            }
            button(Slots.RowThreeSlotTwo, SettingsDisplyItem.generel.alowEnd()){
                if (alowEnd) {
                    alowEnd = false
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Das End " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}."
                    )
                } else {
                    alowEnd = true
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Das End " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.generel.alowNether()
            }
            this.pageChanger(Slots.RowOneSlotNine, SettingsDisplyItem.back, 0){}
        }
        // ---------- Challenges -----------
        page(2){
            button(Slots.RowThreeSlotOne, SettingsDisplyItem.challenges.onlyCave()){
                if (onlyCaveSetting) {
                    onlyCaveSetting = false
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Only Cave " +
                                "${col("white")}wurde " +
                                "${col("red")}deaktiviert${col("white")}."
                    )
                } else {
                    onlyCaveSetting = true
                    onlyCave()
                    it.player.sendMessage(
                        "${prefix()}${col("gray")}Only Cave " +
                                "${col("white")}wurde " +
                                "${col("green")}aktiviert${col("white")}."
                    )
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.challenges.onlyCave()
            }
            this.pageChanger(Slots.RowOneSlotNine, SettingsDisplyItem.back, 0){}
        }
    }
}