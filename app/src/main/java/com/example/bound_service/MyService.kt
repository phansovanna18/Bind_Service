package com.example.bound_service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import java.util.*

class MyService : Service() {

    inner class MyBinder:Binder(){
        fun getInstance():MyService{
            return this@MyService
        }
    }

    var getBinder = MyBinder()

    override fun onBind(intent: Intent): IBinder {
        return getBinder
    }

    fun getTime():String{
        return Date().toString()
    }
}
