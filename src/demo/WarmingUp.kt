package demo

class WarmingUp {

    fun defineFunc() {
        println(sum(1, 2))
        println(sum2(1, 3))
        printSum(2, 3)
    }

    fun defineVal() {
        // val: 불변
        val a: Int = 1
        val b = 2
        val c: Int
        c = 3

        println("a is $a, b is $b c is $c")

        // var: 가변
        var x = 1
        x += 3
    }

    fun stringTemplate() {
        var intVal = 0;
        var str = "intVal is $intVal"

        // 임의의 식 사용
        var intVal2 = 2;
        var str2 = "${str.replace("is", "was")}, but not is $intVal2"
    }

    fun conditionalExp() {
        /*
            if문 사용
        */
        maxOf(1, 2)
        maxOf2(2, 1)

        /*
            when 식 사용
        */
        describe(1)
    }

    fun loop() {
        /*
           for 루프
       */
        var items = listOf("apple", "banana", "kiwi")
        for (item in items) {
            println(item)
        }

        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        /*
            while 루프
        */
        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }
    }

    fun ranges() {
        /*
            범위 사용 (in)
        */
        val x2 = 10
        val y2 = 9
        if (x2 in 1..y2+1) {
            println("fits in range")
        }

        val list = listOf("a", "b", "c")
        if (-1 !in 0..list.lastIndex) {
            println("-1 is out of range")
        }
        if (list.size !in list.indices) {
            println("list size is out of valid list indices range too")
        }
    }

}

// 함수 선언
fun sum(a: Int, b: Int): Int {
    return a + b
}
// 식 몸체를 사용하고 리턴 타입 추론
fun sum2(a: Int, b: Int) = a + b

// 의미없는 값을 리턴하는 함수
fun printSum(a: Int, b: Int)/*: Unit //생략 가능 */ {
    println("sum of $a and $b is ${a + b}")
}



// 조건식 사용
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
// if를 식으로 사용
fun maxOf2(a: Int, b: Int) = if (a > b) a else b



// null 가능 값 사용 과 null 검사
fun parseInt(str: String): Int? {
    return null
}

fun pringProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    var y = parseInt(arg2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

// 타입 검사와 자동 변환 사용
fun getStringLength(obj: Any): Int? {
    if (obj is String) { // is 연산자 조건이 맞을 시 자동 형변환
        return obj.length
    }
    return null
}
fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null

    return obj.length
}
fun getStringLength3(obj: Any): Int? {
    if (obj is String && obj.length > 0) { // 우변의 &&에서 자동 형변환이 일어남
        return obj.length
    }
    return null
}


fun describe(obj: Any): String =
    when (obj) {
        1           -> "One"
        "Hello"     -> "Greeting"
        is Long     -> "Long"
        !is String  -> "Not a String"
        else        -> "Unknown"
    }
