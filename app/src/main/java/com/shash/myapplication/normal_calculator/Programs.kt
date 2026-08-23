package com.shash.myapplication.normal_calculator

fun main() {
//   println("${add(34,32)}")

    var x = 1
    var y = 2
    val (v1, v2) = swap1(x, y)
    x = v1
    y = v2
    println("Main After Swap $x and $y")
}

fun swap(a: Int, b: Int) {
    println("Before Swap $a and $b ")

    val c = a
    val a = b
    val b = c
    println("After Swap $a and $b ")
}

fun swap1(a: Int, b: Int): Pair<Int, Int> {
    println("Before Swap $a  and $b  After Swap ${Pair(b, a)}")
    return Pair(b, a)
}

fun add(a: Int, b: Int): Int {
    return a + b
}
