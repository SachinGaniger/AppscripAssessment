package com.sachin.appscripassessment.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "summary_table")
data class Summary(
    var name: String ? = null,
    var singleChoice: String ? = null,
    var multipleChoice: String ? = null,
    var date: String ? = null
){
    @PrimaryKey(autoGenerate = true)
    var id: Int?= null
}
