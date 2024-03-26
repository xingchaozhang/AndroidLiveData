package com.derry.livedata.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.derry.livedata.R

// TODO 被观察者
// 源码分析
// 不在Activity里面写   是为了降低耦合吗  ?
// Google考虑的是，你继承AppCompatActivity 可以，你继承 XXXXActivity 也可以
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 观察者 == MyLocationListener
        // 1.主线流程，支线流程不管（防止淹死源码）
        // 2.支线流程
        lifecycle.addObserver(MyLocationListener())
    }

    override fun onResume() {
        super.onResume()

        // CREATE --->  START  ---> RESUME
        // lifecycle.addObserver(MyLocationListener())

        // onCreate  onStart  onResume
        lifecycle.addObserver(MyLocationListener())
    }

    override fun onStop() {
        super.onStop()
        // initial -> create 要执行onCreate
        /*
        addObsever()的时候是初始状态
          后面只执行了onDestroyed()
          所以是onCreate和onDestroyed
        */
        // onCreate  onStop
        lifecycle.addObserver(MyLocationListener())
    }
}