package com.example.ujikompwpb

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ResponFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respon_fragment)

        val btn_back_home = findViewById<ImageButton>(R.id.btn_back_home)

        val btn_report_not_respon = findViewById<ImageButton>(R.id.btn_report_not_respon)
        val ic_btn_not_respon = findViewById<ImageView>(R.id.ic_btn_not_respon)

        val btn_report_process_respon = findViewById<ImageButton>(R.id.btn_report_process_respon)
        val ic_btn_process_respon = findViewById<ImageView>(R.id.ic_btn_process_respon)

        val btn_report_clear_respon = findViewById<ImageButton>(R.id.btn_report_clear_respon)
        val ic_btn_clear_respon = findViewById<ImageView>(R.id.ic_btn_clear_respon)

        btn_back_home.setOnClickListener {
            intent = Intent(this, HomeFragment::class.java)
            startActivity(intent)
        }

        btn_report_not_respon.setOnClickListener {
            intent = Intent(this, DetailNotRespon::class.java)
            startActivity(intent)
        }
        ic_btn_not_respon.setOnClickListener {
            intent = Intent(this, DetailNotRespon::class.java)
            startActivity(intent)
        }

        btn_report_process_respon.setOnClickListener {
            intent = Intent(this, DetailProcessRespon::class.java)
            startActivity(intent)
        }
        ic_btn_process_respon.setOnClickListener {
            intent = Intent(this, DetailProcessRespon::class.java)
            startActivity(intent)
        }

        btn_report_clear_respon.setOnClickListener {
            intent = Intent(this, DetailClearRespon::class.java)
            startActivity(intent)
        }
        ic_btn_clear_respon.setOnClickListener {
            intent = Intent(this, DetailClearRespon::class.java)
            startActivity(intent)
        }

    }
}
