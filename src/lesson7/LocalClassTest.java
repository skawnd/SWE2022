package lesson7;

import java.util.Random;

public class LocalClassTest {
    static public void main(String[] arg){
        IntSequence seq = randonInts(3, 5);
        System.out.println(seq.next());
        System.out.println(seq.next());
        System.out.println(seq.next());
    }
    private static Random generator = new Random();
    public static IntSequence randonInts(int low, int high){
        //랜덤 인트 메서드를 호출할 때마다 클래스가 생성됨.
        //메서드 호출될 때마다 자유변수가 캡쳐되어 final로 선언되는 방식.(사실상 최종 변수)
        return ()->low+generator.nextInt(high-low+1);
        // 람다가 관심 있는 것은 자유변수들. 복잡하지 않음; 많은 것을 고려하지 않음.

        /*
        자바의 반환값은 공변이라 오버라이드를 해도 문제가 없다
        변수 타입의 선언은 공변.
        제네릭은 무공변.
        함수의 인자가 반공변. - 리스코프 치환원칙.
        동적 디스패치 - 내적 일관성
         */
    }
}
