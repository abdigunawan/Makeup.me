package com.abdigunawan.makeupme.ui.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.abdigunawan.makeupme.R
import com.abdigunawan.makeupme.model.OnBoardingData
import com.abdigunawan.makeupme.ui.auth.AuthActivity
import com.google.android.material.tabs.TabLayout

class OnBoardingActivity : AppCompatActivity() {

    var onBoardingAdapter: OnBoardingAdapter? = null
    var tabLayout: TabLayout? = null
    var onBoardingViewPager: ViewPager? = null
    var next: TextView? = null
    var position = 0
    var skip: TextView? = null
    var sharedPreferences : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(restorePrefData()){
            val i = Intent(applicationContext, AuthActivity::class.java)
            startActivity(i)
            finish()
        }

        setContentView(R.layout.activity_on_boarding)

        tabLayout = findViewById(R.id.tabIndicator)
        next = findViewById(R.id.tvOnBoardingNext)
        skip = findViewById(R.id.tvOnBoardingSkip)


        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
        onBoardingData.add(OnBoardingData("Selamat Datang","Mulai menjelajah dan mencari makeup artist yang cocok denganmu",R.drawable.ic_hello))
        onBoardingData.add(OnBoardingData("Cari Makeup Artist","sering kesulitan dalam mencari mua yang cocok denganmu ? kami solusinya",R.drawable.ic_online_wishes_list_bro_1))
        onBoardingData.add(OnBoardingData("Pesan Makeup Artist","Pesan Makeup Artist dengan mudah yang sesuai dengan pilihanmu",R.drawable.ic_payment_information_cuate_1))

        setOnBoardingAdapter(onBoardingData)
        var position = onBoardingViewPager!!.currentItem

        next?.setOnClickListener{
            if (position < onBoardingData.size){
               position++
               onBoardingViewPager!!.currentItem = position
            }
            if (position == onBoardingData.size){
                savePrefData()
                val i = Intent(applicationContext, AuthActivity::class.java)
                startActivity(i)
                finish()
            }
        }

        skip?.setOnClickListener(){
            position = onBoardingData.size
            savePrefData()
            val i = Intent(applicationContext, AuthActivity::class.java)
            startActivity(i)
            finish()
        }

        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                position = tab!!.position
                if (tab.position == onBoardingData.size - 1) {
                    next!!.text = "Mulai"
                }else {
                    next!!.text = "Next"
                }
            }

        })

    }

    private fun setOnBoardingAdapter(onBoardingData: List<OnBoardingData>){
        onBoardingViewPager = findViewById(R.id.screenPager)
        onBoardingAdapter = OnBoardingAdapter(this, onBoardingData)
        onBoardingViewPager!!.adapter = onBoardingAdapter
        tabLayout?.setupWithViewPager(onBoardingViewPager)
    }

    private fun savePrefData(){
        sharedPreferences = applicationContext.getSharedPreferences("pref",Context.MODE_PRIVATE)
        val editor = sharedPreferences!!.edit()
        editor.putBoolean("isFirstTimeRun", true)
        editor.apply()
    }
    private fun restorePrefData(): Boolean{
        sharedPreferences = applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
        return sharedPreferences!!.getBoolean("isFirstTimeRun",false)
    }
}