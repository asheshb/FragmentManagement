package com.example.fragmentmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentexample.OneFragment
import com.example.fragmentexample.TwoFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addFragment = findViewById<Button>(R.id.add_fragment)
        addFragment.setOnClickListener {
            val fragment = OneFragment()

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.main_container, fragment, "OneFragment")
            fragmentTransaction.commit()
        }

        val removeFragment = findViewById<Button>(R.id.remove_fragment)
        removeFragment.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.main_container)
            //val fragmentOne = supportFragmentManager.findFragmentByTag("OneFragment")

            fragment?.let{
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        }


        val replaceFragment = findViewById<Button>(R.id.replace_fragment)
        replaceFragment.setOnClickListener {
            val fragment = TwoFragment()

            with(supportFragmentManager.beginTransaction()){
                replace(R.id.main_container, fragment)
                addToBackStack(null)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                commit()
            }
        }
    }
}
