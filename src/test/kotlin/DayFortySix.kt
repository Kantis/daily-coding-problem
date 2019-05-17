import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

fun isPalindrome(s: String): Boolean {
    for (i in 0..s.length / 2) {
        if (s[i] != s[s.length - i - 1])
            return false
    }

    return true
}

fun longestPalindrome(s: String): String {
    return if (s.first() == s.last()) {
        if (isPalindrome(s)) {
            s
        } else {
            longestPalindrome(s.substring(1, s.length - 1))
        }
    } else {
        val left = longestPalindrome(s.substring(0, s.length - 1))
        val right = longestPalindrome(s.substring(1, s.length))

        if (left.length > right.length) left else right
    }
}

class DayFortySixTests {

    @Test
    fun `longest palindrome - simple`() {
        assertEquals("a", longestPalindrome("a"))
        assertEquals("aa", longestPalindrome("aa"))
        assertEquals("aa", longestPalindrome("aab"))
    }

    @Test
    fun `longest palindrome - given examples`() {
        assertEquals("bcdcb", longestPalindrome("aabcdcb"))
        assertEquals("anana", longestPalindrome("bananas"))
    }

    @Test
    fun `is palindrome works`() {
        assertTrue(isPalindrome("a"))
        assertTrue(isPalindrome("aa"))
        assertTrue(isPalindrome("aba"))

        assertFalse(isPalindrome("aab"))
    }
}

