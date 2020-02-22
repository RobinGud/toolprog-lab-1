package lab1;

import java.lang.Math;

/**
 * Money
 */
public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    static Money ruble(int amount) {
        return new Money(amount, "RUB");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }

    public boolean greater(Money money) {
        return amount > money.amount && currency().equals(money.currency());
    }

    public boolean less(Money money) {
        return amount < money.amount && currency().equals(money.currency());
    }

    public Expression multiplication(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public Expression division(int divider) {
        return new Money((int) Math.ceil(amount / divider), currency);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression dif(Expression subtrahend) {
        return new Dif(this, subtrahend);
    }

    public String currency() {
        return currency;
    }

    public Money reduce(Exchanger Exchanger, String to) {
        int rate = Exchanger.rate(currency, to);
        return new Money(amount / rate, to);
    }

    public String toString() {
        return amount + " " + currency;
    }

}