package lesson5;

public class Banker {
    public boolean requestDeposit(DepositRequest req){
        Account account = req.getDepositAccount();
        if(!account.isDepositable()) return false;
        Money money = req.getMoney();
        if(Banker.isMinimumLimit(money)) return false;
        return false;
    }
    public static final Money MINIMUM = new Money(Currency.WON, 100);
    private static boolean isMinimumLimit(Money money) {
        return money.getMoney(Currency.WON) < MINIMUM.getMoney(Currency.WON);
    }

}
