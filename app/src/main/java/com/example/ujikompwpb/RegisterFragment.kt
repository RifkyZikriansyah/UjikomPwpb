package com.example.ujikompwpb

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register_fragment.*

class RegisterFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_fragment)

        val txt_login = findViewById<TextView>(R.id.txt_login)
        val regis = findViewById<Button>(R.id.regis)

        regis.setOnClickListener {
            val inputNik = txt_nik.text.toString()
            val inputName = txt_name.text.toString()
            val inputPhone = txt_phone.text.toString()
            val inputUsername = txt_username.text.toString()
            val inputPassword = txt_pass.text.toString()
            val inputConfirmPass = txt_confirm_pass.text.toString()

            if (inputUsername.isEmpty()||inputPassword.isEmpty()){
                Toast.makeText(this, "Please Enter Your Data Correctly", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            Log.d("RegisterFragment", "Username : " + inputUsername)
            Log.d("RegisterFragment", "Password :  $inputPassword")

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(inputUsername, inputPassword)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Toast.makeText(this, "Register Successfully", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginFragment::class.java)
                    startActivity(intent)
                    //else if successful
                    Log.d(
                        "Register",
                        "Successfully created user with uid: ${it.result?.user?.uid}")

                }
                .addOnFailureListener{
                    Log.d("Register", "Failed to create user: ${it.message}")
                }

        }

            txt_login.setOnClickListener {
                intent = Intent(this, LoginFragment::class.java)
                startActivity(intent)
        }
    }
}
