package lesson1;

public class StringUnicode {
    public static void main(String[] args){
        String target = "Java";
        System.out.println("Hello "+target);
        int ver = 9;
        System.out.println(target+ver);
        System.out.println("["+String.join("],[","java","c++","python")+"]");

        StringBuilder builder = new StringBuilder();
        while(ver-->0) builder.append(ver+" ");
        System.out.println("reverse "+ builder.toString());

        System.out.println("java".equalsIgnoreCase(target));

        int n = 42;
        System.out.println("int"+Integer.parseInt(Integer.toString(n)));
        System.out.println("bin"+Integer.toString(n,2));
        System.out.println("bin"+Integer.parseInt(Integer.toString(n,2),2));

        System.out.println("Hello, Java".startsWith("Hello"));
        System.out.println("Hello, Java".endsWith("Java"));
        System.out.println("Hello, Java".contains("llo, J"));

        System.out.println("Hello, Java".indexOf("Java"));
        System.out.println("Hello, Java".replace("Java", "Python"));

        String unicode = "안녕\uD83E\uDC1D";
        System.out.println(unicode);
        System.out.println(unicode.length());
        System.out.println(unicode.charAt(2));
        System.out.println(unicode.codePointCount(0, unicode.length()));
        System.out.println(unicode.codePointAt(2));
        System.out.println(Character.toChars(unicode.codePointAt(2)));

    }
}
