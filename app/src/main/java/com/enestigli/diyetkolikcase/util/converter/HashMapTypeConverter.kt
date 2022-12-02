package com.enestigli.diyetkolikcase.util.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class HashMapTypeConverter {

    @TypeConverter
    fun mapToString(conversionRates: HashMap<String,Double>) : String{
        val gson = Gson()
        return gson.toJson(conversionRates)
    }

    @TypeConverter
    fun covertStringToMap(json: String): HashMap<String,Double> {
        val gson = Gson()
        val typeToken = object : TypeToken<HashMap<String,Double>>() {}.type
        return Gson().fromJson(json, typeToken)
    }
}