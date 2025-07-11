package com.numaxes.wearosapp.repository

import com.numaxes.wearosapp.databasedao.DogTrajectoryDao
import com.numaxes.wearosapp.model.DogTrajectory
import kotlinx.coroutines.flow.Flow

class TrajectoryRepository (private var dogTrajectoryDao: DogTrajectoryDao?)  {
    private val allDogsTrajectory = dogTrajectoryDao?.allDogsTrajectory
    suspend fun createTrajectory(dogTrajectory: DogTrajectory?) {
        dogTrajectoryDao?.insertTrajectory(dogTrajectory)
    }

    fun getTrajectory(): Flow<List<DogTrajectory>>? {
        return allDogsTrajectory
    }

    fun deleteAllTrajectory() {
        dogTrajectoryDao?.deleteAllTrajectory()
    }
}