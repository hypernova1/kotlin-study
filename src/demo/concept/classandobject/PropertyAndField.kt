package demo.concept.classandobject

import java.lang.AssertionError

class PropertyAndField {

    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        result.street = address.street
        result.city = address.city
        result.state = address.state
        result.zip = address.zip
        return result
    }

}

/*
    프로퍼티 선언
*/
class Address {
    var name: String = ""
    var street: String = ""
    var city: String = ""
    var state: String? = ""
    var zip: String = ""
}

class GetterAndSetter {
    var allByDefaukt: Int? = null
    var initialized:Int = 0
        get() = 3

    val simple: Int? = 1 //val 키워드는 getter만 가짐
    val inferredType = 1

    var setterVisibility: String = "abc"
        private set
}

/*
    지원(Backing)필드
        - 코틀린 클래스는 필드를 가질 수 없음
        - 하지만 때때로 커스텀 접근자를 사용할 때 지원 필드가 필요할 때가 있음
        - 이런 목적으로 코틀린은 field 식별자로 접근할 수 있는 지원 필드를 자동으로 제공
*/
class BackingField {
    var counter = 0 //초기값을 지원 필드에 직접 씀
        set(value) {
            if (value >= 0) field = value // field 식별자는 오직 프로퍼티의 접근자에서만 사용 가능
        }

    val isEmpty: Boolean
        get() = false
}

/*
    지원 프로퍼티
        - 자동 지원 필드 방식이 맞지 않을 때 대신할 수 있음
*/
class BackingProperty {
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() //타입 파라미터 추론
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

}

/*
    컴파일 타임 상수
        - 컴파일 시점에 알아야 할 프로퍼티 값을 const 수식어를 이용해서 컴파일 타임 상수로 표시할 수 있음
        - 다음 조건을 충족해야함
            - 최상위 또는 오브젝트의 멤버
            - String이나 기본 타입 값을 초기화
            - 커스텀 getter가 아님
*/
// 애노테이션에 사용 가능
const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"
@Deprecated(SUBSYSTEM_DEPRECATED) fun foo() {}


/*
    초기화 지연(Late-Initialized) 프로퍼티
        - 보통 null이 아닌 타입으로 선언한 프로퍼티는 생성자에서 초기화 해야함
        - 하지만 이게 편리하지 않을 때(의존 주입이나 단위테스트 셋업 메서드 등) 생성자에 null이 아닌 초기값을 제공할 수 없지만 null 검사를 피하고 싶을 때
        - 프로퍼티에 lateinit 수식어를 붙임

    적용 가능한 경우 (3가지 조건을 모두 충족)
        - 클래스 몸체에 정의된 var 프로퍼티가 커스텀 getter나 setter가 없는 경우에
        - 프로퍼티 타입은 null 불가
        - 기본 타입이면 안 됨

*/
public class MyTest {
    lateinit var subject: TestSubject
}

class TestSubject