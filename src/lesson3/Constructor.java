package lesson3;

import javax.sql.ConnectionPoolDataSource;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

public class Constructor {

    final String firstName;
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
        this(fname, "doe");
    }
    public Constructor(String firstName, String lname){
        this.firstName = firstName;
        this.lastName = lname;
    }
    static public int plus(int a, int b){
        return a+b;
    }
    public String getName(){
        int a = this.plus(3,5);
        int b = plus(6,7);
        int c = Constructor.plus(6,7);

        return this.firstName + this.seperator + this.lastName;
    }
    public String getFriend(int index){
        return this.friends.get(index) + " is " + this.getName() + "'s friend";
    }
}
