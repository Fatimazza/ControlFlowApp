package id.co.iconpln.controlflowapp

import androidx.lifecycle.ViewModel

class VolumeViewModel : ViewModel() {

    var volumeResult: Int = 0

    fun calculate(length: String, width: String, height: String) {
        volumeResult = Integer.parseInt(length) * Integer.parseInt(width) * Integer.parseInt(height)
    }
}
