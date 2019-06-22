package com.evandro.t2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Main2Activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    //Funcao pesquisa objeto no banco de dados
    fun source(view: View)
    {
        val intent = Intent(this, Main3Activity::class.java)
        startActivity(intent)
    }

    //Funcao muda de tela para inserir informações do objeto no banco de dados
    fun insertInformation(view: View)
    {
        val intent = Intent(this, Main3Activity::class.java)
        startActivity(intent)
    }
}
