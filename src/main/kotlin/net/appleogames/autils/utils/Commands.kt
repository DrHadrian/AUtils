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
                this.player.sendMessage("${prfixes.plugin}${col(colors.error)}You don't have the Permission to execute this Command! ${col(colors.second)}- you need ${col(colors.admin)}Admin${col(colors.error)} you have this.player.permission")
            }
        }
    }
}