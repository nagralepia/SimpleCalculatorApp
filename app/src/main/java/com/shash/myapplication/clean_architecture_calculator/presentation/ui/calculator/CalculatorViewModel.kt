package com.shash.myapplication.clean_architecture_calculator.presentation.ui.calculator

import androidx.lifecycle.ViewModel
import com.shash.myapplication.clean_architecture_calculator.domain.usecase.EvaluateExpressionUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CalculatorViewModel @Inject constructor(private val evaluateExpressionUseCase: EvaluateExpressionUseCase) : ViewModel() {
    private val _inputState = MutableStateFlow("")
    val inputState : StateFlow<String> = _inputState.asStateFlow()

    fun onAction(action:String){
        when (action){
            "C" -> _inputState.value =""
            "=" -> _inputState.value = evaluateExpressionUseCase(_inputState.value)
            else -> _inputState.value+=action
        }
    }
}