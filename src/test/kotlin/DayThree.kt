import org.junit.jupiter.api.Test

val separator = '#';
val nullMarker = '@';

data class ReadResult(
    val endIndex: Int,
    val result: Node?
)

data class Node(
    val value: String,
    val left: Node? = null,
    val right: Node? = null
)

fun serialize(node: Node?): String {
    if (node == null) {
        return nullMarker.toString();
    }
    return node.value + "#" + serialize(node.left) + serialize(node.right)
}

fun deserialize(serialized: String): Node? {
    return deserialize(serialized, 0).result
}

fun deserialize(serialized: String, index: Int): ReadResult {
    if (serialized[index] == nullMarker) {
        return ReadResult(index + 1, null);
    }

    val endIndex = serialized.indexOf(separator, startIndex = index)
    val left = deserialize(serialized, endIndex + 1)
    val right = deserialize(serialized, left.endIndex)

    return ReadResult(right.endIndex, Node(serialized.substring(index, endIndex), left.result, right.result));
}


class DayTwelveTests {

    @Test
    fun serialize() {
        val node = Node("hello")
        assert(serialize(node) == "hello#@@")

    }

    @Test
    fun `single leaf`() {
        val node = Node("hej");
        assert(deserialize(serialize(node))?.value == "hej");
    }

    @Test
    fun `given example`() {
        val node = Node("root", Node("left", Node("left.left")), Node("right"))
        val serialized = serialize(node)
        assert(deserialize(serialized)?.left?.left?.value == "left.left")
    }

}

