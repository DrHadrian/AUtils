package net.spurkomet.adrian.utils

import net.appleogames.autils.settings.settings
import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.broadcast
import net.axay.kspigot.extensions.bukkit.actionBar
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.task
import net.kyori.adventure.bossbar.BossBar
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.block.data.BlockData
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.entity.PlayerDeathEvent

fun onlyCave(){
    var inOcean: Boolean
    task(
        delay = 20,
        period = 20
    )
    {
        if (!settings.challenges.onlyCave){onlinePlayers.forEach{it.actionBar("")}; it.cancel()}
        onlinePlayers.forEach {
            inOcean = false
            if((oceanChack(it.location.block) || oceanChack(Location(it.location.world, it.location.x, it.location.y + 1, it.location.z, 0.0F, 0.0F).block)) && it.location.y < 62){
                inOcean = true
                for (y in it.location.y.toInt()..62){
                    if (!oceanChack(Location(it.location.world, it.location.x, y.toDouble(), it.location.z, 0.0F, 0.0F).block)){
                        inOcean = false
                        break
                    }
                }
            }
            if (!inOcean){
                if (it.location.block.lightFromSky >= (14).toByte()){
                    it.actionBar("${col("red")}Du bist in keiner Cave!")
                    it.damage(4.0)
                }else if (it.location.block.lightFromSky == (0).toByte()) {
                    it.actionBar("")
                }else{
                    it.actionBar("${col("yellow")}Du näherst dich einem Ausgan einer Cave!")
                    it.damage((it.location.block.lightFromSky.toDouble()/4))
                }
            }else{
                ocian(it)
            }
        }
    }
}
fun oceanChack(block: Block): Boolean{
    val type = block.type
    when (type){
        Material.BUBBLE_COLUMN -> return true
        Material.WATER -> return true
        Material.KELP -> return true
        Material.KELP_PLANT -> return true
        Material.TALL_SEAGRASS -> return true
        Material.ACACIA_DOOR -> return true
        Material.BIRCH_DOOR -> return true
        Material.CRIMSON_DOOR -> return true
        Material.DARK_OAK_DOOR -> return true
        Material.IRON_DOOR -> return true
        Material.JUNGLE_DOOR -> return true
        Material.OAK_DOOR -> return true
        Material.SPRUCE_DOOR -> return true
        Material.WARPED_DOOR -> return true
        else -> return false
    }
}
fun ocian(player: Player){
    val playerDeath =
    listen<PlayerDeathEvent> {if(it.entityType == EntityType.PLAYER){val playerDeath = it.entity.player}}
    task(
        delay = 0,
        period = 0
    ) {
        player.actionBar("${col("blue")}Du bist in einem Ocean!")
        player.damage(4.0)
        if (playerDeath == player || !oceanChack(player.location.block) || !oceanChack(Location(player.location.world, player.location.x, player.location.y + 1, player.location.z, 0.0F, 0.0F).block)){
            it.cancel()
        }
    }
}