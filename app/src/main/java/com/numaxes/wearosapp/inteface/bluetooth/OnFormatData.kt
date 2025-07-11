package com.numaxes.wearosapp.inteface.bluetooth

import com.numaxes.wearosapp.model.Dog
import com.numaxes.wearosapp.model.DogTrajectory

interface OnFormatData {
    fun onData(data: String)
    fun onDogData(dogs: List<Dog>)
    fun onGpsData(trajectory: DogTrajectory)
    fun onIncorrectPassword()
    fun onCorrectPassword()
    fun onTrailDataStart()
    fun onTrailDataEnd()
    fun onRename(dataList: ArrayList<String>)

    fun onUpdateDog()
}