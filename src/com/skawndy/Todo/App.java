package com.skawndy.Todo;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


// 루트가 되는 클래스 App;
// App이 유저의 역할로 n개의 list를 소유한다.
// TodoList, 즉 목록은 정렬 순서가 따로 없음. 오늘 할 일과 To-Do라는 목록이 항상 위에 고정.
// 그 다음에는 만든 순서대로 정렬됨.

public class App {
    // 파이널 처리.
    private ArrayList<TodoList> Lists = new ArrayList<TodoList>();
    // 어플에서 사용할 수 있는 명령어를 정의. 한정시킴.
    private final ArrayList<String> keys = new ArrayList<>(Arrays.asList(
            "addList", "delList", "choiceList", "addTodo", "delTodo", "setComplete", "setHide",
            "sort", "choiceTask" )
    );




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
                            */


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

    public static void main(String[] arg){
        // 단순 확인용
        App Myapp = new App();

        Myapp.OnTheApp(System.in);



    }
}
