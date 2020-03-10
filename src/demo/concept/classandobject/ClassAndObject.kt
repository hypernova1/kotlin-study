package demo.concept.classandobject

/*
    클래스와 오브젝트
*/

/*
    클래스 생성
*/
class Invoice {}

// 몸체가 없으면 중괄호 생략 가능
class Empty

/*
    생성자
        - 코틀린의 클래스는 주요(primary) 새성자와 보조(secondary) 생성자를 가질 수 있음
            - 주요 생성자는 클래스 헫더의 한 부분으로 클래스 이름 뒤에 위치
*/
class Person constructor(name: String?)

// 주요 생성자에 애노테이션이나 가시성 수식어가 없으면 constructor 키워드 생략 가능
class Person2(name: String?)

// 주요 생성자는 코드를 포함할 수 없고 init 블록을 사용하여 초기화함
class Customer(name: String) {
    init {
        println("Customer initialized with value $name")
    }
}
class Customer2(name: String) { // 초기화 블록에서 주요 생성자의 파라미터 및 클래스 몸체에 선언한 프로퍼티 초기화에 사용가능
    val customerKey = name.toUpperCase()
}

class Person3(val firstName: String, val lastName: String, val age: Int) // 주요 생성자에서 프로퍼티를 선언하고 초기화



/*
    보조 생성자
        - 클래스 몸체에 constructor 키워드로 선언
*/
class Person4 {
    constructor(parent: Person4) {
    }
}

// 다른 생성자를 호출할 경우 this 키워드 사용
class Person5(val name: String) {
    constructor(name: String, parent: Person5) : this(name) {
    }
}

// 비추상 클래스에 어떤 생성자도 없으면 인자가 없는 주요 생성자를 만드는데 public 이 기본 가시성이므로 숨기고 싶을 때 privte 사용
class DonCreateMe private constructor() {}


class ClassAndObject {

    fun createInstance() {
        /*
            클래스의 인스턴스 생성
                - 자바와 다르게 new 키워드를 쓰지 않음
        */
        val invoice = Invoice()
        val customer = Customer("Sam")
    }
}