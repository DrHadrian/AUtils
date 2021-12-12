package net.appleogames.autils

import net.appleogames.autils.settings.Config
import net.appleogames.autils.settings.settings
import net.appleogames.autils.settings.start
import net.appleogames.autils.utils.Commands
import net.appleogames.autils.utils.listener
import net.axay.kspigot.main.KSpigot

class InternalMainClass : KSpigot() {

    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }


    override fun load() {
        INSTANCE = this
        settings.load()
        var config = Config()
    }
    override fun startup() {
        listener()
        Commands()
        start()
    }

    override fun shutdown() {
        settings.save()
        saveConfig()
    }
}