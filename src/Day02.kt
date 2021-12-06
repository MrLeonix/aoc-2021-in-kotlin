class Submarine(var depth: Int = 0, var horizontalAxis: Int = 0, var aim: Int = 0) {
    fun executeCommand(command: String, value: Int) {
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
    fun analyseInput(input: List<String>) {
        val submarine = Submarine()

        input.forEachIndexed { i, command ->
            val commandSplit = command.split(" ")
            submarine.executeCommand(commandSplit[0], commandSplit[1].toInt())
        }

        println(
            "Depth: ${submarine.depth} | Horizontal axis: ${submarine.horizontalAxis}. " +
                    "Multiplied: ${submarine.depth * submarine.horizontalAxis}"
        )
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
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 6)

    val input = readInput("Day02")
    part2(input)
}
