package net.appleogames.autils.settings

import net.appleogames.autils.utils.viewDistanz
import net.spurkomet.adrian.utils.onlyCave

fun start(){
    if(settings.challenges.onlyCave){onlyCave()}
    viewDistanz()
}