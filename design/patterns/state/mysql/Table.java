package design.patterns.state.mysql;

import design.Base;
import design.NamingStrategy;
import design.patterns.state.mysql.clauses.SelectExpressions;
import design.patterns.state.mysql.statements.Select;
import design.patterns.state.mysql.temp.SelectExpression;

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
