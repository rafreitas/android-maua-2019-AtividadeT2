package com.evandro.t2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    lateinit var usersDBHelper : usersDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        usersDBHelper = usersDBHelper(this)
        var plastic = usersDBHelper.readAllPlastics()
        this.ll_entries.removeAllViews()
        plastic.forEach {
            var tv_user = TextView(this)
            tv_user.textSize = 30F
            tv_user.text = it.name.toString() + " - " + it.color.toString() + " - " + it.plasticType.toString()
            this.ll_entries.addView(tv_user)
        }
    }
}