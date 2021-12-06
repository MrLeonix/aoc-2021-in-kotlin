class Submarine(var depth: Int = 0, var horizontalAxis: Int = 0, var aim: Int = 0) {
    fun executePart1Command(command: String, value: Int) {
        when (command) {
            "up" -> depth = depth.minus(value)
            "down" -> depth = depth.plus(value)
            "forward" -> horizontalAxis = horizontalAxis.plus(value)
            else -> println("Invalid command '$command'.")
        }
    }

    fun executePart2Command(command: String, value: Int) {
        when (command) {
            "up" -> aim = aim.minus(value)
            "down" -> aim = aim.plus(value)
            "forward" -> {
                horizontalAxis = horizontalAxis.plus(value)
                depth = depth.plus(aim * value)
            }
            else -> println("Invalid command '$command'.")
        }
    }
}

fun main() {
    fun part1(input: List<String>): Int {
        val submarine = Submarine()

        input.forEach { command ->
            val commandSplit = command.split(" ")
            submarine.executePart1Command(commandSplit[0], commandSplit[1].toInt())
        }

        return submarine.horizontalAxis * submarine.depth
    }

    fun part2(input: List<String>): Int {
        val submarine = Submarine()

        input.forEach { command ->
            val commandSplit = command.split(" ")
            submarine.executePart2Command(commandSplit[0], commandSplit[1].toInt())
        }

        return submarine.horizontalAxis * submarine.depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println("Part 1: ${part1(input)}")
    println("Part 2: ${part2(input)}")
}
