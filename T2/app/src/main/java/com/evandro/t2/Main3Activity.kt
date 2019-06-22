package com.evandro.t2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity()
{
    lateinit var usersDBHelper : UsersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        usersDBHelper = UsersDBHelper(this)
    }
        //Configura o evento de click no botão
        fun addPlastic(v: View){
            if (editTextName.text.isEmpty())
            {
                editTextName.error = "Favor preencher esse dado"
            }
            else if (editTextColor.text.isEmpty())
            {
                editTextColor.error = "Favor preencher esse dado"
            }
            else if (editTextPlasticType.text.isEmpty())
            {
                editTextPlasticType.error = "Favor preencher esse dado"
            }
            else
            {
                var id = this.editTextID.text.toString()
                var name = this.editTextName.text.toString()
                var color = this.editTextColor.text.toString()
                var plasticType = this.editTextPlasticType.text.toString()
                var result = usersDBHelper.insertUser(UserModel(id = id,name = name,color = color, plasticType = plasticType))
                editTextID.text.clear()
                editTextName.text.clear()
                editTextColor.text.clear()
                editTextPlasticType.text.clear()
                Toast.makeText(applicationContext, "Objeto Adicionado", Toast.LENGTH_SHORT)
                        .show()
                true
            }
        }

        fun deletePlastic(v:View){
            var userid = this.editTextID.text.toString()
            val result = usersDBHelper.deleteUser(userid)
            this.textViewResult.text = "Deleted user : "+result
            this.ll_entries.removeAllViews()
        }

        fun showAllPlastics(v:View){
            var users = usersDBHelper.readAllUsers()
            this.ll_entries.removeAllViews()
            users.forEach {
                var tv_user = TextView(this)
                tv_user.textSize = 30F
                tv_user.text = it.name.toString() + " - " + it.color.toString() + " - " + it.plasticType.toString()
                this.ll_entries.addView(tv_user)
            }
            this.textViewResult.text = "Fetched " + users.size + " users"
        }
}

