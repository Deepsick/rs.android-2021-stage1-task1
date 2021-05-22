package subtask3

class StringParser {
    private val bracketsMap = mapOf('[' to ']', '(' to ')', '<' to '>')

    fun getResult(inputString: String): Array<String> {
        val resultList: MutableList<String> = mutableListOf();
        var currentString = inputString
        while (currentString.isNotEmpty()){
            val openChar = currentString[0]
            if (bracketsMap.containsKey(openChar)){
                val closeChar = bracketsMap[openChar]
                var depth = 0
                for ((index, value) in currentString.withIndex()){
                    when (value){
                        openChar -> depth++
                        closeChar -> depth--
                    }
                    if (depth == 0) {
                        resultList.add(currentString.substring(1, index))
                        break
                    }
                }
            }
            currentString = currentString.substring(1)
        }
        return resultList.toTypedArray()
    }
}
