fun main() {
    fun part1(input: List<String>): Int {
        var incrementalCount = 0

        input.forEachIndexed { i, measurement ->
            if (i != 0 && measurement.toInt() > input[i - 1].toInt()) {
                incrementalCount++
            }
        }

        return incrementalCount
    }

    fun part2(input: List<String>): Int {
        var sumIncrementalCount = 0
        val sumOfThree = mutableListOf<Int>()

        input.forEach { measurement ->
            val intVal = measurement.toInt()
            var previousSum: Int = Int.MAX_VALUE

            if (sumOfThree.size >= 3) {
                previousSum = sumOfThree.sum()
                sumOfThree.removeFirst()
            }
            sumOfThree.add(intVal)
            if (sumOfThree.sum() > previousSum) {
                sumIncrementalCount++
            }
        }

        return sumIncrementalCount
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
