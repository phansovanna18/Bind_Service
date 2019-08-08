package com.example.bound_service

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var i = Intent(this, MyService::class.java)
        bindService(i,sc,Context.BIND_AUTO_CREATE)
    }

    lateinit var myService:MyService
    var isBound:Boolean = false

    var sc: ServiceConnection = object :ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound = false
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            var myBinder:MyService.MyBinder = p1 as MyService.MyBinder
            myService = myBinder.getInstance()
            isBound = true
        }
    }

    fun click(v: View){
        txt.text = myService.getTime()
    }
}
