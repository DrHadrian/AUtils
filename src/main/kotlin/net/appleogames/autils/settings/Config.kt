package net.appleogames.autils.settings

import net.appleogames.autils.settings.settings.configuration
import net.appleogames.autils.settings.settings.dir
import net.appleogames.autils.settings.settings.file
import java.io.IOException

fun Config(){
    if (!dir.exists()) {
        dir.mkdirs()
    }

    if (!file.exists()){
        try {
            file.createNewFile()
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

}
fun save(){
    try {
        configuration.save(file)
    }catch (e: IOException){
        e.printStackTrace()
    }
}