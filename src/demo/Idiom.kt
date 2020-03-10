package demo

class Idiom {

    fun run() {
        /*
            함수 파라미터 기본값
        */
        foo()
        foo(3)

        /*
            리스트 필터링
        */

        val list = listOf("a", "b", "c")

        val positives = list.filter { x -> x === "a" }
        val positives2 = list.filter { it === "a" }

        /*
            쌍으로 맵이나 목록 탐색
        */
        val map: MutableMap<String, Int> = mutableMapOf("One" to 1)
        map["Two"] = 2

        for ((k, v) in map.entries) {
            println("key is $k, value is $v")
        }

        /*
            범위 사용
        */
        for (i in 1..100) {}
        for (i in 1 until 100) {}
        for (i in 2..10 step 2) {}
        for (i in 10 downTo 1) {}
//    if (x in 1..10) {}

        /*
            읽기 전용 리스트
        */
        val readOnlyList = listOf("a", "b", "c")
        /*
            읽기 전용 맵
        */
        val readOnlyMap = mapOf("a" to 1, "b" to 2)
    }
}

fun foo(a: Int = 0) {
    println(a)
}
