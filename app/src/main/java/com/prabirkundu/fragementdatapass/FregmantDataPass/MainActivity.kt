package com.prabirkundu.fragementdatapass.FregmantDataPass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.prabirkundu.fragementdatapass.FregmantDataPass.Fragemnt.FirstFragment
import com.prabirkundu.fragementdatapass.FregmantDataPass.Fragemnt.SecondFragment
import com.prabirkundu.fragementdatapass.R

class MainActivity : AppCompatActivity(), FirstFragment.OnDataPass{
    private val TAG = "MainActivity"
    private lateinit var passingData:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoadFirstFragemnt()
        //LoadSecondFragment()
    }

    fun LoadFirstFragemnt(){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val pFragment = FirstFragment()
        transaction.replace(R.id.fragmentContainer1, pFragment, "Applied")
        transaction.commit()
    }

    fun LoadSecondFragment(){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val args = Bundle()
        args.putString("title", passingData)
        val pFragment = SecondFragment.newInstance(args)
        transaction.replace(R.id.fragmentContainer2, pFragment)
        transaction.commit()
    }

    override fun onDataPass(data: String) {
        Log.e(TAG, "onDataPass: "+data)
        passingData = data
        LoadSecondFragment()
    }
}