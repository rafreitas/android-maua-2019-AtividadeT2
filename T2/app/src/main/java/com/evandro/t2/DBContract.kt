package com.evandro.t2

import android.provider.BaseColumns

object DBContract {

    /* Inner class that defines the table contents */
    class UserEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "users"
            val COLUMN_ID = "id"
            val COLUMN_NAME = "name"
            val COLUMN_COLOR = "color"
            val COLUMN_PLASTIC_TYPE = "plasticType"
        }
    }
}