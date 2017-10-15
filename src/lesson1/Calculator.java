package lesson1;

import java.io.InputStream;
import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Calculator {

    static class Expression{
        static private Map<String, BiFunction<Integer, Integer, Integer>> op = new HashMap<>();
        static {
            /*
            op.put("+", (1, r) -> 1 + r);
            op.put("-", (1, r) -> 1 - r);
            op.put("*", (1, r) -> 1 * r);
            op.put("/", (1, r) -> 1 / r);
            */
        }

        public Expression(){}
        public String calc(List<String> que){
            final List<String> ex = new ArrayList<>();
            Scanner scanner = new Scanner(
                    String.join("", que.toArray(new String[0]))
                    .replaceAll("([+*/\\-])", " $1 ")
            );
            while (scanner.hasNext()) ex.add(scanner.next());
            Stream.of("[*/],[+\\-]".split(",")).forEach(rex -> {
                int i = 0;
                while(i < ex.size()){
                    String c = ex.get(i);
                    if (c.matches(rex)) {
                        int ret = op.get(c).apply(
                                Integer.parseInt(ex.get(i - 1)),
                                Integer.parseInt(ex.get(i + 1))
                        );
                        ex.set(i - 1, Integer.toString(ret));
                        ex.remove(i);
                        ex.remove(i);
                        i--;
                    }
                    i++;
                }
            });
            return ex.get(0);
        }
    }

    static class Panel{
        private ArrayList<String> que = new ArrayList<>();
        private Expression ex;

        public Panel(Expression ex){this.ex = ex;}
        public void add(String v){
            que.add(v);
            render();
        }
        public void result(){
            String result = ex.calc(que);
            que.clear();
            add(result);
        }
        public void clear(){
            que.clear();
            render();
        }
        public void render(){
            System.out.println(String.join("", que.toArray(new String[0])));
        }
    }

    static abstract class KeyPad{
        protected Panel panel;
        protected String label;

        public KeyPad(Panel p, String l){
            panel = p;
            label = l;
        }
        abstract public void click();
    }

    static class InputKey extends KeyPad{
        public InputKey(Panel panel, String label){
            super(panel, label);
        }
        @Override
        public void click(){
            panel.add(label);
        }
    }

    static class ResultKey extends KeyPad{
        public ResultKey(Panel panel, String label ){
            super(panel, label);
        }
        @Override
        public void click(){
            panel.result();
        }
    }

    static class ClearKey extends KeyPad{
        public ClearKey(Panel panel, String label ){
            super(panel, label);
        }
        @Override
        public void click(){
            panel.clear();
        }
    }
    public static void main(String[] a){
        new Calculator().on(System.in);
    }
    private Panel panel = new Panel(new Expression());
    private Map<String, KeyPad > keys = new HashMap<>();

    public Calculator(){
        Stream.of("0123456789+-/*".split("")).forEach(
                s -> keys.put(s, new InputKey(panel,s))
        );
        keys.put("=", new ResultKey(panel,"="));
        keys.put("c", new ClearKey(panel,"c"));
    }
    public void on(InputStream src){
        Scanner in = new Scanner(src).useDelimiter("\\s*");
        exit:
        while(true){
            in.reset();
            while(in.hasNext()){
                String c = in.next();
                if (!keys.containsKey(c) || "exit".equals(c)) break exit;
                keys.get(c).click();
                //System.out.println(c);
            }
        }
    }
}

