package com.example.ca_contest.libs

import androidx.room.TypeConverter
import java.util.*

// Convert from and to a Java Date Object to a SQL Date
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}