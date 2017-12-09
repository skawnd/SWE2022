package com.skawndy.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TodoTask {
    private String Name; // 할 일의 이름도 변경 가능함
    private LocalDate Deadline; // 기한 설정 - Date 클래스 참조함. 현재 날짜와 할 일이 완료되었는지 비교할 것.
    private String Memo; // 노트 추가
    private boolean Finished = false; // 완료여부 - 체크하는 방식
    private boolean myToday = false; // 나의 하루에 추가 - 체크하는 방식
    private LocalDateTime Alarm; // 미리 알림 - 나중에 시간까지 구체화.
    private final Date Made; // 만들어진 시간 - 정렬 default.

    // 할 일 추가할 때 이름만 설정한 다음에 미리 알림, 기한 설정 등을 추가로 설정하는 방식
    // 따라서 생성자에서는 이름과 만든 날짜만 갖고, 나머지는 set메서드를 통해서 할 것.
    // 완료체크는 기한과 별개로 사용자가 그냥 버튼 하나로 체크하는 방식.

    public TodoTask(String name, int year, int month, int day){
        this.Name = name;
        this.Made = new Date();
        this.Deadline = LocalDate.of(year, month, day);
    }

    public String getName(){
        return this.Name;
    }
    public LocalDate getDeadline(){
        return this.Deadline;
    }
    public String getMemo(){
        return this.Memo;
    }
    public String getFinished2(){
        // 실습 과제 3을 위해서 출력용 메서드
        if (this.Finished == true){
            return "O";
        }else{
            return "X";
        }
    }
    public boolean getFinished(){
        return this.Finished;
    }
    public boolean getmyToday(){
        return this.myToday;
    }
    public LocalDateTime getAlarm(){
        return this.Alarm;
    }
    public String getAlarm2(){
        // 실습 과제 3의 "알림" 표시용 메서드.
        if (this.getAlarm() instanceof LocalDateTime){
            return ", 알림";
        }
            return "";
    }
    public Date getMade(){
        return this.Made;
    }
    public boolean isAlarm(){ // 미리 알림 기능 : 알람 시간이 지나면 True를 반환하게 함
        if (Alarm == null){ return false; } // 쉴드 패턴.
        LocalDateTime date = LocalDateTime.now(); // 현재 시간.
        return Alarm.compareTo(date) <= 0;
    }

    public void setName(String newname){
        this.Name = newname;
    }
    public void setMemo(String newmemo){
        this.Memo = newmemo;
    }
    public void setDeadline(int year, int month, int day){
        this.Deadline = LocalDate.of(year, month, day);
    }
    public void setFinished(){
        this.Finished = !Finished;
    }
    public void setmyToday(){
        this.myToday = !myToday;
    }
    public void setAlarm(int year, int month, int day, int hr, int min){
        this.Alarm = LocalDate.of(year, month, day).atTime(hr, min);
    }

}
