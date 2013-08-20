package mysql.clauses;

import mysql.Condition;
import mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:10
 */
public class Where<E extends Statement> extends ConditionalClause<E> {

    public Where(E statement) {
        super(statement);
    }

    public E where(Object left, Object right){
        add(Condition.EQUALS, left, right);

        return statement;
    }

}
