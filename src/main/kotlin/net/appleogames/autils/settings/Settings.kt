package net.appleogames.autils.settings

import net.appleogames.autils.InternalMainClass
import net.axay.kspigot.extensions.server
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object settings {
    val dir = File("./plugins/AUtils/")
    val file = File(dir, "config.yml")
    var configuration = YamlConfiguration.loadConfiguration(file)

    var alowNether = true
    var alowEnd = true
    var viewDistanz = server.viewDistance

    object challenges{
        var onlyCave = false
    }
    fun save(){
        InternalMainClass.INSTANCE.config.set("settungs.alowNether", alowNether)
        InternalMainClass.INSTANCE.config.set("settungs.alowEnd", alowEnd)
        InternalMainClass.INSTANCE.config.set("settungs.viewDistanz", viewDistanz)
        InternalMainClass.INSTANCE.config.set("settungs.challenges.onlyCave", challenges.onlyCave)
    }
    fun load(){
        if (configuration.contains("settungs.alowNether")){alowNether = configuration.getBoolean("settungs.alowNether")}
        if (configuration.contains("settungs.alowEnd")){alowEnd = configuration.getBoolean("settungs.alowEnd")}
        if (configuration.contains("settungs.viewDistanz")){viewDistanz = configuration.getInt("settungs.viewDistanz")}
        if (configuration.contains("settungs.challenges.onlyCave")){challenges.onlyCave = configuration.getBoolean("settungs.challenges.onlyCave")}
    }
}