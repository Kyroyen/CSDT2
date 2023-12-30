package com.example.pro2.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0L,
    @ColumnInfo(name = "name")
    var name : String = "Name",
    @ColumnInfo(name = "content")
    var content : String = "Content",
    @ColumnInfo(name = "time")
    val time : String = "2020:1:1",
    @ColumnInfo(name = "done")
    val done : Boolean = false,
)
