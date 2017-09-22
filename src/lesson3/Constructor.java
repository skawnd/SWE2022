package lesson3;

import java.util.ArrayList;

public class Constructor {

    final String firstName; // 접근제한자를 안 붙이면 같은 패키지 안에서 다 볼 수 있음
    private final String lastName;
    private String seperator;
    private ArrayList<String> friends;

    {
        seperator = " ";
    }
    {
        friends = new ArrayList<>();
        friends.add("mike");
        friends.add("jane");
    }
    public Constructor(){
        this("john", "doe");

    }

    public Constructor(String fname){
        this(fname, "m" );

    }

    public Constructor(String fname, String lname){
        firstName = fname;
        lastName = lname;

    }

    public String getName(){
        return firstName+" "+lastName;
    }

    public String getName(String a){
        return a;
    }

    public String getFriend(int index){
        return friends.get(index);
    }

}
