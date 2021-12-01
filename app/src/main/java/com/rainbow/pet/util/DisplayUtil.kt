package com.rainbow.pet.util

import android.content.res.Configuration
import android.content.res.Resources


object DisplayUtil {


    fun getResource(resources: Resources?) : Resources? {

        val newConfiguration = Configuration()
        newConfiguration.setToDefaults()
        resources?.updateConfiguration(newConfiguration, resources.displayMetrics)
        return resources
    }

}