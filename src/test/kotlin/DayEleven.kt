import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

data class Node2(
    val me: String,
    val children: Array<Node2?> = Array(28, init = { null }),
    val leaf: Boolean = false
) {

    fun getWords(): Set<String> {
        if (leaf)
            return setOf(me)

        return children.filter { it != null }.flatMap { it!!.getWords() }.toSet()
    }
}

fun toIndex(c: Char): Int {
    return c.toLowerCase().toInt() - 97
}

fun searchTree(prefix: String, tree: Node2): Set<String> {
    var currNode = tree

    for (i in prefix) {
        if (currNode.children[toIndex(i)] == null)
            return emptySet()

        currNode = currNode.children[toIndex(i)]!!
    }

    return currNode.getWords()
}

fun createTree(words: Set<String>): Node2 {
    val root = Node2("")

    for (i in words) {
        var currNode = root

        for (j in 0 until i.length) {
            val key = toIndex(i[j])
            if (currNode.children[key] == null)
                currNode.children[key] = Node2(i.substring(0, j))

            currNode = currNode.children[key]!!
        }

        currNode.children[toIndex(i.last())] = Node2(i, leaf = true)
    }

    return root
}

class DayElevenTests {
    @Test
    fun toIndex() {
        assertEquals(0, toIndex('a'))
        assertEquals(0, toIndex('A'))
    }

    @Test
    fun someTest() {
        val tree = createTree(setOf("dog", "deer", "deal"))

        assertEquals(setOf("deer", "deal"), searchTree("de", tree))
    }

    @Test
    fun prefixIsWord() {
        val tree = createTree(setOf("dog", "deer", "deal", "dealer", "dealing"))

        assertEquals(setOf("deal", "dealer", "dealing"), searchTree("dea", tree))
    }
}





