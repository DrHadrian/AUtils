package net.appleogames.autils.utils

import net.appleogames.autils.settings.settings
import net.axay.kspigot.extensions.worlds
import org.bukkit.Bukkit
import org.bukkit.World

fun viewDistanz(){
    worlds.forEach{it.viewDistance = settings.viewDistanz}
}