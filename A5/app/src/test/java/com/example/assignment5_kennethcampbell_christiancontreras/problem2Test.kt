package com.example.assignment5_kennethcampbell_christiancontreras

import org.junit.Test
import org.junit.Assert.*

class Problem2Test {

    private val p2 = problem2()

    @Test
    fun testEmptyArray() {
        val arr = arrayOf<String>()
        val str = ""
        val result = p2.search(arr, str)
        assertEquals(-1, result)
    }

    @Test
    fun testArrayWithOneElement() {
        val arr = arrayOf("Hello")
        val str = "Hello"
        val result = p2.search(arr, str)
        assertEquals(0, result)
    }

    @Test
    fun testArrayWithMultipleElements() {
        val arr = arrayOf("Apple", "Banana", "Cherry", "Date", "Elderberry")
        val str = "Cherry"
        val result = p2.search(arr, str)
        assertEquals(2, result)
    }

    @Test
    fun testArrayWithEmptyString() {
        val arr = arrayOf("Apple", "", "Cherry", "Date", "Elderberry")
        val str = "Cherry"
        val result = p2.search(arr, str)
        assertEquals(2, result)
    }

    @Test
    fun testArrayWithMultipleEmptyStrings() {
        val arr = arrayOf("", "", "", "", "")
        val str = "Cherry"
        val result = p2.search(arr, str)
        assertEquals(-1, result)
    }

    @Test
    fun testArrayWithAllEmptyStrings() {
        val arr = arrayOf("", "", "", "", "")
        val str = ""
        val result = p2.search(arr, str)
        assertEquals(0, result)
    }

    @Test
    fun testArrayWithDuplicates() {
        val arr = arrayOf("Apple", "Banana", "Cherry", "Date", "Apple")
        val str = "Apple"
        val result = p2.search(arr, str)
        assertEquals(0, result)
    }

    @Test
    fun testSearchWithNullString() {
        val arr = arrayOf("Apple", "Banana", "Cherry", "Date", "Elderberry")
        val str: String? = null
        val result = p2.search(arr, str)
        assertEquals(-1, result)
    }

    @Test
    fun testSearchWithNullArray() {
        val arr: Array<String>? = null
        val str = "Cherry"
        val result = p2.search(arr, str)
        assertEquals(-1, result)
    }

    @Test
    fun testSearchWithNullArrayAndNullString() {
        val arr: Array<String>? = null
        val str: String? = null
        val result = p2.search(arr, str)
        assertEquals(-1, result)
    }
}