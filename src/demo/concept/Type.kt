package demo.concept

class Type {

    fun literal() {
        /*
            정수 값을 위한 리터럴 상수
                - 십진수: 123
                    - Long은 대문자 L을 붙여서 표시 -> 1L
                - 16진수 0x0F
                - 2진수 0b00001011

                * 8진수 리터럴은 지원하지 않음

            부동소수점 표기법
                - 기본은 Double: 123.5, 123.5e10
                - Float은 f나 F를 붙여 표시 -> 123.5f
        */

        // 숫자 리터럴 밑줄
        val oneMillion = 1_000_000
        val creditCardNumber = 1234_5678_9012_3456L
        val hexBytes = 0xFF_FC_DE_5E
        val bytes = 0b11010010_01101001_10010100_10010010
    }

    fun autoBoxing() {
        /*
            자바 플랫폼에서는 JVM 기본 타입으로 숫자를 저장
            만약 null 가능 숫자 레퍼런스가 필요하면 자료령 뒤애 물음표(?)를 붙임 (박싱 타입)
                * 단, 숫자를 박싱하면 동일성을 유지하지 않음
        */
        val a: Int = 10000
        println(a === a) //true
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        print(boxedA === anotherBoxedA) // false
        print(boxedA == anotherBoxedA) // true

    }

    fun casting() {
        val a: Int? = 1
        val b: Long? = a?.toLong()
//        print(a == b) // 비교 안됨

        val c: Byte = 1
        val i: Int = c.toInt() // 명시적 변환

        /*
            모든 숫자 타입은 아래의 변환을 지원
                - toByte(): Byte
                - toShort(): Short
                - toInt(): Int
                - toLong(): Long
                - toFloat(): Float
                - toDouble(): Double
                - toChar(): Char
        */
    }

    fun calculate() {
        /*
            연산시 크기가 큰 자료형으로 형변환 됨
        */
        val l = 1L + 3 // Long + Int = Long

        /*
            비트 연산
                - shl(bits): 부호있는 왼쪽 시프트(<<)
                - shr(bits): 부호있는 오른쪽 시프트(>>)
                - ushr(bits) – 부호없는 오른쪽 시프트 (>>>)
                - and(bits) – 비트 AND
                - or(bits) – 비트 OR
                - xor(bits) – 비트 XOR
                - inv() – 비트 역
        */
        val x = (1 shl 2) and 0x000FF000
    }

    fun compare() {

        /*
            부동소수 비교
                - 동등 비교: a == b
                - 비교 연산자: a < b, a <= b
                - 범위 생성과 검사 a..b, x in a..b, x !in a..b
        */

        /*
            문자 비교
        */
        val c: Char = '1'
//      if (c == 1) {} // 비교 불가
//      if (c.toInt() === 1) //OK

        /*
            불리언 비교
                - ||: 지연 논리합
                - &&: 지연 논리곱
                - !: 역
        */
    }

    fun array() {
        /*
            배열 생성 방법
        */
        // 팩토리 함수
        val asc = Array(5) { i -> (i * i).toString() }

        // 기본 타입 배열 클래스 (ByteArray , ShortArray , IntArray 등)
        val x: IntArray = intArrayOf(1, 2, 3)
        x[0] = x[1] + x[2]
    }

    fun string() {
        /*
            문자열은 String 타입으로 표현
            문자열은 불변
            인덱스로 접근 가능 -> s[i]
        */
        val str = "abc"
        for (c in str) {
            println(c)
        }

        /*
            문자열 리터럴
        */
        val s = "Hello, world!\n"

        // raw 문자열 """
        val text = """
            for (c in "foo")
                print(c)
        """.trimMargin() // trimMargin 함수를 통해 앞쪽 공객 제거 가능

        /*
            문자열 템플릿
        */
        val intStr = 10
        val strTpl = "i = $intStr"

        val price = """
            ${'S'}9.99
        """.trimIndent()
    }

}