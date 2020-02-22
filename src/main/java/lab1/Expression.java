package lab1;

/**
 * Expression
 */
public interface Expression {

    Money reduce(Exchanger Exchanger, String to);

    Expression plus(Expression addend);

    Expression multiplication(int multiplier);

    Expression division(int divider);

    Expression dif(Expression subtrahend);
}