package com.example.ngeruntah.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ngeruntah.R
import kotlinx.android.synthetic.main.activity_login_signup_page.*

class LoginSignupPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup_page)

        signin_signup_btn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signin.setOnClickListener {
            signin.setTextColor(Color.parseColor("#FFFFFF"))
            signin.setBackgroundColor(Color.parseColor("#B75F43"))
            signup.setTextColor(Color.parseColor("#B75F43"))
            signup.setBackgroundResource(R.drawable.bordershape)
            circleImageView.setImageResource(R.drawable.signin_boy_img)
            signin_signup_txt.text = "Sign In"
            signin_signup_btn.text = "Sign In"
            forgot_password.visibility = View.VISIBLE
        }
        signup.setOnClickListener {
            signup.setTextColor(Color.parseColor("#FFFFFF"))
            signup.setBackgroundColor(Color.parseColor("#B75F43"))
            signin.setTextColor(Color.parseColor("#B75F43"))
            signin.setBackgroundResource(R.drawable.bordershape)
            circleImageView.setImageResource(R.drawable.signup_boy_img)
            signin_signup_txt.text = "Sign Up"
            signin_signup_btn.text = "Sign Up"
            forgot_password.visibility = View.INVISIBLE
        }

        forgot_password.setOnClickListener {
            signup.setTextColor(Color.parseColor("#FFFFFF"))
            signup.setBackgroundColor(Color.parseColor("#FF2729C3"))
            signin.setTextColor(Color.parseColor("#FF2729C3"))
            signin.setBackgroundResource(R.drawable.bordershape)
            circleImageView.setImageResource(R.drawable.signup_boy_img)
            signin_signup_txt.text = "Sign Up"
            signin_signup_btn.text = "Sign Up"
            forgot_password.visibility = View.INVISIBLE
        }
    }
}