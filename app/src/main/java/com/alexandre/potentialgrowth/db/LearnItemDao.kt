package com.alexandre.potentialgrowth.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.alexandre.potentialgrowth.model.LearnItem
import com.alexandre.potentialgrowth.model.LearnItemWithContribution

/**
 * DAO to manage item to learn
 */
@Dao
interface LearnItemDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(learnItem: LearnItem)

    @Insert
    fun insertAll(learnItems: List<LearnItem>)

    @Query("UPDATE learn_item SET isFavorite = :isFavorite WHERE idLearnItem = :idLearnItem")
    fun updateFavorite(idLearnItem : Long, isFavorite : Boolean)

    @Query("SELECT idLearnItem, idType, orderLearnItem, name, description, imgUrl, isFavorite, (SELECT COUNT(idContribution) FROM contribution WHERE idType = 1 AND idLearnItem = learn_item.idLearnItem) as countDone, (SELECT COUNT(idContribution) FROM contribution WHERE idType = 2 AND idLearnItem = learn_item.idLearnItem) as countComment FROM learn_item ORDER BY orderLearnItem")
    fun getAllLearnItem(): LiveData<List<LearnItemWithContribution>>

    @Query("SELECT idLearnItem, idType, orderLearnItem, name, description, imgUrl, isFavorite, (SELECT COUNT(idContribution) FROM contribution WHERE idType = 1 AND idLearnItem = learn_item.idLearnItem) as countDone, (SELECT COUNT(idContribution) FROM contribution WHERE idType = 2 AND idLearnItem = learn_item.idLearnItem) as countComment FROM learn_item  WHERE isFavorite = 1 ORDER BY orderLearnItem")
    fun getFavAllLearnItem(): LiveData<List<LearnItemWithContribution>>

    @Query("SELECT idLearnItem, idType, orderLearnItem, name, description, imgUrl, isFavorite, (SELECT COUNT(idContribution) FROM contribution WHERE idType = 1 AND idLearnItem = learn_item.idLearnItem) as countDone, (SELECT COUNT(idContribution) FROM contribution WHERE idType = 2 AND idLearnItem = learn_item.idLearnItem) as countComment FROM learn_item WHERE idLearnItem = :id")
    fun getLearnItem(id : Long): LiveData<LearnItemWithContribution>
}