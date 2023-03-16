package com.example.student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.student.databinding.ActivityMainBinding
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnId.setOnClickListener {


            if (bind.fnameId.editText!!.text.toString().isNotEmpty())
            {
                if (bind.lnameId.editText!!.text.toString().isNotEmpty())
                {
                    if (bind.pnNo.editText!!.text.toString().isNotEmpty())
                    {
                        if (bind.AlPhn.editText!!.text.toString().isNotEmpty())
                        {
                            if (bind.eMail.editText!!.text.toString().isNotEmpty())
                            {
                                if (bind.dob.editText!!.text.toString().isNotEmpty())
                                {
                                    val intent = Intent(this, MainActivity2::class.java)

                                    intent.putExtra("fname",bind.fnameId.editText!!.text.toString())
                                    intent.putExtra("lname",bind.lnameId.editText!!.text.toString())
                                    intent.putExtra("ph_no",bind.pnNo.editText!!.text.toString())
                                    intent.putExtra("al_no",bind.AlPhn.editText!!.text.toString())
                                    intent.putExtra("e_mail",bind.eMail.editText!!.text.toString())
                                    intent.putExtra("dob",bind.dob.editText!!.text.toString())
                                    intent.putExtra("gender",gb)

                                    startActivity(intent)

                                } else {
                                    Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT)
                                        .show()
                                    bind.dob.requestFocus()
                                }
                            } else {
                                Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT)
                                    .show()
                                bind.eMail.requestFocus()
                            }
                        } else {
                            Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show()
                            bind.AlPhn.requestFocus()
                        }
                    } else {
                        Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show()
                        bind.pnNo.requestFocus()
                    }
                }
                else {
                    Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show()
                    bind.lnameId.requestFocus()
                }
            }
            else {
                Toast.makeText(this, "Field cant be empty", Toast.LENGTH_SHORT).show()
                bind.fnameId.requestFocus()
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu):Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(menu: MenuItem): Boolean {
        return when(menu.itemId)
        {
            R.id.item_1 ->{
                Toast.makeText(this,"About app",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.item_2 ->{
                Toast.makeText(this,"How to fill",Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.item_3 ->{
                Toast.makeText(this,"Contacts us",Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.item_4 ->{
                exitProcess(0)
            }
            else -> {super.onOptionsItemSelected(menu) }
        }
    }
    lateinit var gb:String
    fun onRadioButtonClicked(view: View)
    {
        if (view is RadioButton)
        {
            val checked = view.isChecked

            when (view.getId())
            {
                R.id.male ->
                    if (checked) {
                        gb= "Male"
                    }
                R.id.female ->
                    if (checked) {
                        gb= "Female"
                    }
                R.id.trns ->
                    if (checked) {
                        gb= "Transgender"
                    }
            }
        }
    }

}


