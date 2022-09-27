package com.example.application.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Project(
    val name: String,
    val full_name: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @Embedded(prefix = "owner_")
    var owner: Owner?,
) : Parcelable