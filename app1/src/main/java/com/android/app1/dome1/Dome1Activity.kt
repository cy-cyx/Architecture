package com.android.app1.dome1

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.alibaba.android.arouter.facade.annotation.Route
import com.android.app1.ActivityPathList
import com.android.app1.R
import com.android.app1.dome1.fragment.Fragment1
import com.android.app1.dome1.fragment.Fragment2
import com.android.basemvvm.base.mvvm.BaseMVVMActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_dome1.*

/**
 * create by caiyx in 2021/8/26
 */
@Route(path = ActivityPathList.sFragmentActivity)
class Dome1Activity : BaseMVVMActivity<Dome1ViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_dome1
    }

    override fun initView(savedInstanceState: Bundle?) {
        initFragment(savedInstanceState)
        selectCurFragment(tab1)
    }

    private var messageFragment: Fragment? = null
    private var meFragment: Fragment? = null


    private val tab1 = "message"
    private val tab2 = "me"

    private fun initFragment(savedInstanceState: Bundle?) {
        // 可能之前存在缓存
        savedInstanceState?.let {
            supportFragmentManager.findFragmentByTag(tab1)
                ?.let { fragment ->
                    messageFragment = fragment as Fragment1
                }
            supportFragmentManager.findFragmentByTag(tab2)
                ?.let { fragment ->
                    meFragment = fragment as Fragment2
                }
        }

        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (messageFragment == null) {
            messageFragment = Fragment1()
            transaction.add(R.id.fl_fragment_container, messageFragment!!, tab1)
        }
        if (meFragment == null) {
            meFragment = Fragment2()
            transaction.add(R.id.fl_fragment_container, meFragment!!, tab2)
        }
        transaction.commit()

        tl_tab.apply {
            addTab(newTab().apply {
                setIcon(R.mipmap.message)
                tag = tab1
            })
            addTab(newTab().apply {
                setIcon(R.mipmap.me)
                tag = tab2
            })
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.tag?.let { selectCurFragment(it as String) }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }
            })
        }
    }

    private fun selectCurFragment(frag: String) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        messageFragment?.let { transaction.hide(it) }
        meFragment?.let { transaction.hide(it) }
        when (frag) {
            tab1 -> {
                messageFragment?.let { transaction.show(it) }
            }
            tab2 -> {
                meFragment?.let { transaction.show(it) }
            }
        }
        transaction.commit()
    }
}