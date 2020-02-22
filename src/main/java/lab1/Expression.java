package lab1;

/**
 * Expression
 */
public interface Expression {

    Money reduce(Exchanger Exchanger, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);

    Expression dif(Expression subtrahend);
}