package mysql.operators.temp;

import mysql.operators.Operator;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:11
 */
public class Binary extends Operator {
    protected Binary() {
        super(Type.leftUnary, 16000);
    }
}
