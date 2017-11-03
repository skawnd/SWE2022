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
        class RandomSequence implements IntSequence{

            @Override
            public int next() {
                return low+generator.nextInt(high-low+1);
            }
        }
        return new RandomSequence();
    }
}
