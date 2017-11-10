package lesson8;

import java.util.ArrayList;

public class List {
    static private ArrayList<String> names = new ArrayList<>();

    private String name;
    public List(String name) throws Exception {
        if (names.contains(name)) throw new Exception();
        this.name = name;
        names.add(this.name);
    }
    // Unique mutable Setter.
    public void  setName(String name) throws Exception{
        if(name == this.name) return; // 같은지부터 확인.
        if (names.contains(name)) throw new Exception();
        names.remove(this.name);
        this.name = name;
        names.add(this.name);

    }
}
