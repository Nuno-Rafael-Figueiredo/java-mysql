package design.patterns.state.mysql.operators.temp;

import design.patterns.state.mysql.operators.Operator;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:11
 */
public class Interval extends Operator {
    protected Interval() {
        super(Type.leftBinary, 17000);
    }
}
