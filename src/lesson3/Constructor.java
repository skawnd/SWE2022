package lesson3;

public class Constructor {

    private String firstName;
    private String lastName;

    public Constructor(){
        this("john", "doe");

    }

    public Constructor(String fname){
        this(fname, "m" );

    }

    public Constructor(String a, String b){
        firstName = a;
        lastName = b;

    }

    public String getName(){
        return firstName+" "+lastName;
    }
}
