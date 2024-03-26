package com.derry.livedata.livedata.simple3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.derry.livedata.R

// this@MainActivity4 每个类都有符号
class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        // 我后观察数据，居然能够收到 前面修改的数据，这就是 数据黏性
        /*MyLiveData.value1.observe(this, {
            Toast.makeText(this, "观察者数据变化:$it", Toast.LENGTH_SHORT).show()
        })*/

        // 第二步
        MyLiveData.value1.observe(this, object: Observer<String>{
            override fun onChanged(t: String?) {
                Toast.makeText(this@MainActivity4, "观察者数据变化$t", Toast.LENGTH_SHORT).show()
            }
        })

        /*// 此观察者 和 handler没有区别，一股脑的执行 （极端的情况，可以用）
        // 手动考虑释放工作
        MyLiveData.value1.observeForever({

        })

        //  // 关心的新数据
        MyLiveData.value1.postValue("1111")

        //  // 关心的新数据
        MyLiveData.value1.postValue("1111")


        //  // 关心的新数据
        MyLiveData.value1.postValue("1111")

        //  // 关心的新数据
        MyLiveData.value1.postValue("1111")


        // 先订阅
        ok(object : Callback {
            override fun show() {
            }
        })*/
    }

    fun ok(callback: Callback) {
        // 后触发
        callback.show()
    }

    override fun onStart() {
        super.onStart()
    }


    override fun onDestroy() {
        super.onDestroy()
        // 手动释放
        // MyLiveData.value1.removeObserver()
    }
}