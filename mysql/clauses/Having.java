package mysql.clauses;

import mysql.Condition;
import mysql.statements.Select;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:48
 */
public class Having extends ConditionalClause<Select> {
    public Having(Select statement) {
        super(statement);
    }

    public Select having(Object left, Object right) {
        add(Condition.EQUALS, left, right);

        return statement;
    }
}
