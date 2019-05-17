import org.junit.jupiter.api.Test

fun cons(a: Int, b: Int): ((Int, Int) -> Int) -> Int {

    return fun(f: (Int, Int) -> Int): Int {
        return f(a, b)
    }

}

fun car(cell: ((Int, Int) -> Int) -> Int): Int {
    return cell { a, _ -> a }
}

fun cdr(cell: ((Int, Int) -> Int) -> Int): Int {
    return cell { _, b -> b }
}

class DayFiveTests {

    @Test
    fun someTest() {
        assert(car(cons(3, 7)) == 3)
        assert(cdr(cons(3, 7)) == 7);
    }

}




