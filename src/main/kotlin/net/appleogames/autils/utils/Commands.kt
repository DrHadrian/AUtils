package net.appleogames.autils.utils

import net.appleogames.autils.colors
import net.appleogames.autils.prfixes
import net.appleogames.autils.settings.SettingsGUI
import net.axay.kspigot.chat.col
import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.runs
import net.axay.kspigot.gui.openGUI

class Commands {
    val settingsCommand = command("settings"){
        runs{
            if (this.player.isOp){
                this.player.openGUI(SettingsGUI().gui)
            }else{
                this.player.sendMessage("${prfixes.plugin}${col("red")}Du brauchst ${col(colors.admin)}Admin-Rechte${col("red")}, um diesen command auszuführen")
            }
        }
    }
}