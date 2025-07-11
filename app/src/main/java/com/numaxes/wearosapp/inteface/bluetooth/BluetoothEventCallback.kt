package com.numaxes.wearosapp.inteface.bluetooth

import android.bluetooth.BluetoothDevice
import com.numaxes.wearosapp.model.Dog
import com.numaxes.wearosapp.model.DogTrajectory

interface BluetoothEventCallback {
    fun onScanning(bluetoothDevice: BluetoothDevice)
    fun onScanStarted()
    fun onScanFinished()
    fun onStartConnect(mac: String)
    fun onConnectSuccess(bleDevice: BluetoothDevice?)
    fun onConnectDeviceSuccess(bleDevice: BluetoothDevice?)
    fun onPasswordIncorrect()
    fun onConnectFail(bleDevice: BluetoothDevice?) {}
    fun onDisconnected(isActiveDisConnected: Boolean, device: BluetoothDevice?) {}

    fun onNotify(bytes: ByteArray) {}
    fun onNotifyFormat(dataList: String) {}

    fun onDogData(dogs: List<Dog>) {}
    fun onGpsData(dogTrajectory: DogTrajectory) {}
    fun onTrailDataStart() {}
    fun onTrailDataEnd() {}
    fun onScanFailed(errorCode: Int)

    fun onDogUpdate(){}
}

