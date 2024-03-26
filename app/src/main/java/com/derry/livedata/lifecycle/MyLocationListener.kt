package com.derry.livedata.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

// 地图定位功能的模拟  眼睛 Observer 观察者
class MyLocationListener : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() = Log.d("Derry", "create 正在启动系统定位服务中...")

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() = Log.d("Derry", "start 连接系统定位服务...")

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume() = Log.d("Derry", "resume 系统定位的界面展示...")

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun pause() = Log.d("Derry", "pause 系统定位的界面关闭...")

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() = Log.d("Derry", "stop 断开系统定位服务...")

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() = Log.d("Derry", "destroy 正在停止系统定位服务...")
}