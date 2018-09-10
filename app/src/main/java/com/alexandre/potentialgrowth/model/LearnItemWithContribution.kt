package com.alexandre.potentialgrowth.model

import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LearnItemWithContribution(
        @PrimaryKey @field:SerializedName("id_learn_item") val idLearnItem: Long,
        @field:SerializedName("id_type") val idType: Int,
        @field:SerializedName("order_learn_item") val orderLearnItem: Int,
        @field:SerializedName("name") val name: String,
        @field:SerializedName("description") val description: String?,
        @field:SerializedName("img_url") val imgUrl: String,
        @field:SerializedName("is_favorite") val isFavorite: Boolean,
        @field:SerializedName("count_done") val countDone: Int? = 0,
        @field:SerializedName("count_comment")val countComment: Int? = 0) : Serializable {

}
