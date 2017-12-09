package com.skawndy.Todo;



// 객체 자체가 변경되지 않은 이상 일단 final을 붙여둘 것.- Todolist 어래이라던가, TodoTask 어래이 등등.
// 클래스와 메서드는 최대한 퍼블릭으로, 변수와 상수는 최대한 프라이빗으로 생성.
// 목록과 할 일, 그리고 테마의 관계는 내부클래스(이너클래스)로 한다 - 객체와 객체간의 관계가 중요!

import lesson1.Array;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TodoList {
    private TodoTheme theme;
    private String Name; // 목록 이름은 변경 가능함.
    private ArrayList<TodoTask> Tasks = new ArrayList<TodoTask>();
    private final Date Made; // 루트에서 정렬될 때는 무조건 만든 순서로 정렬됨.
    private boolean Hide = false; // List의 입장에서는 완료된 할 일 보이기/ 숨기기를 flag값인 Hide로 구분하겠음

    // Hide가 true이면 Tasks를 보여주고, Hide가 false이면 Origin_Tasks를 보여줌

    public TodoTask addTodo(String name, int... values) {
        if (values.length == 3) {
            int year = values[0];
            int month = values[1];
            int day = values[2];

            TodoTask newTask = new TodoTask(name, year, month, day);

            Tasks.add(newTask);
            //this.showTasks();
            return newTask;
        }else{
        //if (values.length == 8) {

            int year = values[0];
            int month = values[1];
            int day = values[2];
            int alarmYear = values[3];
            int alarmMonth = values[4];
            int alarmDay = values[5];
            int alarmHr = values[6];
            int alarmMin = values[7];

            TodoTask newTask = new TodoTask(name, year, month, day);
            newTask.setAlarm(alarmYear,alarmMonth,alarmDay,alarmHr,alarmMin);
            Tasks.add(newTask);
            //this.showTasks();
            return newTask;
        }
    }

    public void showTasks() {
        if (this.getOriginTasks().isEmpty()) {
            System.out.println("There is no Task.");
        } else {
            for (TodoTask i : this.getTasks()) {
                System.out.println("- "
                        + "[" + i.getFinished2() + "] "
                        + i.getName() + " " + i.getDeadline().getYear() + " " +
                        i.getDeadline().getMonthValue() + " " +
                        i.getDeadline().getDayOfMonth()  + i.getAlarm2());
            }
        }
    }
    public void choiceTask(String taskname){

        TodoTask todotask = null;
        for (TodoTask n : this.getOriginTasks()) {
            if (n.getName().equals(taskname)) {
                todotask = n;
            }
        }

        if (todotask == null) {
            System.out.println("There isn't that task!");
        } else {
            System.out.println("- "
            + "[" + todotask.getFinished2() + "] "
            + todotask.getName() + " " + todotask.getDeadline().getYear() + " " +
            todotask.getDeadline().getMonthValue() + " " +
            todotask.getDeadline().getDayOfMonth() + " " + todotask.getAlarm().getYear()
            + " " + todotask.getAlarm().getMonthValue() + " " + todotask.getAlarm().getDayOfMonth() +
            " " + todotask.getAlarm().getHour() + " " + todotask.getAlarm().getMinute());
        }

    }
    public void delTodo(String name){
        for (int j = 0; j < this.Tasks.size(); j++){
            if (this.Tasks.get(j).getName().equals(name)){
                this.Tasks.remove(j);
            }
        }
        //this.showTasks();
    }


    public TodoList(String name){
        this.Name = name;
        this.theme = new TodoTheme(); // 목록 생성시 자동으로 테마는 랜덤 배정해서 생성.
        this.Made = new Date(); // 목록 생성 시간
    }
    public String getName(){
        return this.Name;
    }
    public void setName(String newname){
        this.Name = newname; // 목록 이름 바꾸기
    }
    public TodoTheme getTheme(){
        return this.theme;
    }
    public Date getIsMade(){
        return this.Made;
    }

    public ArrayList<TodoTask> getOriginTasks(){
        // 완료된 할 일은 다시 해제할 수 있으므로 전체 목록을 얻어올 수 있어야 함.
        return this.Tasks;
    }
    public ArrayList<TodoTask> getTasks(){
        // 숨기기 옵션에 따른 목록 가져오기 기능.
        if (Hide == true){ // 완료된 할 일 숨기기
            ArrayList<TodoTask> tasks = new ArrayList<TodoTask>();
            for (TodoTask t : this.Tasks){
                if (t.getFinished() == false){tasks.add(t);}
            }
            return tasks;
        }else{ // 완료된 할 일 표시.
            return this.Tasks;
        }
    }

    public void setComplete(String s){
        // 핸드폰에서 완료 여부를 체크하는 것은 버튼을 눌렀다 뗏다 하는 방식의 체크 형식.
        // 따라서 따로 incomplete 메서드는 만들 필요 없음.
        // setComplete를 호출하여 변경하는 방식을 따름.
        for (TodoTask t : this.getOriginTasks()){
            if (t.getName().equals(s)){
                t.setFinished();
            }
        }
        //this.showTasks();
    }

    public void setHide(){
        // 앱에서 누르는 버튼의 의미.
        this.Hide = !Hide;
        //this.showTasks(); // 버튼을 누르면 다른 결과가 나온다.
    }

    public void sort(int i){
        // 제목순, 기한순, 만든 날짜순, 완료됨, 나의 하루에 추가됨 5가지 방법이 있음.
        // 모드별로 비교자 클래스 정의.
        // 일단은 정말 어플처럼 버튼을 통해서 누르는 것처럼 작동하는 느낌으로 1번부터 5번까지의 모드를
        // 선택하는 방식으로 설계를 함. 그러므로 인자로 1부터 5까지의 숫자를 받고 그 외에는 아웃처리함.
        if (i<=0 | i>5){ // 이 경우 스마트폰에서 해당 버튼 외에 다른 배경이라던지 바깥 부분을 눌러서 종료된 상황을 표현. 즉 변화 없음.
            getTasks();
        }else{
            switch (i){
                case 1: // 제목순
                    Tasks.sort(new TodoComparator.Namecomparator());
                    getTasks();
                    break;
                case 2: // 기한순
                    Tasks.sort(new TodoComparator.DueComparator());
                    getTasks();
                    break;
                case 3: // 만든 날짜순
                    Tasks.sort(new TodoComparator.MadeComparator());
                    getTasks();
                    break;
                case 4: // 완료됨순
                    Tasks.sort(new TodoComparator.FinishedComparator());
                    getTasks();
                    break;
                case 5: // 나의 하루 순
                    Tasks.sort(new TodoComparator.myTodayComparator());
                    getTasks();
                    break;

                default: // 만들어진 시간 순이 디폴트.
                    Tasks.sort(new TodoComparator.MadeComparator());
                    getTasks();
                    break;
            }
        }
    }

    public void Link(){
        // 보내기 기능 - 파일 입,출력 관련.
    }
}
