package lab1;

import java.util.Hashtable;

/**
 * Exchanger
 */
public class Exchanger {
    private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();

    Money reduce(Expression source, String to) {
        return source.reduce(this, to);
    }

    public int rate(String from, String to) {
        if (from.equals(to))
            return 1;
        Integer rate = (Integer) rates.get(new Pair(from, to));
        return rate.intValue();
    }

    public void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }
}