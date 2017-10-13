package lesson5;

public interface DepositRequest extends Request {
    Account getDepositAccount(); //어느 계좌에 입금할 것인가?
}
