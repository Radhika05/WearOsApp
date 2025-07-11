package com.numaxes.wearosapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.numaxes.wearosapp.databasedao.DeviceDao
import com.numaxes.wearosapp.databasedao.DogDao
import com.numaxes.wearosapp.databasedao.DogTrajectoryDao
import com.numaxes.wearosapp.databasedao.FenceDao
import com.numaxes.wearosapp.databasedao.MarkerDao
import com.numaxes.wearosapp.databasedao.PositionDao
import com.numaxes.wearosapp.model.Device
import com.numaxes.wearosapp.model.Dog
import com.numaxes.wearosapp.model.DogTrajectory
import com.numaxes.wearosapp.model.Fence
import com.numaxes.wearosapp.model.MarkerPosition
import com.numaxes.wearosapp.model.Position

@Database(entities = [Dog::class, Device::class, DogTrajectory::class, Position::class, Fence::class, MarkerPosition::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class SaveDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao?
    abstract fun deviceDao() : DeviceDao?
    abstract fun dogTrajectoryDao() : DogTrajectoryDao?
    abstract fun positionDao() : PositionDao?
    abstract fun fenceDao() : FenceDao?
    abstract fun markerDao() : MarkerDao?

    companion object {
        @Volatile
        private var INSTANCE: SaveDatabase? = null
        fun getInstance(context: Context): SaveDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    SaveDatabase::class.java, "MyDatabase")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
