package demo.concept.extensions

/*
    확장
        - 클래스의 상속이나 데코레이터 같은 설계 패턴 없이 클래스에 새로운 기능을 확장할 수 있는 기능
        - 확장 함수, 확장 프로퍼티
*/

/*
    확장 함수
        - 확장 함수를 선언하려면 리시버 타입의 이름을 접두어로 가져야함
            - 리시버 타입: 확장할 타입의 이름
*/
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val tmp = this[index1] //this는 List에 대응
    this[index1] = this[index2]
    this[index2] = tmp
}

// 제네락으로 만들기
fun <T> MutableList<T>.swap2(index1: Int, index2: Int) {
    val tmp = this[index1] //this는 List에 대응
    this[index1] = this[index2]
    this[index2] = tmp
}



fun run() {
    val l = mutableListOf(1, 2, 3)
    l.swap(0,2) // swap()에서 this는 l의 값을 가짐
}

