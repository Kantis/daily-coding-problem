import org.junit.jupiter.api.Test
import kotlin.math.max

fun largestNonAdjacentSum(items: List<Int>): Int {

    var sumA = items[0]
    var sumB = items[1]

    for (i in items.slice(IntRange(2, items.size - 1))) {
        if (sumA + i > sumB) {
            sumB = sumA + i
        } else {
            sumA = sumB
        }
    }

    return max(sumA, sumB)

}

class DayNineTests {
    @Test
    fun `given samples`() {
        assert(largestNonAdjacentSum(listOf(2, 4, 6, 2, 5)) == 13)
        assert(largestNonAdjacentSum(listOf(5, 1, 1, 5)) == 10)
    }
}

