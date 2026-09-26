package com.shash.myapplication.clean_architecture_calculator.data.repository

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculatorRepositoryImplTest {

    private val repository = CalculatorRepositoryImpl()

    @Test
    fun `evaluate addition returns correct result`() {
        val result = repository.evaluate("2+3")
        assertEquals("5.0", result)
    }

    @Test
    fun `evaluate substraction returns correct result`() {
        val result = repository.evaluate("7-5")
        assertEquals("2.0", result)
    }


    @Test
    fun `evaluate multiplication returns correct result`() {
        val result = repository.evaluate("2*3")
        assertEquals("6.0", result)
    }

    @Test
    fun `evaluate division returns correct result`() {
        val result = repository.evaluate("7-2")
        assertEquals("5.0", result)
    }

    @Test
    fun `evaluate respects multiple precedence`() {
        val result = repository.evaluate("7-2*8")
        assertEquals("-9.0", result)
    }

    @Test
    fun `evaluate respects division precedence`() {
        val result = repository.evaluate("10+10/2")
        assertEquals ("15.0", result)
    }

    @Test
    fun `evaluate decimal numbers correctly`() {
        val result = repository.evaluate("2.5+1.5")
        assertEquals ("4.0", result)
    }

    @Test
    fun `evaluate invalid expression returns Error`() {
        val result = repository.evaluate("2+")
        assertEquals ("Error", result)
    }

}