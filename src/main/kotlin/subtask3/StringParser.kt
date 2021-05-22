package subtask3

import java.util.*

class StringParser {
    val mapClosingToOpeningBracket = mutableMapOf<Char, Char>(
        ']' to '[',
        '>' to '<',
        ')' to '('
    )

    fun isOpening(letter: Char): Boolean {
        return letter == '[' || letter == '(' || letter == '<'
    }

    fun isClosing(letter: Char) = letter == ']' || letter == ')' || letter == '>'

    fun getResult(inputString: String): Array<String> {
        var result = mutableListOf<String>()
        val stack = mutableListOf<Pair<Char, Int>>()
        var placementsCount = 0
        loop@ for ((index, letter) in inputString.withIndex()) {
            if (isOpening(letter)) {
                stack.add(letter to index)
                continue
            }
            if (isClosing(letter)) {
                if (stack.size == 0) continue@loop
                var cursor = stack.size - 1
                while (cursor >= 0)  {
                    if (mapClosingToOpeningBracket[letter] == stack[cursor].first) {
                        for (index in (cursor+1) until stack.size) {
                            if (index < stack.size) {
                                stack.removeAt(index)
                            }
                        }
                        break
                    }
                    cursor--
                }
                if (cursor == 0 && mapClosingToOpeningBracket[letter] != stack[cursor].first) {
                    continue@loop
                }

                if (stack.size > 1) {
                    placementsCount = Math.max(stack.size, placementsCount)

                }

                val startIndex = stack.removeAt(stack.size - 1).second + 1
                val lastIndex = index
                val substring = inputString.slice(startIndex until lastIndex)
                result.add(substring)
            }


            if (stack.size == 0 && placementsCount > 0) {
                result = (result.slice(0 until result.size - placementsCount)
                        + result
                    .slice(result.size - placementsCount until result.size)
                    .reversed()
                        ).toMutableList()
                placementsCount = 0
            }
        }

        return result.toTypedArray()
    }
}
