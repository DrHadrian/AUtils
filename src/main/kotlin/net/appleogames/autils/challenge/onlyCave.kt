package net.appleogames.autils.challenge

import net.appleogames.autils.settings.settings
import net.axay.kspigot.chat.col
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.bukkit.actionBar
import net.axay.kspigot.extensions.onlinePlayers
import net.axay.kspigot.runnables.task
import net.appleogames.autils.challenge.onlyCave.playerIsInOcian
import net.appleogames.autils.colors
import net.appleogames.autils.prfixes
import net.axay.kspigot.extensions.events.cancel
import org.bukkit.*
import org.bukkit.block.Biome
import org.bukkit.block.Block
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.inventory.PrepareItemCraftEvent
import org.bukkit.event.player.PlayerQuitEvent

object onlyCave{
    var playerIsInOcian = arrayListOf<Player>()
}

    fun onlyCave(){
        listen<PrepareItemCraftEvent> {
            if(settings.challenges.onlyCave){
                if (it.inventory.result?.type == Material.TINTED_GLASS){
                    it.cancel()
                    it.view.player.sendMessage("${prfixes.plugin}${col(colors.error)}Tinted Glass ist Verboten!")
                }
            }
        }
        var inOcean: Boolean
        var player: Player
        var playerIsInArray: Boolean
        var locTop: Block
        var locBot: Block
        var world: World
        task(
            delay = 20,
            period = 20,
            endCallback = {onlinePlayers.forEach { it.actionBar("")}}
        )
        {
            if (!settings.challenges.onlyCave){
                onlinePlayers.forEach{it.actionBar("")}
                it.cancel()
            }else{
                onlinePlayers.forEach {
                    inOcean = false
                    locBot = it.location.block
                    locTop = Location(it.location.world, it.location.x, it.location.y+1, it.location.z, 0.0F, 0.0F).block
                    world = it.world
                    if((locBot.oceanCheck() || locTop.oceanCheck()) && it.location.y < 62 && world.oceanCheck(it.location)){
                        inOcean = true
                        for (y in it.location.y.toInt()..62){
                            if (!(Location(it.location.world, it.location.x, y.toDouble(), it.location.z, 0.0F, 0.0F).block).oceanCheck()){
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
                            it.actionBar("${col("yellow")}Du näherst dich einem Ausgang einer Cave!")
                            it.damage((it.location.block.lightFromSky.toDouble()/4))
                        }
                    }else{
                        if (playerIsInOcian.isEmpty()){playerIsInOcian.add(it); ocian()
                        }
                        else{
                            player = it
                            playerIsInArray = false
                            playerIsInOcian.forEach { if (it == player) playerIsInArray = true }
                            if (!playerIsInArray){playerIsInOcian.add(it)}
                        }




                    }
                }
            }
        }
    }
    fun Block.oceanCheck(): Boolean{
        val type = this.type
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
    fun World.oceanCheck(location: Location): Boolean{
        when (this.getBiome(location)){
            Biome.COLD_OCEAN -> return true
            Biome.OCEAN -> return true
            Biome.WARM_OCEAN -> return true
            Biome.DEEP_OCEAN -> return true
            Biome.DEEP_COLD_OCEAN -> return true
            Biome.DEEP_FROZEN_OCEAN -> return true
            Biome.FROZEN_OCEAN -> return true
            Biome.LUKEWARM_OCEAN -> return true
            Biome.DEEP_LUKEWARM_OCEAN -> return true
            else -> return false
        }


    }
    fun ocian(){
        val playerDeath = listen<PlayerDeathEvent> {if(it.entityType == EntityType.PLAYER){val playerDeath = it.entity.player}}
        val playerQuitEvent = listen<PlayerQuitEvent> {val playerQuitEvent = it.player}
        var removePlayer = arrayListOf<Player>()
        task(
            delay = 20,
            period = 20
        ) {task ->
            if (playerIsInOcian.isEmpty()){task.cancel()}
            playerIsInOcian.forEach {
                it.actionBar("${col("blue")}Du bist in einem Ocean!")
                it.damage(4.0)
                if (playerDeath == it ||
                    playerQuitEvent == it ||
                    !(it.location.block).oceanCheck() ||
                    !(Location(it.location.world, it.location.x, it.location.y+1, it.location.z, 0.0F, 0.0F).block).oceanCheck())
                {
                    removePlayer.add(it)
                }
            }
            removePlayer.forEach { playerIsInOcian.remove(it.player) }
            removePlayer.clear()
        }
    }