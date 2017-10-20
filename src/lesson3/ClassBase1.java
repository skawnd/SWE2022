package lesson3;

public class ClassBase1 {
    static public void main(String[] arg){

        Constructor c = new Constructor();
        System.out.println(c.getName());
        System.out.println(c.getFriend(0));
        Constructor c1 = new Constructor("kiwan");
        System.out.println(c1.getName());
        System.out.println(c1.getFriend(0));
        Constructor c2 = new Constructor("kiwan","maeng");
        System.out.println(c2.getName());
        System.out.println(c2.getFriend(0));


        Noconst no = new Noconst();
        System.out.println(no.getFirstName(c2));

        System.out.println(Constructor.plus(3,5));
        //기본은 클래스이름, 정적메소드()
        System.out.println(c2.plus(5,5));
        //인스턴스에서도 정적메소드 호출이 된다.
    }
}
