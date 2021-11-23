package net.appleogames.autils.utils

import net.appleogames.autils.colors
import net.appleogames.autils.prfixes
import net.appleogames.autils.settings.settings
import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.onlinePlayers
import net.kyori.adventure.text.Component
import org.bukkit.Server
import org.bukkit.World
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerPortalEvent
import org.bukkit.event.player.PlayerQuitEvent

fun listener(){
    listen<PlayerPortalEvent> {
        if (!settings.alowNether && it.to.world.environment == World.Environment.NETHER){
            it.isCancelled = true
        }
        if (!settings.alowEnd && it.to.world.environment == World.Environment.THE_END){
            it.isCancelled = true
        }
    }
    listen<PlayerJoinEvent> {
        it.joinMessage(Component.text("${col(colors.main)}(${col("dark_green")}+${col(colors.main)}) ${col(if (it.player.isOp) colors.admin else colors.main)}${it.player.name}"))
    }
    listen<PlayerQuitEvent> {
        it.quitMessage(Component.text("${col(colors.main)}(${col("dark_red")}-${col(colors.main)}) ${col(if (it.player.isOp) colors.admin else colors.main)}${it.player.name}"))
    }
}