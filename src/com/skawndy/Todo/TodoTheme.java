package com.skawndy.Todo;

import java.io.Serializable;
import java.util.Random;

public class TodoTheme implements Serializable{
    private Color color;
    private Image image;
    Random generator = new Random(); // 테마를 랜덤 발생시키기 위해 정의.

    // 테마는 색은 5가지, 배경이미지는 6가지로 결정, 고정되어 있음. 따라서 그냥 불러오는 방식으로 설정.
    // TodoList, 즉 목록을 생성할 때 색과 이미지가 랜덤으로 배정되어 생성된다.
    public enum Color { BLUE, ORANGE, PURPLE, GREEN, SKY  }
    public enum Image { MOUNTAIN, CITY, BUS, AIRPLANE, HOUSE, NOTHING }

    public TodoTheme(){
        //생성자 - 생성시 색과 배경이미지 랜덤 배정
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
