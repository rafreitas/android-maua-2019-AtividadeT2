package com.evandro.t2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    val user = "admin"
    val pass = "admin"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeScreen(view: View)
    {
        if((editTextUser.text.toString() == user) && (editTextPass.text.toString() == pass))
        {
            Toast.makeText(applicationContext, "Logado com sucesso!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(applicationContext, "Usuário ou senha incorretos, tente novamente!", Toast.LENGTH_SHORT).show()
        }
    }
}
