package com.derry.livedata.livedata.simple2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

// 模拟后台推送
class MyService : Service() {

    override fun onBind(intent: Intent): IBinder ? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        thread {
            for (x in 1..100000) {
                Log.d("server", "服务器给推你推送消息啦(叮咚声响),消息内容是:${x}")
                MyLiveData.data1.postValue("服务器给推你推送消息啦,消息内容是:${x}")
                Thread.sleep(2000) // 5秒钟推一次
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}