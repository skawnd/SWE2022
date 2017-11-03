package lesson7;

public class AbstractClassTest {

    static abstract class Person{
        private String name;
        // 부모 클래스에서 private으로 선언된 변수는 자식 클래스에서도 볼 수 없음.

        public Person(){this.name = "";};
        public Person(String name){this.name = name;}
        public final String getName(){return name;}

        // getName은 아무도 접근하지 못하는 private name을 보여주는 서비스 메서드. 이 의도로는 무조건 final을 붙여야 함.
        // 만약에 겟네임을 오버라이드하면 이 본래의 서비스의 의미를 훼손함. 따라서 final. 오버라이드 못 하게 함.


        public abstract int getId();
    }

    static class Student extends Person{
        private int id;
        public Student(String name, int id){
            //super(name);
            this.id = id;
        }
        @Override
        public int getId() {
            return 0;
        }
    }


    static public void main(String[] arg){
        Person p = new Person("hika"){

            @Override
            public int getId() {
                return 0;
            }
        };

    }
}
