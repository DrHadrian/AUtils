package net.appleogames.autils.settings

import net.appleogames.autils.challenge.onlyCave

fun start(){
    if(settings.challenges.onlyCave) onlyCave()
    //viewDistanz()
}