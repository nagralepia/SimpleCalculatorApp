package com.shash.myapplication.clean_architecture_calculator.domain.usecase

import com.shash.myapplication.clean_architecture_calculator.domain.repository.CalculatorRepository
import javax.inject.Inject

class EvaluateExpressionUseCase @Inject constructor(private val repository: CalculatorRepository) {
    operator fun invoke(expression: String): String {
        if (expression.isBlank()) return 0.toString()
        return repository.evaluate(expression)
    }
}