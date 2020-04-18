package com.example.ujikompwpb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class ProfileFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_fragment)

        val btn_back_home = findViewById<ImageButton>(R.id.btn_back_home)

        btn_back_home.setOnClickListener {
            intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        } }
}
