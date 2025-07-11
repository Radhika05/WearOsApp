package com.numaxes.wearosapp.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.numaxes.wearosapp.repository.DeviceRepository
import com.numaxes.wearosapp.repository.DogRepository
import com.numaxes.wearosapp.repository.FenceRepository
import com.numaxes.wearosapp.repository.MarkerRepository
import com.numaxes.wearosapp.repository.PositionRepository
import com.numaxes.wearosapp.repository.TrajectoryRepository
import com.numaxes.wearosapp.viewmodel.DogViewModel
import java.util.concurrent.Executor

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private var dogRepository: DogRepository,
                       private var deviceRepository: DeviceRepository,
                       private var trajectoryRepository: TrajectoryRepository,
                       private var positionRepository: PositionRepository,
                       private var fenceRepository: FenceRepository,
                       private var markerRepository: MarkerRepository,
                       private var executor: Executor?,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            return DogViewModel(
                dogRepository,
                deviceRepository,
                trajectoryRepository,
                positionRepository,
                fenceRepository,
                markerRepository,
                executor
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}