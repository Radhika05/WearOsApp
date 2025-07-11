package com.numaxes.wearosapp.repository

import com.numaxes.wearosapp.databasedao.FenceDao
import com.numaxes.wearosapp.model.Fence
import com.numaxes.wearosapp.model.FenceToPosition
import kotlinx.coroutines.flow.Flow

class FenceRepository (private var fenceDao: FenceDao?) {

    suspend fun createFence(fence: Fence?) {
        fenceDao?.insertFence(fence)
    }

    fun getFence(): Flow<List<Fence>>? {
        return fenceDao?.getFence()
    }

    fun getFenceToPosition() : Flow<List<FenceToPosition>>? {
        return fenceDao?.getFenceToPosition()
    }

    suspend fun updateFence(fence: Fence?) {
        fenceDao?.updateFence(fence)
    }

    fun deleteFence(fenceIdeId: Long?) {
        fenceDao?.deleteFence(fenceIdeId)
    }

    fun deleteAllFence() {
        fenceDao?.deleteAllFence()
    }
}