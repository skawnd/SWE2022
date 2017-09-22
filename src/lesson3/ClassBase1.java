package lesson3;

public class ClassBase1 {
    static public void main(String[] arg){
        Constructor c = new Constructor();
        System.out.println(c.getName());
        Constructor c1 = new Constructor("kiwan");
        System.out.println(c1.getName());
        Constructor c2 = new Constructor("kiwan","mang");
        System.out.println(c2.getName());

    }
}
