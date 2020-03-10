package demo.concept

import demo.parseInt

class FlowControl {

    fun ifStatement(a: Int, b: Int) {
        /*
            if문
        */
        // 전통적인 방법
        var max = a

        if (a < b) max = b

        // else 사용
        if (a > b) {
            max = a
        } else {
            max = b
        }

        // 표현식
        max = if (a > b) a else b

        //블록일 경우 마지막 블록이 값이 됨
        max = if (a > b) {
            println("Choose a")
            a
        } else {
            println("Choose b")
            b
        }
    }

    fun whenStatement(x: Any) {
        /*
            when
                - 특정 브랜치의 조건을 충족할 때까지 순차적으로 모든 브랜치와 비교
                - if 처럼 각 브랜치는 블록이 될 수 있고 마지막 식이 브랜치의 값이 됨
        */
        val s = "1"
        when (x) {
            1 -> println("x == 1")
            2, 3 -> println("x == 2 or x == 3")   // 브랜치를 콤마로 묶을 수 있음
            parseInt(s) -> println("x encode x")  // 식 사용 가능
            in 1..10 -> println("x is in the range") // 범위 사용
            !in 1..10 -> println("x is outside the range")
            is String -> x.startsWith("a") //타입 캐스팅
            else -> {                           // 모두 충족하지 않으면 실행
                println("x is neither 1 nor 2")
            }
        }
    }

    fun forLoop() {
        /*
            for
                - 이터레이터를 제공하는 모든 것에 동작
                    - iterator()
                    - next()
                    - 리턴 타입이 Boolean인 hasNext()
                - 위의 세 함수는 모두 operator로 지정해야 함
        */

        val array = listOf(1, 2, 3)

        for (i in array.indices) { // "범위에 대한 반복"은 최적화한 구현으로 컴파일해서 객체를 추가 생성하지 않음
            print(array[i])
        }

        for ((index, value) in array.withIndex()) {
            println("the element at $index is $value")
        }
    }

    fun whileLoop() {
        /*
            while
        */
        var x = 0
        while (x < 10) {
            x++
        }

        /*
            do while
        */

        var z = 0
        do {
            val y = retrieveData(z)
            z++
        } while (y != null) //여기서 y 사용 가능
    }

    fun breakAndContinue() {
        /*
            세가지 구조의 점프식
                - return: 가장 가깝게 둘러싼 함수나 익명함수에서 리턴
                - break: 가장 가깝게 둘러싼 루프를 종료
                - continue: 가장 가깝게 둘러싼 루프의 다음 단계 진행
            - 위의 세가지 모두 더 큰식의 일부로 사용할 수 있음
        */
        val person = Animal(null)
        val s = person.name?: return

        /*
            break와 continue라벨
                - 코틀린의 모든 식에 label을 붙일 수 있다 -> abc@, fooBar@
        */
        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (j == 99) break@loop
            }
        }

        /*
            라벨에 리턴
        */
        val array = arrayOf(1, 2, 3)
        array.forEach lit@ {
            if (it == 0) return@lit
            println(it)
        }

        array.forEach {
            if (it == 0) return@forEach //암묵적인 라벨 (람다를 전달한 함수와 같은 이름을 가짐)
            println(it)
        }

        array.forEach(fun(value: Int) { //람다 대신 익명함수 사용
            if (value == 0) return
            print(value)
        })

        // return@a 1  // @a에 1을 리턴한다는 의미

    }

}

fun retrieveData(x: Int) : Int? {
    if (x === 1) {
        return null
    }
    return 1
}

class Animal(val name: String?)