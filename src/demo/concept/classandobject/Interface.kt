package demo.concept.classandobject

/*
    인터페이스
        - 자바 인터페이스와 유사
        - 추상 메서드를 선언할 수 있음
        - 메서드 구현 포함 가능
        - 상태를 가질 수 없음(추상 클래스와의 차이점)
        - 프로퍼티를 가질 수 있지만 추상이거나 접근자 구현을 제공해야 함
*/
interface MyInterface {
    fun bar()
    fun foo() {
        //...
    }
}

// 인터페이스 구현
class Child : MyInterface {
    override fun bar() {
        //...
    }
}

/*
    인터페이스의 프로퍼티
        - 인터페이스에 선언한 프로퍼티는 추상이거나 접근자를 위한 구현을 제공
        - 지원 필드를 가질 수 없으므로 선언한 프로퍼티에서 지원필드를 참조할 수 없음
*/
interface MyInterface2 {
    val prop: Int //추상
    val propertuWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}
class Child2 : MyInterface2 {
    override val prop: Int = 20
}

/*
    오버라이딩 충돌 해결
        - 상위 타입 목록에 여러 타입을 지정하면 같은 메서드에 대한 구현을 두 개 이상 상속 받을 수 있음
*/
interface A2 {
    fun foo() { print("A2") }
    fun bar()
}

interface B2 {
    fun foo() { print("B2") }
    fun bar() { print("bar") }
}

class C2 : A2 {
    override fun bar() { println("bar") }
}

class D2 : A2, B2 {
    override fun foo() {
        super<A2>.foo()
        super<B2>.foo()
    }

    override fun bar() {
        super<B2>.bar()
    }
}