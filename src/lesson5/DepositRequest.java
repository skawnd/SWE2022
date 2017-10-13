package lesson5;
/*
Request가 DepositRequest보다 더 유연하고 변화의 가능성이 많다(추상적) - super
추상적으로, 유연해질수록  upcast!
구체적으로, 딱딱해질수록 down cast!
추상 <--------------------------> 유연
Request --- DepositRequest ---- Deposit
 */

public interface DepositRequest extends Request {
    Account getDepositAccount(); //어느 계좌에 입금할 것인가?

}
