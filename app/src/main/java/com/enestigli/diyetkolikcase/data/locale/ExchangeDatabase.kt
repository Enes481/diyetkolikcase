package com.enestigli.diyetkolikcase.data.locale

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.enestigli.diyetkolikcase.data.locale.entity.ExchangeEntity
import com.enestigli.diyetkolikcase.util.converter.HashMapTypeConverter

@Database(
    entities = [ExchangeEntity::class],
    version = 1
)
@TypeConverters(HashMapTypeConverter::class)
abstract class ExchangeDatabase : RoomDatabase() {
    abstract val exchangeDao:ExchangeDao
}
