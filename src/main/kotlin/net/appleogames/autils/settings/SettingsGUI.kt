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
            button(Slots.RowTwoSlotSeven, SettingsDisplyItem.generel.viewDistanz()) {
                if (it.bukkitEvent.isShiftClick){
                    if (it.bukkitEvent.isLeftClick) {
                        settings.viewDistanz = 12
                        viewDistanz()
                        it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistanz} Chunks gesetzt.")
                    } else if (it.bukkitEvent.isRightClick) {
                        settings.viewDistanz = 6
                        viewDistanz()
                        it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistanz} Chunks gesetzt.")
                    }
            }else{
                    if (it.bukkitEvent.isLeftClick){
                        if (settings.viewDistanz < 32){
                            settings.viewDistanz++
                            viewDistanz()
                            it.player.sendMessage("${prfixes.plugin}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistanz} Chunks erhöht.")
                        }
                    }
                    else if (it.bukkitEvent.isRightClick){
                        if (settings.viewDistanz > 2){
                            settings.viewDistanz--
                            viewDistanz()
                            it.player.sendMessage("${prefix}Die ${col(colors.akzent)}Sichtweite ${col(colors.main)}wurde auf ${settings.viewDistanz} Chunks gesenkt.")
                        }
                    }
                }
                it.bukkitEvent.currentItem = SettingsDisplyItem.generel.viewDistanz()
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