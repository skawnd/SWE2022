package lesson5;

public class Competition {
    static public String compare(Comparable a, Comparable b){
        if (a.compareTo(b) == -1) return "a is winner";
        return "b is winner";
    }
}
