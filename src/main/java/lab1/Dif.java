package lab1;

/**
 * Dif
 */
public class Dif implements Expression {

    Expression minuend;
    Expression subtrahend;

    public Dif(Expression minuend, Expression subtrahend) {
        this.minuend = minuend;
        this.subtrahend = subtrahend;
    }

    @Override
    public Money reduce(Exchanger exchanger, String to) {
        int amount = minuend.reduce(exchanger, to).amount - subtrahend.reduce(exchanger, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Dif(minuend.times(multiplier), subtrahend.times(multiplier));
    }

    @Override
    public Expression dif(Expression subtrahend) {
        return new Dif(this, subtrahend);
    }
}