package com.skawndy;

import java.time.LocalDate;
import java.util.ArrayList;

// 클래스와 메서드는 최대한 퍼블릭으로, 변수와 상수는 최대한 프라이빗으로 생성.
// 목록과 할 일, 그리고 테마의 관계는 내부클래스(이너클래스)로 한다 - 객체와 객체간의 관계가 중요!

public class TodoList {
    private String name; // 목록 이름은 변경 가능함.
    private ArrayList<TodoTask> Tasks;
    private ArrayList<TodoTask> Tasks2; // 지금 생각으로는 완료된 할 일을 숨길 때 아예 어래이에서 제거하는
                                        // 방식으로 하려고 하고 있음. 그래서 원본(Tasks2) 필요함.

    public class TodoTheme{
        //테마는 일단 그대로 둔다.
    }
    public class TodoTask{
        private String name; // 할 일의 이름도 변경 가능함
        private LocalDate toFinish; // LocalDate 클래스 참조함. 현재 날짜와 할 일이 완료되었는지 비교할 것.
        private String Memo;
        private boolean expired;

        public TodoTask(String name, int year, short month, short day, String memo ){
            this.name = name;
            this.toFinish = LocalDate.of(year, month, day);
            this.Memo = memo;
            this.expired = this.toFinish.isAfter(LocalDate.now()) ? true : false;
        }

        public String getName(){
            return this.name;
        }
        public LocalDate getToFinish(){
            return this.toFinish;
        }
        public String getMemo(){
            return this.Memo;
        }
        public boolean getExpired(){
            return this.expired;
        }
        public void setName(String newname){
            this.name = newname;
        }
        public void setMemo(String newmemo){
            this.Memo = newmemo;
        }
        public void setToFinish(int year, short month, short day){
            this.toFinish = LocalDate.of(year, month, day);
        }



    }

    public TodoTask enroll(String name, int year, short month, short day, String memo){
        TodoTask newTask = new TodoTask(name, year, month, day, memo);
        Tasks.add(newTask);
        Tasks2.add(new TodoTask(name, year, month, day, memo));
        return newTask;
    }

    public TodoList(String name){
        this.name = name;
    }

    public void setName(String newname){
        this.name = newname; // 목록 이름 바꾸기
    }

    public void isHide(boolean TF) {
        /*
        // TodoTask의 인스턴스.getExpired()를 이용할 것. - 완료된 할 일 숨기기
        if (TF == true) {
            for (int i = 0; i <= Tasks.size() - 1; i++) {
                if (Tasks.get(i).getExpired() == true) { // 완료된 할 일만 null로 대체함.
                    Tasks.set(i, null);
                }
            }
        } else {
            Tasks = (ArrayList<TodoTask>) Tasks2.clone();
        }
        */
    }

    public void sort(ArrayList<TodoTask> tasks){
        // 정렬 기능 - 어떤 순서가 있는지 아직 확인할 수 없음
        // 보통 이름순, 날짜순, 중요도순 정도로 생각.

    }
    public void setTheme(TodoTheme theme){
        // 테마 변경 기능
    }
    public static void delList(TodoList list){
        // 목록 객체 삭제 기능.
        list = null;
    }
    public void Link(){
        // 보내기 기능 - 파일 입,출력 관련.
    }

    public static void main(String[] arg){

    }
}
