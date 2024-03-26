package com.derry.livedata.livedata.simple1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.derry.livedata.R
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView : TextView = findViewById(R.id.tv_textview)

        // 1 观察者 眼睛 环节
        MyLiveData.info1.observe(this, {
            textView.text = it // 更新UI
        })

        // 完整写法 new  Observer  onChanged
        MyLiveData.info1.observe(this, object: Observer<String> {
            override fun onChanged(t: String?) {
                textView.text = t // 更新UI
            }
        })

        // 完整写法 new  Observer  onChanged
        MyLiveData.info1.observe(this, object: Observer<String> {
            override fun onChanged(t: String?) {
                textView.text = t // 更新UI
            }
        })


        // 完整写法 new  Observer  onChanged
        MyLiveData.info1.observe(this, object: Observer<String> {
            override fun onChanged(t: String?) {
                textView.text = t // 更新UI
            }
        })


        // 完整写法 new  Observer  onChanged
        MyLiveData.info1.observe(this, object: Observer<String> {
            override fun onChanged(t: String?) {
                textView.text = t // 更新UI
            }
        })




        // 2 触发数据改变 环节
        MyLiveData.info1.value = "default" // setValue 主线程

        thread {
            Thread.sleep(3000)
            MyLiveData.info1.postValue("三秒钟后，修改了哦")  // postValue 子线程
        }

        thread { // 子线程
            Thread.sleep(6000)
            MyLiveData.info1.postValue("六秒钟后，修改了哦")  // postValue 子线程
        }
    }

}