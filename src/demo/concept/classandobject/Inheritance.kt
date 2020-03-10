package demo.concept.classandobject

/*
    상속
        - 코틀린의 모든 클래스는 공통의 최상위 클래스인 Any를 상속
            - Any는 자바의 Object와는 다르다
            - equals(), hashCode(), toString() 외에 다른 멤버를 가지지 않음

        - open 키워드는 자바의 final과 반대로 상속을 허용한다
            - 코틀린의 모든 클래스는 기본적으로 final
                -> 이펙티브 자바 item 17 참조
*/
// 기본으로 Any를 상속
class Example

// 상위 타입을 직접 선언하려면 클래스 헤더에서 콜론 뒤에 타입을 위치 시킴
open class Base(p: Int)
class Derived(p: Int) : Base(p) // 클래스에 주요 생성자가 있으면 주요 생성자의 파라미터를 사용해서 기반 타입을 그 자리에서 초기화 가능

// 주요 생성자가 없으면 super 키워드로 초기화 하거나 다른 생성자 호출
open class Base2 {
    constructor(p: Int)
    constructor(p: Int, q: String)
}
class Derived2 : Base2 {
    constructor(p: Int) : super(p)
    constructor(p: Int, q: String) : super(p, q)
}


/*
    메서드 오버라이딩
        - ovveride 키워드가 붙은 멤버는 그 자체로 open이며 하위 클래스에서 오버라이딩하는 것을 막고 싶다면 final 사용
*/
open class Base3 {
    open fun v() {}
    fun nv() {}
}
class Derived3() : Base3() {
    final override fun v() {}
}

/*
    프로퍼티 오버라이딩
        - 메서드 오버라이딩과 유사하게 동작
        - val -> var (O) / var -> val (X)
*/
open class Foo {
    open val x: Int get() { return 1 }
}
class Bar() : Foo() {
    override val x: Int get() { return 2 }
}

// 주요 생성자에 선언한 프로퍼티도 오버라이딩 가능
interface Foo2 {
    val count: Int
}
class Bar2(override val count: Int) : Foo2
class Bar3 : Foo2 {
    override var count: Int = 0
}

/*
    상위클래스 구현 호출
        - 하위클래스는 super 키워드를 사용해서 상위클래스의 함수와 프로퍼티 접근을 구현할 수 있음
*/
open class Foo3 {
    open fun f() { println("Foo3.f()") }
    open val x: Int get() = 1
}
class Bar4 : Foo3() {
    override fun f() {
        super.f()
        println("Bar4.f()")
    }

    override val x: Int get() = super.x + 1
}

// 내부 클래스는 super@Outer와 같이 외부 클래스의 이름을 사용해서 외부클래스의 상위 클래스에 접근 가능
class Bar5 : Foo3() {
    override fun f() {}
    override val x: Int get() = 0

    inner class Baz {
        fun g() {
            super@Bar5.f() //Foo3의 f의 구현
            println(super@Bar5.x)
        }
    }
}

/*
    오버라이딩 규칙
        - 코틀린 구현 상속은 다음 규칙에 따라 제한
            - 클래스가 바로 위의 상위 클래스에서 같은 멤버의 구현을 여러개 상속받으면 반드시 멤버를 오버라이딩하고 자신을 구현
            - 어떤 상위 타입의 구현을 사용할지 선택하려면 홑화살괄호 안에 상위 타입의 이름을 붙인 super를 사용
*/
open class A {
    open fun f() { println("A") }
    fun a() { println("a") }
}

interface B {
    fun f() { print("B") } //인터페이스 멤버는 기본이 open
    fun b() { print("b") }
}

class C : A(), B {
    // 컴파일러는 f()를 오버라이딩할 것을 요구함
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}
/*
    A과 B를 둘다 상속 받더라도 a()와 b()는 문제되지 않음 C가 함수의 구현을 한 개만 항속하기 때문
    하지만 f()의 경우 C는 두개의 구현을 상속받으므로 C에 f()을 오버라이딩하고 자신의 구현을 제공해서 애매함을 없애야함
*/


/*
    추상클래스
        - abstract 키워드로 선언
        - 추상 멤버는 그 클래스에 구현을 갖지 않음
        - open 키워드를 붙일 필요 없음
*/
open class Base4 {
    open fun f() {}
}
abstract class Derived4 : Base4() {
    abstract override fun f()
}


/*
    코틀린은 자바와 달리 정적 메서드가 없음
    많은 경우 간단하게 패키지 수준의 함수를 대신 사용할 것을 권장
*/