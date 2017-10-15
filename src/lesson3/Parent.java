package lesson3;

public class Parent {

    private String name = "";

    public String mutator(String v){
        name = name + v;
        return name;
    }

    public String getName(){
        return name;
    }

    public String action(){
        return "parent";
    }
}
