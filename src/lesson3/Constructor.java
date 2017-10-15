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
        this("john","doe");
    }

    public Constructor(String fname){
        this(fname, "doe");
    }

    public Constructor(String fname, String lname){
        this.firstName = fname;
        this.lastName = lname;
    }
    public String getName(){
        return firstName + seperator + lastName;
    }
    public String getFriend(int index){
        return friends.get(index);
    }

}
