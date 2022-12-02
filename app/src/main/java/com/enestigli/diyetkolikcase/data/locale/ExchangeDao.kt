package com.enestigli.diyetkolikcase.data.locale

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.enestigli.diyetkolikcase.data.locale.entity.ExchangeEntity

@Dao
interface ExchangeDao {


    @Query("SELECT * FROM ExchangeValues")
    suspend fun getAll() : ExchangeEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun initData(exchanges : ExchangeEntity )


    @Query("UPDATE ExchangeValues SET  base_code=:base_code,conversion_rates=:conversion_rates , result=:result")
    suspend fun update(base_code:String,conversion_rates:HashMap<String,Double>,result:String)

}