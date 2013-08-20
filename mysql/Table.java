package mysql;

import design.Base;
import design.NamingStrategy;
import mysql.clauses.SelectExpressions;
import mysql.statements.Select;
import mysql.temp.SelectExpression;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:21
 */
public abstract class Table extends Base {
    protected Table() {
        super(NamingStrategy.uppercase);
    }

    public Select selectAll() {
        return select(SelectExpressions.ALL);
    }

    private Select select(SelectExpression... selectExpressions) {
        return new Select(selectExpressions).from(this);
    }
}
