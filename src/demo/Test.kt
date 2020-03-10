package demo

import demo.concept.FlowControl
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
    concept1.literal()
    concept1.autoBoxing()
    concept1.casting()
    concept1.calculate()
    concept1.compare()

    val concept2 = FlowControl()
    concept2.ifStatement(1, 2)
    concept2.whenStatement(1)
    concept2.forLoop()
    concept2.whileLoop()
    concept2.breakAndContinue()


}


