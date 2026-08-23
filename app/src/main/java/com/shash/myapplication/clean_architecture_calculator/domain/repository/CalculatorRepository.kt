package com.shash.myapplication.clean_architecture_calculator.domain.repository

interface CalculatorRepository {
    fun evaluate(expression: String): String
}