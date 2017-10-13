package lesson5;

public class Money {

    private final int quantity;
    private final Currency currency;

    private Money(){
        quantity = 0;
        currency = null;
    }  // 상수 전용 생성자, 자기 안에서만 쓰임

    public Money(Currency currency, int q){
        // 다른 외부의 사람들은 이 양식을 따라야 함.- 외부 생성자
        this.currency = currency;
        this.quantity = q;
    }

    public int getMoney(Currency currency) {
        return currency.changeMoney(this.currency, this.quantity);
    }
}

