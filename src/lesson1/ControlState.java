package lesson1;

import java.util.Random;

public class ControlState {
    public static void main(String[] args){
        int count = 5;
        int result = 0;
        if(count > 3){
            result = 10;
        }else{
            result = 5;
        }

        System.out.println("result if:"+ result);
        switch(count){
            case 0: result = 10; break;
            case 1: result = 20; break;
            case 5: result = 30; break;
            default: result = 50; break;
        }
        System.out.println("result switch: "+result);

        int a = 1;
        test:{
            System.out.println("line1");
            if(a==1) break test;
            System.out.println("line2");
        }
        System.out.println("line3");

        Random generator = new Random();
        int target = 100, sum = 0;
        count = 0;
        while(sum < target){
            sum = sum +generator.nextInt();
            count = count+1;
        }
        System.out.println("while:"+count+":"+sum);
        sum = 0;
        for(int i =1; i<10 ; i = i +1){
            int next = generator.nextInt(10);
            if(next == 5) break;
            sum = sum+next;
        }
        System.out.println("for:"+ sum);
        for(int i = 1; i<4; i = i+1){
            if(i%2 == 0) continue;
            System.out.println("i:"+i);
        }
        out:
        while(true){
            for(int i = 1; i<4 ; i = i+1){
                if(i==3) break out;
                System.out.println("double loop:"+i);
            }
        }
    }
}
