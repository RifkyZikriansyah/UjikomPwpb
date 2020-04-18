package com.example.ujikompwpb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView

class DetailClearRespon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_clear_respon)
        val btn_back_respon = findViewById<ImageButton>(R.id.btn_back_respon)

        val btn_report_not = findViewById<ImageButton>(R.id.btn_report_not)
        val ic_btn_not = findViewById<ImageView>(R.id.ic_btn_not)

        val btn_report_process = findViewById<ImageButton>(R.id.btn_report_process)
        val ic_btn_process = findViewById<ImageView>(R.id.ic_report_process)

        val btn_report_clear = findViewById<ImageButton>(R.id.btn_report_clear)
        val ic_btn_clear = findViewById<ImageView>(R.id.ic_report_clear)


        btn_back_respon.setOnClickListener {
            intent = Intent(this, ResponFragment::class.java)
            startActivity(intent)
        }

        btn_report_not.setOnClickListener {
            intent = Intent(this, DetailNotRespon::class.java)
            startActivity(intent)
        }

        btn_report_process.setOnClickListener {
            intent = Intent(this, DetailProcessRespon::class.java)
            startActivity(intent)
        }

        btn_report_clear.setOnClickListener {
            intent = Intent(this, DetailClearRespon::class.java)
            startActivity(intent)
        }

    }

}
