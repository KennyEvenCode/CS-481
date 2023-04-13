package com.example.assignment5_kennethcampbell_christiancontreras


import org.junit.Assert.*
import org.junit.Test

class Problem1Test {
    @Test
    fun testPushAndPop() {
        val stack = problem1()
        stack.push(0, 1)
        stack.push(1, 2)
        stack.push(2, 3)
        assertEquals(1, stack.pop(0))
        assertEquals(2, stack.pop(1))
        assertEquals(3, stack.pop(2))
    }

    @Test
    fun testPeek() {
        val stack = problem1()
        stack.push(0, 1)
        stack.push(1, 2)
        stack.push(2, 3)
        assertEquals(1, stack.peek(0))
        assertEquals(2, stack.peek(1))
        assertEquals(3, stack.peek(2))
    }


    @Test
    fun testIsEmpty() {
        val stack = problem1()
        assertTrue(stack.isEmpty(0))
        assertTrue(stack.isEmpty(1))
        assertTrue(stack.isEmpty(2))
        stack.push(0, 1)
        assertFalse(stack.isEmpty(0))
        assertTrue(stack.isEmpty(1))
        assertTrue(stack.isEmpty(2))
    }

    @Test(expected = Exception::class)
    fun testPushThrowsExceptionWhenOutOfSpace() {
        val stack = problem1()
        for (i in 0 until 101) {
            stack.push(0, i)
        }
    }

    @Test(expected = Exception::class)
    fun testPopThrowsExceptionWhenStackIsEmpty() {
        val stack = problem1()
        stack.pop(0)
    }

    @Test
    fun testAbsTopOfStack() {
        val stack = problem1()
        stack.push(0, 1)
        stack.push(0, 2)
        assertEquals(1, stack.absTopOfStack(0))
        stack.push(1, 3)
        assertEquals(101, stack.absTopOfStack(1))
        stack.push(2, 4)
        assertEquals(201, stack.absTopOfStack(2))
    }

    @Test
    fun testPushAndPopMultipleValues() {
        val stack = problem1()
        for (i in 1..300) {
            stack.push(i % 3, i)
        }
        for (i in 299 downTo 0) {
            assertEquals(i + 1, stack.pop(i % 3))
        }
    }

    @Test
    fun testPushAndPeek() {
        val stack = problem1()
        stack.push(0, 1)
        assertEquals(1, stack.peek(0))
        stack.push(0, 2)
        assertEquals(2, stack.peek(0))
    }

    @Test
    fun testPopAndPush() {
        val stack = problem1()
        stack.push(0, 1)
        stack.push(0, 2)
        assertEquals(2, stack.pop(0))
        assertEquals(1, stack.pop(0))
        stack.push(0, 3)
        assertEquals(3, stack.peek(0))
    }

    @Test
    fun testMultiplePushAndPop() {
        val stack = problem1()
        stack.push(0, 1)
        stack.push(1, 2)
        stack.push(2, 3)
        assertEquals(1, stack.pop(0))
        stack.push(1, 4)
        stack.push(2, 5)
        assertEquals(4, stack.pop(1))
        stack.push(0, 6)
        assertEquals(6, stack.peek(0))
        assertEquals(2, stack.pop(1))
        assertEquals(5, stack.pop(2))
        assertTrue(stack.isEmpty(0))
        assertTrue(stack.isEmpty(1))
        assertTrue(stack.isEmpty(2))
    }

}