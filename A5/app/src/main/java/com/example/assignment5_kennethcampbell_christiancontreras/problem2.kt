package com.example.assignment5_kennethcampbell_christiancontreras

class problem2 {

    fun searchR(strings: Array<String>, str: String, first: Int, last: Int): Int {
        if (first > last) return -1
        /* Move mid to the middle */
        var mid = (last + first) / 2
        /* if mid is empty, find the closest non-empty string. */
        if (strings[mid].isEmpty()) {
            var left = mid - 1
            var right = mid + 1
            while (true) {
                if (left < first && right > last) {
                    return -1
                } else if (right <= last && !strings[right].isEmpty()) {
                    mid = right
                    break
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left
                    break
                }
                right++
                left--
            }
        }

        /* Check for string, and recurse if necessary */
        if (str == strings[mid]) { // Found it!
            return mid
        } else if (strings[mid].compareTo(str) < 0) { // Search right
            return searchR(strings, str, mid + 1, last)
        } else { // Search left
            return searchR(strings, str, first, mid - 1)
        }
    }

    fun search(strings: Array<String>?, str: String?): Int {
        if (strings == null || str == null || str == "") {
            return -1
        }
        return searchR(strings, str, 0, strings.size - 1)
    }
}