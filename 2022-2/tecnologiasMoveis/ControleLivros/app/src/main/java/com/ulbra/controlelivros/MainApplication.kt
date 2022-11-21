package com.ulbra.controlelivros

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MainApplication : Application() {

    private var mRealmConfiguration: RealmConfiguration? = null

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        Realm.setDefaultConfiguration(getRealmConfiguration())
    }

    fun getRealmConfiguration(): RealmConfiguration {
        if (mRealmConfiguration == null) {
            mRealmConfiguration = RealmConfiguration.Builder()
                .name(getRealmName())
                .schemaVersion(getSchemaVersion())
                .deleteRealmIfMigrationNeeded()
                .build()
        }
        return mRealmConfiguration!!
    }

    fun getRealmName(): String {
        return Realm.DEFAULT_REALM_NAME
    }

    fun getSchemaVersion(): Long {
        return BuildConfig.VERSION_CODE.toLong()
    }
}