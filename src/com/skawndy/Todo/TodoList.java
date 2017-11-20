package com.skawndy.Todo;



// 객체 자체가 변경되지 않은 이상 일단 final을 붙여둘 것.- Todolist 어래이라던가, TodoTask 어래이 등등.
// 클래스와 메서드는 최대한 퍼블릭으로, 변수와 상수는 최대한 프라이빗으로 생성.
// 목록과 할 일, 그리고 테마의 관계는 내부클래스(이너클래스)로 한다 - 객체와 객체간의 관계가 중요!

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class TodoList {
    private String Name; // 목록 이름은 변경 가능함.
    //private ArrayList<TodoTask> Tasks = new ArrayList<TodoTask>();
    private final ArrayList<TodoTask> Origin_Tasks = new ArrayList<TodoTask>();
    private Date isMade; // 루트에서 정렬될 때는 무조건 만든 순서로 정렬됨.
    private boolean Hide = false; // List의 입장에서는 완료된 할 일 보이기/ 숨기기를 flag값인 Hide로 구분하겠음

    // Hide가 true이면 Tasks를 보여주고, Hide가 false이면 Origin_Tasks를 보여줌

    // 테마는 색은 5가지, 배경이미지는 6가지로 결정, 고정되어 있음. 따라서 그냥 불러오는 방식으로 설정.
    // TodoList, 즉 목록을 생성할 때 색과 이미지가 랜덤으로 배정되어 생성된다.
    public enum Color { BLUE, ORANGE, PURPLE, GREEN, SKY  }
    public enum Image { MOUNTAIN, CITY, BUS, AIRPLANE, HOUSE, NOTHING }
    Random generator = new Random(); // 테마를 랜덤 발생시키기 위해 정의.
    public class TodoTheme{
        private Color color;
        private Image image;

        public TodoTheme(){ //생성자 - 생성시 색과 배경이미지 랜덤 배정
            this.color = Color.values()[generator.nextInt(5)];
            this.image = Image.values()[generator.nextInt(5)];
        }

        public Color getColor(){
            return this.color;
        }
        public Image getImage(){
            return this.image;
        }
        public void setColor(String color){
            this.color = Color.valueOf(color);
        }
        public void setImage(String image){
            this.image = Image.valueOf(image);
        }
    }
    public class TodoTask{
        private String Name; // 할 일의 이름도 변경 가능함
        private Date Deadline; // 기한 설정 - Date 클래스 참조함. 현재 날짜와 할 일이 완료되었는지 비교할 것.
        private String Memo; // 노트 추가
        private boolean Finished = false; // 완료여부 - 체크하는 방식
        private boolean myToday = false; // 나의 하루에 추가 - 체크하는 방식
        private Date Alarm; // 미리 알림 - 나중에 시간까지 구체화.
        private Date Made;

        // 할 일 추가할 때 이름만 설정한 다음에 미리 알림, 기한 설정 등을 추가로 설정하는 방식
        // 따라서 생성자에서는 이름과 만든 날짜만 갖고, 나머지는 set메서드를 통해서 할 것.
        // 완료체크는 기한과 별개로 사용자가 그냥 버튼 하나로 체크하는 방식.

        public TodoTask(String name){
            this.Name = name;
            this.Made = new Date();
        }

        public String getName(){
            return this.Name;
        }
        public Date getDeadline(){
            return this.Deadline;
        }
        public String getMemo(){
            return this.Memo;
        }
        public boolean getFinished(){
            return this.Finished;
        }
        public boolean getmyToday(){
            return this.myToday;
        }
        public Date getAlarm(){
            return this.Alarm;
        }
        public boolean isAlarm(){ // 미리 알림 기능 : 알람 시간이 지나면 True를 반환하게 함
            if (Alarm == null){ return false; } // 쉴드 패턴.
            Date date = new Date(); // 현재 시간.
            return Alarm.compareTo(date) <= 0;
        }
        public Date getMade(){
            return this.Made;
        }

        public void setName(String newname){
            this.Name = newname;
        }
        public void setMemo(String newmemo){
            this.Memo = newmemo;
        }
        public void setDeadline(int year, short month, short day){
            this.Deadline = new Date(year, month, day);
        }
        public void setFinished(){
            this.Finished = !Finished;
        }
        public void setmyToday(){
            this.myToday = !myToday;
        }
        public void setAlarm(int year, short month, short day, short hr, short min){
            this.Alarm = new Date(year, month, day, hr, min);
        }
        public void pop(){
            //할 일 삭제 기능
            Origin_Tasks.remove(this);
        }

    }

    public TodoTask enroll(String name){
        TodoTask newTask = new TodoTask(name);
        //Tasks.add(newTask);
        Origin_Tasks.add(new TodoTask(name));
        return newTask;
    }



    public TodoList(String name){
        this.Name = name;
        TodoTheme theme = new TodoTheme(); // 목록 생성시 자동으로 테마는 랜덤 배정해서 생성.
        this.isMade = new Date();
    }

    public void setName(String newname){
        this.Name = newname; // 목록 이름 바꾸기
    }

    public ArrayList<TodoTask> getTasks(){
        if (Hide == true){ // 완료된 할 일 숨기기
            ArrayList<TodoTask> Tasks = new ArrayList<TodoTask>();
            for (TodoTask t : Origin_Tasks){
                if (t.getFinished() == true){Tasks.add(t);}
            }
            return Tasks;
        }else{ // 완료된 할 일 표시.
            return Origin_Tasks;
        }
    }

    public ArrayList<TodoTask> setHide(){
        // 앱에서 누르는 버튼의 의미.
        this.Hide = !Hide;
        return getTasks();
    }

    public void sort(int i){
        // 제목순, 기한순, 만든 날짜순, 완료됨, 나의 하루에 추가됨 5가지 방법이 있음.
        // 모드별로 비교자 클래스 정의.
        // 일단은 정말 어플처럼 버튼을 통해서 누르는 것처럼 작동하는 느낌으로 1번부터 5번까지의 모드를
        // 선택하는 방식으로 설계를 함. 그러므로 인자로 1부터 5까지의 숫자를 받고 그 외에는 아웃처리함.
        if (i<=0 | i>5){
            getTasks();
        }else{
            switch (i){
                case 1: // 제목순
                    Origin_Tasks.sort(new TodoComparator.Namecomparator());
                    getTasks();
                    break;
                case 2: // 기한순
                    Origin_Tasks.sort(new TodoComparator.DueComparator());
                    getTasks();
                    break;
                case 3: // 만든 날짜순
                    Origin_Tasks.sort(new TodoComparator.MadeComparator());
                    getTasks();
                    break;
                case 4: // 완료됨순
                    Origin_Tasks.sort(new TodoComparator.FinishedComparator());
                    getTasks();
                    break;
                case 5: // 나의 하루 순
                    Origin_Tasks.sort(new TodoComparator.myTodayComparator());
                    getTasks();
                    break;

                default: // 이름순이 디폴트.
                    Origin_Tasks.sort(new TodoComparator.Namecomparator());
                    getTasks();
                    break;
            }
        }
    }


    public static void delList(TodoList list){
        // 목록 객체 삭제 기능.
        list = null;
    }
    public void Link(){
        // 보내기 기능 - 파일 입,출력 관련.
    }
}
