package com.prabirkundu.fragementdatapass

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.prabirkundu.fragementdatapass.Fragemnt.FirstFragment
import com.prabirkundu.fragementdatapass.Fragemnt.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.OnDataPass{
    private val TAG = "MainActivity"
    private lateinit var passingData:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

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