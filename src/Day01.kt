fun main() {
    fun analyseInput(input: List<String>) {
        var incrementalCount = 0
        var sumIncrementalCount = 0
        val sumOfThree = mutableListOf<Int>()

        input.forEachIndexed { i, measurement ->
            val intVal = measurement.toInt()
            var previousSum: Int = Int.MAX_VALUE

            if (sumOfThree.size >= 3) {
                previousSum = sumOfThree.sum()
                print("$previousSum $sumOfThree (<- $measurement) | ")
                sumOfThree.removeFirst()
            }
            sumOfThree.add(intVal)
            if (sumOfThree.sum() > previousSum) {
                sumIncrementalCount++
                println("${sumOfThree.sum()} $sumOfThree ($sumIncrementalCount)")
            } else
            println("${sumOfThree.sum()} $sumOfThree")

            if (i != 0 && intVal > input[i - 1].toInt()) {
                incrementalCount++
            }
        }

        println("Incremental count: $incrementalCount | Sum incremental count: $sumIncrementalCount.")
    }

    fun part1(input: List<String>): Int {
        analyseInput(input)
        return input.size
    }

    fun part2(input: List<String>): Int {
        analyseInput(input)
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 10)

    val input = readInput("Day01")
    part2(input)
}
