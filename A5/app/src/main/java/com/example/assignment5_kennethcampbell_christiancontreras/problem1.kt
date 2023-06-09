package com.example.assignment5_kennethcampbell_christiancontreras

class problem1 {

    val stackSize = 100
    val buffer = IntArray(stackSize * 3)
    val stackPointer = intArrayOf(-1, -1, -1) // pointers to track top element

    @Throws(Exception::class)
    fun push(stackNum: Int, value: Int) {
        /* Check if we have space */
        if (stackPointer[stackNum] + 1 >= stackSize) { // Last element
            throw Exception("Out of space.")
        }
        /* Increment stack pointer and then update top value */
        stackPointer[stackNum]++
        buffer[absTopOfStack(stackNum)] = value
    }

    @Throws(Exception::class)
    fun pop(stackNum: Int): Int {
        if (stackPointer[stackNum] == -1) {
            throw Exception("Trying to pop an empty stack.")
        }
        val value = buffer[absTopOfStack(stackNum)] // Get top
        buffer[absTopOfStack(stackNum)] = 0 // Clear index
        stackPointer[stackNum]-- // Decrement pointer
        return value
    }

    fun peek(stackNum: Int): Int {
        val index = absTopOfStack(stackNum)
        return buffer[index]
    }

    fun isEmpty(stackNum: Int): Boolean {
        return stackPointer[stackNum] == -1
    }

    /* returns index of top of stack "stackNum", in absolute terms */
    fun absTopOfStack(stackNum: Int): Int {
        return stackNum * stackSize + stackPointer[stackNum]
    }

}