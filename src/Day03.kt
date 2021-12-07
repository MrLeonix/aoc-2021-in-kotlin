fun main() {
    fun part1(input: List<String>): Int {
        var gammaRate = ""
        var epsilonRate = ""

        val countList = IntArray(input[0].length)

        input.forEach { binary ->
            binary.forEachIndexed { i, c -> if (c == '1') countList[i]++ }
        }
        countList.forEach {
            if (it >= input.size / 2) {
                gammaRate += "1"
                epsilonRate += "0"
            } else {
                gammaRate += "0"
                epsilonRate += "1"
            }
        }
        val gammaRateDecimal = Integer.parseInt(gammaRate, 2)
        val epsilonRateDecimal = Integer.parseInt(epsilonRate, 2)

        return gammaRateDecimal * epsilonRateDecimal
    }

    fun extractSingleBinary(input: List<String>, isMostCommon: Boolean, bit: Int): String {
        val onesList = mutableListOf<String>()
        val zeroesList = mutableListOf<String>()

        val newList = mutableListOf<String>()

        input.forEach {
            if (it[bit - 1] == '1') onesList.add(it)
            else zeroesList.add(it)
        }

        if (isMostCommon) {
            if (onesList.size >= zeroesList.size) newList.addAll(onesList)
            else newList.addAll(zeroesList)
        } else {
            if (zeroesList.size <= onesList.size) newList.addAll(zeroesList)
            else newList.addAll(onesList)
        }

        return if (newList.size == 1) newList[0]
        else extractSingleBinary(newList, isMostCommon, bit + 1)
    }

    fun part2(input: List<String>): Int {
        val oxygenList = mutableListOf<String>()
        val co2List = mutableListOf<String>()

        val onesList = mutableListOf<String>()
        val zeroesList = mutableListOf<String>()
        input.forEach {
            if (it[0] == '1') onesList.add(it)
            else zeroesList.add(it)
        }

        if (onesList.size >= zeroesList.size) {
            oxygenList.addAll(onesList)
            co2List.addAll(zeroesList)
        } else {
            oxygenList.addAll(zeroesList)
            co2List.addAll(onesList)
        }

        val oxygenGeneratorRating = Integer.parseInt(extractSingleBinary(oxygenList, true, 2), 2)
        val co2ScrubberRating = Integer.parseInt(extractSingleBinary(co2List, false, 2), 2)

        return oxygenGeneratorRating * co2ScrubberRating
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("Day03")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
