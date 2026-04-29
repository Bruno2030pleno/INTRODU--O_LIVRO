package com.example.myapplication

import android.content.Context
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.content.pm.PackageManager

class AudioHelper(private val context: Context) {

    private val audioManager: AudioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    // Função para verificar se um tipo específico de saída de áudio está disponível
    fun audioOutputAvailable(type: Int): Boolean {
        if (!context.packageManager.hasSystemFeature(PackageManager.FEATURE_AUDIO_OUTPUT)) {
            return false
        }

        // Obtém a lista de dispositivos de saída e verifica se o tipo solicitado está nela
        val devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS)
        return devices.any { it.type == type }
    }

    // Método auxiliar para facilitar o acesso ao AudioManager na MainActivity
    fun getManager(): AudioManager = audioManager
}
}