package demo.concept.visible

/*
    가시성 수식어
*/

/*
    함수, 프로퍼티와 클래스, 오브젝트, 인터페이스는 최상위에 선언 가능(패키지에 직업 선언 가능)
*/
fun baz() {}
class Baz {}

/*
    - public
        - 모든 곳에서 접근 가능
        - 가시성 수식어 지정하지 않을시 기본 값
    - private
        - 그 선언을 포함한 파일 안에서만 접근 가능
    - protected
        - 최상위 선언에 사용 불가
    - internal
        - 같은 모듈에서 접근 가능
*/
private fun foo() {}       // Visible.kt에서만 접근 가능
public var bar: Int = 5    // 모든 곳에서 접근 가능
    private set             // setter는 Visible.kt에서만 접근 가능
internal val baz = 6       // 같은 모듈에서 접근 가능

/*
    클래스 안에서의 가시성(멤버에 선언한 가시성)
        - public
            - 선언한 클래스를 볼 수 있는 클라이언트
        - private
            - 해당 클래스 안에서만
        - protected
            - private + 하위 클래스
            - 오바리이딩할 때 가시성을 명시적을 지정하지 않으면 오버라이딩한 멤버도 protected
        - internal
            - 선언한 클래스를 볼 수 있는 모듈 안의 모든 클라이언트
*/
open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        val e: Int = 5
    }
}

class Subclass : Outer() {
    // a 접근 불가
    // b, c, d 접근 가능
    // Nested와 e는 접근 가능
    override val b = 5 // protected
}

class Unrelated(o: Outer) {
    // o.a, o.b 접근 불가
    // o.c, o.d 접근 가능(같은 모듈)
    // Outer.Nested는 접근 불가, Nested::e 접근 불가
}

/*
    생성자
        - 생성자는 기본적으로 public
*/
class C private constructor(a: Int)