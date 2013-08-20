package design.patterns.state.mysql.clauses;

import design.Utils;
import design.patterns.state.mysql.Condition;
import design.patterns.state.mysql.operators.Operator;
import design.patterns.state.mysql.statements.Statement;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Nuno
 * Date: 05-08-2013
 * Time: 0:36
 */
public abstract class ConditionalClause<E extends Statement> extends Clause<E> {
    private final List<Condition> conditions = new ArrayList<>();

    ConditionalClause(E statement) {
        super(statement);
    }

    public E add(Operator operator, Object... arguments) {
        setUsed();
        return add(new Condition(operator, arguments));
    }

    private E add(Condition condition) {
        conditions.add(condition);
        return statement;
    }

    @Override
    public String toString() {
        return super.toString() + " " + Utils.join(conditions, " AND ");
    }
}
