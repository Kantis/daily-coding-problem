
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun prodOfOthers(numbers: List<Int>): List<Int> {
    return prodOfOthers(numbers, 0)
}

fun prodOfOthers(numbers: List<Int>, pos: Int): List<Int> {
    if (numbers.isEmpty() || pos == numbers.size)
        return emptyList()

    val leftProd = if (pos > 0) numbers.slice(IntRange(0, pos - 1)).reduce(::multiply) else 1
    val rightProd = if (pos < numbers.size - 1) numbers.slice(IntRange(pos + 1, numbers.size - 1)).reduce(::multiply) else 1

    return listOf(leftProd * rightProd) + prodOfOthers(numbers, pos + 1)
}


class DayTwoTests {

    @Test
    fun firstGiven() {
        assertEquals(listOf(120, 60, 40, 30, 24), prodOfOthers(listOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun secondGiven() {
        assertEquals(listOf(2, 3, 6), prodOfOthers(listOf(3, 2, 1)))
    }

}