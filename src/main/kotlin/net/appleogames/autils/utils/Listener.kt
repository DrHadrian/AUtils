package net.appleogames.autils.utils

import net.appleogames.autils.colors
import net.appleogames.autils.prfixes
import net.appleogames.autils.settings.settings
import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.text.Component
import org.bukkit.World
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerPortalEvent
import org.bukkit.event.player.PlayerQuitEvent

fun listener(){
    listen<PlayerPortalEvent> {
        if (!settings.alowNether && it.to.world.environment == World.Environment.NETHER){
            it.isCancelled = true
            it.player.sendMessage("${prfixes.plugin} ${col("red")}der Nether ist aktuell Deaktiviert!!!")
        }
        if (!settings.alowEnd && it.to.world.environment == World.Environment.THE_END){
            it.isCancelled = true
            it.player.sendMessage("${prfixes.plugin} ${col("red")}das End ist aktuell Deaktiviert!!!")
        }
    }
    listen<PlayerJoinEvent> {
        it.joinMessage(Component.text("${col("dark_gray")}[${col("dark_green")}+${col("dark_gray")}] ${col(if (it.player.isOp) colors.admin else "white")}${it.player.name}"))

        /*it.player.title( "${col("yellow")}Willkommen! ${if(it.player.isOp) col("aqua") else col("white")}${it.player.name}",
            "${col ("dark_aqua")}SUtils Server | powered by ${col("aqua")}Kot${col("white")}lin",
            4, 40, 10)*/
    }
    listen<PlayerQuitEvent> {
        it.quitMessage(Component.text("${col("dark_gray")}[${col("dark_red")}-${col("dark_gray")}] ${col(if (it.player.isOp) colors.admin else "withe")}${it.player.name}"))
    }
}