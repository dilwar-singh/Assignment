package com.example.application.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Owner(
    val login: String,
    val avatar_url: String,
    val type: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
) : Parcelable
