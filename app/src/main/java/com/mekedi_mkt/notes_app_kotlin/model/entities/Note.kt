package com.mekedi_mkt.notes_app_kotlin.model.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "notes")
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String
) : Parcelable
