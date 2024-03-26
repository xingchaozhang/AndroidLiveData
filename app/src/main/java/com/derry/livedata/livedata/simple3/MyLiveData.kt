package com.derry.livedata.livedata.simple3

import androidx.lifecycle.MutableLiveData

object MyLiveData {

    // 这里为info1的MutableLiveData 懒加载初始化（懒加载：用到时才加载）
    val value1 : MutableLiveData<String> by lazy { MutableLiveData() }

}