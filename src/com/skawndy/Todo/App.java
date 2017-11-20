package com.skawndy.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

// 루트가 되는 클래스 App;
// App이 유저의 역할로 n개의 list를 소유한다.
// TodoList, 즉 목록은 정렬 순서가 따로 없음. 오늘 할 일과 To-Do라는 목록이 항상 위에 고정.
// 그 다음에는 만든 순서대로 정렬됨.

public class App {
    // 파이널 처리.
    private final ArrayList<TodoList>  Lists = new ArrayList<TodoList>();

    public TodoList enroll(String name){
        TodoList newList = new TodoList(name);
        Lists.add(newList);
        return newList;
    }
    public ArrayList<TodoList> getList(){
        return Lists;
    }

    public static void main(String[] arg){
        // 단순 확인용
        TodoList List = new TodoList("test");
        List.enroll("todo");
        Date date1 = new Date(1993, 6, 13, 05, 24);
        Date date2 = new Date(1993, 6, 13, 06, 17);

        System.out.println(date1.compareTo(date2) <= 0 );
        System.out.println(date1.compareTo(date2));
        System.out.println(true&true);
        System.out.println(false&false);
        System.out.println(false&true);
        ArrayList<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.removeIf(e -> e.compareTo("c") > 0);
        System.out.println(a.get(0)+a.get(1)+a.get(2));
    }
}
