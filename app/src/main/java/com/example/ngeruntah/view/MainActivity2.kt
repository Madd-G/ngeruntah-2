package com.example.ngeruntah.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.ngeruntah.R
import com.example.ngeruntah.databinding.ActivityMain2Binding
import com.example.ngeruntah.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
        binding.btnSignOut.setOnClickListener(this)

        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent =
                Intent(this@MainActivity2, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            updateUI(currentUser)
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this@MainActivity2, SignInActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            updateUI(currentUser)
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnSignOut -> {
                signOut()
            }
        }
    }

    private fun signOut() {
        auth.signOut()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            val intent = Intent(this@MainActivity2, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun updateUI(currentUser: FirebaseUser) {
        currentUser?.let {
            val name = currentUser.displayName
            val phoneNumber = currentUser.phoneNumber
            val email = currentUser.email
            val photoUrl = currentUser.photoUrl
            val emailVerified = currentUser.isEmailVerified
            val uid = currentUser.uid
            if (TextUtils.isEmpty(name)) {
            }
            binding.tvUserId.text = email
            for (profile in it.providerData) {
                val providerId = profile.providerId
                if (providerId == "password" && emailVerified == false) {
                }
                if (providerId == "phone") {
                    binding.tvUserId.text = providerId
                }
            }
        }
    }
}