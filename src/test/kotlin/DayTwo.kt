import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Problem:
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */

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