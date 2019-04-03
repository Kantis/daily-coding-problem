
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

fun k(numbers: List<Int>, k: Int): Boolean {
    val seenValues = HashSet<Int>()

    for (i in numbers) {
        if (seenValues.contains(i)) {
            return true
        } else {
            seenValues.add(k - i)
        }
    }

    listOf(1, 2, 3)
        .map { it * 2 }
        .toSet()

    return false
}

class Tests {

    @Test
    fun `empty list`() {
        assertFalse { k(listOf(), 0) }
        assertFalse { k(listOf(), 1) }
        assertFalse { k(listOf(), -1) }
    }

    @Test
    fun `happy cases`() {
        assertTrue { k(listOf(10, 15, 3, 7), 25) }
        assertTrue { k(listOf(10, 15, 3, 7), 13) }
        assertTrue { k(listOf(10, 15, 3, 7), 17) }
        assertTrue { k(listOf(10, 15, 3, 7), 18) }
        assertTrue { k(listOf(10, 15, 3, 7), 22) }
        assertTrue { k(listOf(10, 15, 3, 7), 10) }

        assertFalse { k(listOf(10, 15, 3, 7), 15) }
    }

}