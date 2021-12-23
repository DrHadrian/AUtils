package net.appleogames.autils.utils

import net.appleogames.autils.settings.settings
import net.axay.kspigot.extensions.worlds
import org.bukkit.Bukkit
import org.bukkit.World

fun viewDistance(){
    worlds.forEach{it.viewDistance = settings.viewDistance}
}