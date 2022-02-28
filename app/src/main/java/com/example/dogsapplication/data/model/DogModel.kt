package com.example.dogsapplication.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class DogModel(
    @field:SerializedName("DogModel")
    val dogModel: List<DogModelItem>? = null
)

@Entity(tableName = "dog_table")
data class DogModelItem(

    @field:SerializedName("image")
	@ColumnInfo(name = "image")
    val image: String? = null,

    @field:SerializedName("description")
	@ColumnInfo(name ="description")
    val description: String? = null,

    @field:SerializedName("dogName")
	@ColumnInfo(name = "dog_name")
    val dogName: String? = null,

    @field:SerializedName("age")
	@ColumnInfo(name = "age")
    val age: Int? = null
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_dog")
    var idDog: Int = 0
}
