package com.example.ngeruntah.view
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ngeruntah.R

class ProfileForFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_for_fragment)

        val mFragmentManager = supportFragmentManager
        val mFirstFragment = ProfileFragment()
        val fragment =
            mFragmentManager.findFragmentByTag(ProfileFragment::class.java.simpleName)
        if (fragment !is ProfileFragment) {
            Log.d(
                "MyFlexibleFragment",
                "Fragment Name :" + ProfileFragment::class.java.simpleName
            )
            mFragmentManager.beginTransaction().add(
                R.id.frame_container,
                mFirstFragment,
                ProfileFragment::class.java.simpleName
            ).commit()
        }
    }
}