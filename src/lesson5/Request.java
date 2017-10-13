package lesson5;

// 인터페이스를 먼저 정의해야 그것을 보고 송신자와 수신자를 정의할 수 있다.!!

public interface Request {
    Customer getCustomer();
    Money getMoney();

}
