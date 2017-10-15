package lesson3;

public class ClassBase0 {
    static public void main(String[] arg){
        Parent parent = new Child(); //대체가능성

        System.out.println( parent.action() ); //내적 일관성

        parent.mutator( "abc");
        System.out.println(parent.getName());
        parent.mutator("123");
        System.out.println(parent.getName());
        System.out.println(parent.getName());
        System.out.println(parent.getName());


        String a = "abcd";
        System.out.println(a.length());


        /*
        String b = null ;
        System.out.println(b.length());
        */

        a = null;


    }
}
