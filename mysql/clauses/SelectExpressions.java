package mysql.clauses;

import design.Utils;
import mysql.statements.Select;
import mysql.temp.ISelectExpression;
import mysql.temp.SelectExpression;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 21:34
 */
public class SelectExpressions extends Clause<Select> {
    public static final SelectExpression ALL = new SelectExpression("*");
    private final ArrayList<ISelectExpression> expressions;

    public SelectExpressions(Select statement, ISelectExpression... expressions) {
        super(statement);
        this.expressions = new ArrayList<>(Arrays.asList(expressions));
        if (expressions.length > 0)
            setUsed();
    }

    @Override
    public String toString() {
        return Utils.join(expressions, ", ");
    }
}
