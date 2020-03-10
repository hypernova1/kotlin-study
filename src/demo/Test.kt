package demo

import demo.concept.Type

fun main() {

    val idiom = Idiom()
    idiom.run()

    val warmingUp = WarmingUp()
    warmingUp.defineFunc() //함수 정의
    warmingUp.defineVal() //변수 선언
    warmingUp.stringTemplate() //문자열 템플릿
    warmingUp.conditionalExp() //조건식
    warmingUp.loop() //반복문
    warmingUp.ranges() //범위

    val concept1 = Type()
    concept.literal()
    concept.autoBoxing()
    concept.casting()
    concept.calculate()
    concept.compare()
}


