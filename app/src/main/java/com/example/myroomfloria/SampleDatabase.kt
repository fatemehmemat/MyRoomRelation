package com.example.myroomfloria

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myroomfloria.advance.Dog4
import com.example.myroomfloria.advance.Dog4AndPupsDao
import com.example.myroomfloria.advance.Owner4
import com.example.myroomfloria.manyToMany.Dog3
import com.example.myroomfloria.manyToMany.Dog3AndOwner3Dao
import com.example.myroomfloria.manyToMany.DogOwnerCrossRef
import com.example.myroomfloria.manyToMany.Owner3
import com.example.myroomfloria.oneToMany.Dog2
import com.example.myroomfloria.oneToMany.Dog2AndOwner2Dao
import com.example.myroomfloria.oneToMany.Owner2
import com.example.myroomfloria.oneToOneRelations.Dog1
import com.example.myroomfloria.oneToOneRelations.Dog1AndOwner1Dao
import com.example.myroomfloria.oneToOneRelations.Owner1

@Database(
    entities = [
        Owner1::class,
        Dog1::class,
        Owner2::class,
        Dog2::class,
        Owner3::class,
        Dog3::class,
        DogOwnerCrossRef::class,
        Owner4::class,
        Dog4::class

    ],
    version = 1
)
abstract class SampleDatabase : RoomDatabase() {

    abstract val dogAndOwnerDao: Dog1AndOwner1Dao
    abstract val dog2AndOwner2Dao: Dog2AndOwner2Dao
    abstract val dog3AndOwner3Dao: Dog3AndOwner3Dao
    abstract val dog4AndPupsDao: Dog4AndPupsDao

    companion object {
        @Volatile
        private var INSTANCE: SampleDatabase? = null

        fun getInstance(context: Context): SampleDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SampleDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
