package lab1;

/**
 * Sum
 */
public class Sum implements Expression {

    Expression augend;
    Expression addend;

    public Sum(Expression augend, Expression addend) {
        this.augend = augend;
        this.addend = addend;
    }

    @Override
    public Money reduce(Exchanger exchanger, String to) {
        int amount = augend.reduce(exchanger, to).amount + addend.reduce(exchanger, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public Expression multiplication(int multiplier) {
        return new Sum(augend.multiplication(multiplier), addend.multiplication(multiplier));
    }

    @Override
    public Expression division(int divider) {
        return new Sum(augend.division(divider), addend.division(divider));
    }

    @Override
    public Expression dif(Expression subtrahend) {
        return new Dif(this, subtrahend);
    }
}