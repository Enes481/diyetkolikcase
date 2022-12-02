package com.enestigli.diyetkolikcase.data.locale.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ExchangeValues")
data class ExchangeEntity(

    @ColumnInfo(name = "base_code") val base_code: String,
    @ColumnInfo(name = "conversion_rates") val conversion_rates: HashMap<String,Double>,
    @ColumnInfo(name = "result") val result: String,
    @PrimaryKey(autoGenerate = true) val uid:Int?=null

)
