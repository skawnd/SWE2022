package com.skawndy.Todo;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


// 루트가 되는 클래스 App;
// App이 유저의 역할로 n개의 list를 소유한다.
// TodoList, 즉 목록은 정렬 순서가 따로 없음. 오늘 할 일과 To-Do라는 목록이 항상 위에 고정.
// 그 다음에는 만든 순서대로 정렬됨.

public class App implements Serializable {
    // 파이널 처리.
    private ArrayList<TodoList> Lists = new ArrayList<TodoList>();
    // 어플에서 사용할 수 있는 명령어를 정의. 한정시킴.
    private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
            "addList", "delList", "choiceList", "addTodo", "delTodo", "setComplete", "setHide",
            "sort", "choiceTask" )
    );
    private Path loading;

    public TodoList addList(String name){
        TodoList newList = new TodoList(name);
        this.Lists.add(newList);
        //this.showLists();
        return newList;
    }

    public void delList(String name){
        for (int j = 0; j < this.Lists.size(); j++){
            if (this.Lists.get(j).getName().equals(name)){
                this.Lists.remove(j);
            }
        }
        //this.showLists();
    }


    public void showLists() {
        ArrayList<TodoList> lists = this.Lists;
        if (lists.isEmpty()) {
            System.out.println("There is no list.");
        } else {
            for (TodoList i : lists) {
                System.out.println("- " + i.getName() + " " + i.getTasks().size());
            }
        }
    }
    /*
    public void OnTheApp(InputStream src){
        Scanner in = new Scanner(src).useDelimiter("\\n");
        exit:
        while(true){
            System.out.println("------------------------------------");
            System.out.println("You can choice option.");
            System.out.println("-addList -delList -choiceList -exit ");
            System.out.println("------------------------------------");
            this.showLists();
            in.reset();

            App:
            while(in.hasNext()){

                String c = in.next();
                if (!keys.contains(c) || "exit".equals(c)) break exit;

                // App에서 목록과 관련된 화면이라고 생각함.
                if ("addList".equals(c)){
                    System.out.println("what is the name of your creating list?");
                    String listname = in.next();
                    this.addList(listname);
                }
                if ("delList".equals(c)){
                    System.out.println("what is the name of your deleting list?");
                    String listname = in.next();
                    this.delList(listname);
                }

                if ("choiceList".equals(c)) {
                    System.out.println("what is your choosing list?");
                    String listname = in.next();
                    TodoList todolist = null;
                    for (TodoList n : this.Lists) {
                        if (n.getName().equals(listname)) {
                            todolist = n;
                        }
                    }

                    if (todolist == null) {
                        System.out.println("There isn't that list!");
                    } else {
                        System.out.println("---------------------------------------------------------");
                        System.out.println("You can choice option.");
                        System.out.println("-addTodo -delTodo -setComplete -setHide -choiceTask -out ");
                        System.out.println("---------------------------------------------------------");
                        todolist.showTasks();

                        // 목록을 선택해서 목록의 화면으로 이동한 상황.
                        Listpage:
                        while (in.hasNext()) {

                            String s = in.next();
                            if (!keys.contains(s) || "out".equals(s)) break Listpage;

                            if ("addTodo".equals(s)){
                                System.out.println("what is the name of your creating Todo?");
                                String todoname = in.next();
                                System.out.println("what is the year Deadline of your creating Todo?");
                                int todoYear = in.nextInt();
                                System.out.println("what is the month Deadline of your creating Todo?");
                                int todoMonth = in.nextInt();
                                System.out.println("what is the day Deadline of your creating Todo?");
                                int todoDay = in.nextInt();
                                System.out.println("Do you want to check the Alarm? : true/false");
                                boolean todoAlarm = in.nextBoolean();

                                todolist.addTodo(todoname,todoYear,todoMonth,todoDay,todoAlarm);
                            }
                            if ("delTodo".equals(s)){
                                System.out.println("what is the name of your deleting Todo?");
                                String todoname = in.next();
                                todolist.delTodo(todoname);
                            }
                            if ("setComplete".equals(s)){
                                System.out.println("which Todo, set the Complete?");
                                String todoname = in.next();
                                todolist.setComplete(todoname);
                            }
                            if ("setHide".equals(s)){
                                todolist.setHide();
                            }

                            /*
                            if ("choiceTask".equals(s)){
                                System.out.println("what is your choosing list?");
                                String taskname = in.nextLine();
                                todolist.choiceTask(taskname);
                            }



                            System.out.println("---------------------------------------------------------");
                            System.out.println("You can choice option.");
                            System.out.println("-addTodo -delTodo -setComplete -setHide -choiceTask -out ");
                            System.out.println("---------------------------------------------------------");
                            todolist.showTasks();
                        }
                    }
                }
                System.out.println("------------------------------------");
                System.out.println("You can choice option.");
                System.out.println("-addList -delList -choiceList -exit ");
                System.out.println("------------------------------------");
                this.showLists();
            }
        }
    }
    */

    public void onTheApp(InputStream src) throws IOException {
        Scanner in = new Scanner(src).useDelimiter("\\n");
        exit:
        while (true) {
            // 3차 실습 과제 1번 문제에 해당합니다.
            TodoList List1 = this.addList("집에서 할 일");
            TodoList List2 = this.addList("학교 숙제");

            List1.addTodo("만화 보기", 2017, 12, 9);
            List1.addTodo("커밋하기", 2017, 12, 11);
            List1.addTodo("자바 공부", 2017, 12, 8);

            List2.addTodo("과제1커밋하기", 2017, 11, 30, 2017, 11, 30, 12, 30);
            List2.addTodo("친구랑 약속", 2017, 12, 3);

            this.showLists();
            in.reset();
            System.out.println("< List page >");
            App:

            while (in.hasNext()) {
                // 3차 실습 과제 2번 문제에 해당합니다.

                String order = in.nextLine();
                if (order.equals("exit")){
                    break exit;
                }
                if (order.startsWith("addList:")) {
                    String name = order.substring(8, order.length());
                    this.addList(name);
                    this.showLists();
                }
                // 4차 실습 과제 1번 문제에 해당합니다.
                // save시 파일에 저장하고 앱을 종료합니다.
                if (order.equals("save")){
                    Path path = Paths.get("D:\\","App.txt");
                    OutputStream file;
                    if (!Files.exists(path)) {
                       file = Files.newOutputStream( Files.createFile(path) );
                    }else{
                        file = Files.newOutputStream(path);
                    }

                    try (ObjectOutputStream out = new ObjectOutputStream( file )){
                        out.writeObject(this.Lists);
                    }

                    break exit;
                }
                // 4차 실습 과제 2번 문제에 해당합니다.
                // load시 파일에서 객체를 불러옵니다.
                if (order.equals("load")){
                    Path path = Paths.get("D:\\","App.txt");

                    try {
                        ObjectInputStream In = new ObjectInputStream(Files.newInputStream(path));
                        this.Lists = (ArrayList<TodoList>) In.readObject();
                        this.showLists();
                    } catch (IOException ex) {
                        System.out.println("It's wrong path");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("wrong class");
                    }
                }
                // 3차 실습 과제 3번 문제에 해당합니다.
                if (order.startsWith("list:")) {
                    String name = order.substring(5, order.length());
                    TodoList todolist = null;
                    for (TodoList n : this.Lists) {
                        if (n.getName().equals(name)) {
                            todolist = n;
                        }
                    }

                    if (todolist == null) {
                        System.out.println("There isn't that list!");
                    } else {
                        todolist.showTasks();
                        System.out.println("< Task page >");

                        // 목록을 선택해서 목록의 화면으로 이동한 상황.
                        Listpage:

                        while (in.hasNext()) {

                            String order2 = in.nextLine();

                            if (order2.equals("out")){
                                break Listpage;
                            }
                            // 3차 실습 과제 4번 문제에 해당합니다.
                            if (order2.startsWith("addTodo:")){
                                String[] body = order2.substring(8, order2.length()).split(",");
                                if (body.length == 2){ //알람 시간이 없는 경우
                                    String taskname = body[0];
                                    int taskYear = Integer.parseInt(body[1].split("\\.")[0]);
                                    int taskMonth = Integer.parseInt(body[1].split("\\.")[1]);
                                    int taskDay = Integer.parseInt(body[1].split("\\.")[2]);

                                    todolist.addTodo(taskname,taskYear,taskMonth,taskDay);
                                }else{
                                    String taskname = body[0];
                                    int taskYear = Integer.parseInt(body[1].split("\\.")[0]);
                                    int taskMonth = Integer.parseInt(body[1].split("\\.")[1]);
                                    int taskDay = Integer.parseInt(body[1].split("\\.")[2]);
                                    String body2 = body[2];
                                    int alarmYear = Integer.parseInt(body2.split("\\.")[0]);
                                    int alarmMonth =  Integer.parseInt(body2.split("\\.")[1]);
                                    int alarmDay = Integer.parseInt(body2.split("\\.")[2].split(" ")[0]);
                                    int alarmHr = Integer.parseInt(body2.split("\\.")[2].split(" ")[1].split(":")[0]);
                                    int alarmMin = Integer.parseInt(body2.split("\\.")[2].split(" ")[1].split(":")[1]);

                                    todolist.addTodo(taskname,taskYear,taskMonth,taskDay, alarmYear, alarmMonth, alarmDay, alarmHr, alarmMin);

                                }
                                todolist.showTasks();
                            }
                            // 3차 실습 과제 5번 문제에 해당합니다.
                            if (order2.startsWith("complete:")){
                                String taskname = order2.substring(9,order2.length());
                                todolist.setComplete(taskname);
                                todolist.showTasks();
                            }
                            // 3차 실습 과제 6번 문제에 해당합니다.
                            if (order2.startsWith("incomplete:")){
                                String taskname = order2.substring(11,order2.length());
                                todolist.setComplete(taskname);
                                todolist.showTasks();
                            }
                            System.out.println("<Task page>");
                        }
                    }
                }
                System.out.println("< List page >");
            }

        }
    }
    public static void main(String[] arg) throws IOException {
        // 단순 확인용
        App Myapp = new App();
        Myapp.onTheApp(System.in);




        //Path absolute = Paths.get("D:\\");
        //Path tempFile = Files.createTempFile(absolute, "nj",".txt" );

        //InputStream in = Files.newInputStream(absolute);
        //String b = Integer.toString(in.read());
        //System.out.println(b);


    }
}
