package lesson7;

public interface IntSequence {
    int next();
   default  boolean hasnext(){return true;};
}
