package com.aligmohammad.doctorapp.ui.base

import android.content.Context
import android.content.ContextWrapper
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.aligmohammad.doctorapp.util.ContextUtil.Companion.updateLocale
import com.google.android.material.internal.ContextUtils

class BaseActivity {

}

//open class BaseActivity: AppCompatActivity() {
//
//    override fun attachBaseContext(newBase: Context) {
//// get chosen language from shread preference
//        val localeToSwitchTo = PreferenceManager(newBase).getAppLanguage()
//        val localeUpdatedContext: ContextWrapper = ContextUtils.updateLocale(newBase, localeToSwitchTo)
//        super.attachBaseContext(localeUpdatedContext)
//    }
//
//}