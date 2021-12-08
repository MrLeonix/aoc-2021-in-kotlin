import java.util.*

fun main() {
    fun part1(input: List<String>): Int {
        val linkedList = LinkedList<String>()
        input[0].split(",").forEach { linkedList.add(it) }
        val bingoMatrices = input.drop(2)
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 230)

    val input = readInput("Day04")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
