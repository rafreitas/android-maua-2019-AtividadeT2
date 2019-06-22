package com.evandro.t2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    lateinit var usersDBHelper : usersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        usersDBHelper = usersDBHelper(this)
    }
        //Configura o evento de click no botão
        fun addPlastic(v: View){
            var id = this.editTextID.text.toString()
            var name = this.editTextName.text.toString()
            var color = this.editTextColor.text.toString()
            var plasticType = this.editTextPlasticType.text.toString()
            var result = usersDBHelper.insertPlastic(UserModel(id = id,name = name,color = color, plasticType = plasticType))
            editTextID.text.clear()
            editTextName.text.clear()
            editTextColor.text.clear()
            editTextPlasticType.text.clear()
            this.textViewResult.text = "Added user : "+result
            this.ll_entries.removeAllViews()
        }

        fun delete(v:View){
            var id = this.editTextID.text.toString()
            val result = usersDBHelper.deletePlastic(id)
            this.textViewResult.text = "Deleted user : "+result
            this.ll_entries.removeAllViews()
        }

        fun showAllPlastics(v:View){
            var plastic = usersDBHelper.readAllPlastics()
            this.ll_entries.removeAllViews()
            plastic.forEach {
                var tv_user = TextView(this)
                tv_user.textSize = 30F
                tv_user.text = it.name.toString() + " - " + it.color.toString() + " - " + it.plasticType.toString()
                this.ll_entries.addView(tv_user)
            }
            this.textViewResult.text = "Fetched " + plastic.size + " users"
        }
}

