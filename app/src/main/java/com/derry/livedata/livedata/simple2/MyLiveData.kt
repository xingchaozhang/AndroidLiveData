package com.derry.livedata.livedata.simple2

import androidx.lifecycle.MutableLiveData

object MyLiveData { // 单例

    // 这里为info1的MutableLiveData 懒加载初始化（懒加载：用到时才加载）
    val data1 : MutableLiveData<String> by lazy { MutableLiveData() }

    init {
        // data1.value = "default" // 违背在 子线程 setValue
        data1.postValue("DDD") // 子线程 执行 postValue 非常OK
    }
}