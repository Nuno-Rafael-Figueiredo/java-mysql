package design.patterns.state.mysql.operators.comparison;

import design.patterns.state.mysql.operators.Operator;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:23
 */
public class ComparisonOperator extends Operator {
    protected ComparisonOperator(String... signs) {
        super(Type.binary,7000, signs);
    }

    public ComparisonOperator(Type type, int precedence, String... signs) {
        super(type, precedence, signs);
    }
}
