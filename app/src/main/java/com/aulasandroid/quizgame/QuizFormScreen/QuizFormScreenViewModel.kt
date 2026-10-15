package com.aulasandroid.quizgame.QuizFormScreen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class QuizFormScreenViewModel: ViewModel() {
    private val _contadorPerguntas = MutableLiveData<Int>(1)
    val contadorPerguntas: LiveData<Int> = _contadorPerguntas

    private val _contadorAcertos = MutableLiveData<Int>(0)
    val contadorAcertos: LiveData<Int> = _contadorAcertos

    private val _buttonColor = MutableLiveData<Color>(Color.Transparent)
    val buttonColor: LiveData<Color> = _buttonColor

    fun onButtonColorChange (novaCor: Color){
        _buttonColor.value = novaCor
    }

    private val _alternativaSelecionada = MutableLiveData<String?>(null)
    val alternativaSelecionada: LiveData<String?> = _alternativaSelecionada

    private val _respostaCorreta = MutableLiveData<Boolean?>(null)
    val respostaCorreta: LiveData<Boolean?> = _respostaCorreta

    fun verificarResposta(
        alternativaEscolhida: String,
        alternativaCerta: String
    ) {
        _alternativaSelecionada.value = alternativaEscolhida
        _respostaCorreta.value =
            alternativaEscolhida.equals(alternativaCerta, ignoreCase = true)

        if (_respostaCorreta.value == true) {
            incrementarContadorAcertos()
        }

        viewModelScope.launch {
            delay(500.milliseconds)

            incrementarContadorPerguntas()

            _alternativaSelecionada.value = null
            _respostaCorreta.value = null
        }
    }

    fun incrementarContadorPerguntas () {
        _contadorPerguntas.value = _contadorPerguntas.value!! + 1
    }

    fun incrementarContadorAcertos () {
        _contadorAcertos.value = _contadorAcertos.value!! + 1
    }
}