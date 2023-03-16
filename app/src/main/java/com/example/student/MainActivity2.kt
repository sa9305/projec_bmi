package com.example.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.student.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var bind2: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind2= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bind2.root)
        val intent = intent
        val fname = intent.getStringExtra("fname")
        val lname = intent.getStringExtra("lname")
        val ph_no = intent.getStringExtra("ph_no")
        val al_no = intent.getStringExtra("al_no")
        val e_mail = intent.getStringExtra("e_mail")
        val dob = intent.getStringExtra("dob")
        val gender = intent.getStringExtra("gender")


        bind2.fullName.setText("$fname $lname")
        bind2.urPhn.setText("+91$ph_no")
        bind2.urAlphn.setText("+91$al_no")
        bind2.urEmail.setText("$e_mail gmail.com")
        bind2.urDob.setText(dob)
        bind2.urGender.setText(gender)

        bind2.subBtn.setOnClickListener {

            Toast.makeText(this, "Your details are successfully submitted  ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

        }
    }

}

