package subtask1

import java.util.*

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for ((index, current) in sadArray.withIndex()) {
            if (index == 0 || index == sadArray.size - 1) {
                result.add(sadArray[index])
                continue
            }

            val prev = sadArray[index - 1]
            val next = sadArray[index + 1]
            if (current <= prev + next) {
                result.add(current)
            }
        }

        return if (sadArray.size == result.size) { result.toIntArray() } else { convertToHappy(result.toIntArray()) }
    }
}

fun main() {
    val sadArray = intArrayOf(1, 2, 2, 9, 93, 2, 6, 9, 6, 10)
    val happyArray = intArrayOf(1, 2, 2, 2, 6, 9, 6, 10)
    println(HappyArray().convertToHappy(sadArray).contentToString())
}
