package com.skawndy.Todo;

import java.util.Comparator;

// 정렬 기능을 위한 비교자 정의를 담은 클래스
public class TodoComparator{

    public static class Namecomparator implements Comparator<TodoTask>{
        // 제목순 비교자
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    Namecomparator namecomparator = new Namecomparator();

    public static class DueComparator implements Comparator<TodoTask>{
        // 기한순 비교자
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getDeadline().compareTo(o2.getDeadline());
        }
    }

    public static class MadeComparator implements Comparator<TodoTask>{
        // 만든 날짜순 비교자
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            return o1.getMade().compareTo(o2.getMade());
        }
    }

    public static class FinishedComparator implements Comparator<TodoTask>{
        // 완료됨 순 비교자
        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            if (o1.getFinished()==o2.getFinished()){
                // 완료여부가 같을을 때에 만들어진 순으로 정렬
                return o1.getMade().compareTo(o2.getMade());
            }else{
                // 완료 여부가 다를 때에는 true가 앞으로 가게 해야하는데
                // 효과적인 방법이 떠오르지 않아서 보기 굉장히 좋지 않지만
                // 여러개의 분기로 처리했습니다.
                if (o1.getFinished() == true & o2.getFinished() == false){
                    return -1;
                }else{
                    // 남은 경우의 수는 o2가 true이고 o1이 false인 경우밖에 없으므로 단순 else 처리.
                    return 1;
                }
            }
        }
    }

    public static class myTodayComparator implements Comparator<TodoTask>{

        @Override
        public int compare(TodoTask o1, TodoTask o2) {
            if (o1.getmyToday()==o2.getmyToday()){
                // 완료여부가 같을을 때에 만들어진 순으로 정렬
                return o1.getMade().compareTo(o2.getMade());
            }else{
                // 완료 여부가 다를 때에는 true가 앞으로 가게 해야하는데
                // 효과적인 방법이 떠오르지 않아서 보기 굉장히 좋지 않지만
                // 여러개의 분기로 처리했습니다.
                if (o1.getmyToday() == true & o2.getmyToday() == false){
                    return -1;
                }else{
                    // 남은 경우의 수는 o2가 true이고 o1이 false인 경우밖에 없으므로 단순 else 처리.
                    return 1;
                }
            }
        }
    }



}
