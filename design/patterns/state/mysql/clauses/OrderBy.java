package design.patterns.state.mysql.clauses;

import design.patterns.state.mysql.statements.Select;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 19:50
 */
public class OrderBy extends ColumnListClause<Select> {
    public OrderBy(Select statement) {
        super(statement);
    }
}
