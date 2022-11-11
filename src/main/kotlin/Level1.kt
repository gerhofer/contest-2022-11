import java.io.File

fun main(args: Array<String>) {
    solveAll("level1")
}

fun solveLevel1(filename: String): List<String> {
    val lines = File(filename).readLines()
    val numbers = lines.drop(1)
            .flatMap { it.trim().split(" ") }
            .map { it.toInt() }
   return listOf(numbers.sum().toString())
}

fun solveAll(level: String) {
    val levelDir = "C:\\Users\\Pia\\IdeaProjects\\contest-11-2022\\src\\main\\resources\\$level"

    File(levelDir).walk().filter { it.isFile && it.absolutePath.endsWith(".in") }.forEach {
        println("hello file ${it.name}")
        val outPath = it.absolutePath.replace(".in", ".out")
        val result = solveLevel1(it.absolutePath).joinToString("\n")
        println(result)
        File(outPath).writeText(result)
    }
}