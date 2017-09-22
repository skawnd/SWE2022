package lesson3;

import java.util.ArrayList;

public class Constructor {

    private String firstName;
    private String lastName;
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
    public String getFriend(int index){
        return friends.get(index);
    }
}
