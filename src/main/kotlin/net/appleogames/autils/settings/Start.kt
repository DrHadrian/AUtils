package net.appleogames.autils.settings

import net.appleogames.autils.utils.viewDistanz
import net.appleogames.autils.challange.onlyCave

fun start(){
    if(settings.challenges.onlyCave){
        onlyCave()
    }
    viewDistanz()
}