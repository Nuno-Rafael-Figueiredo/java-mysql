package mysql.statements;

import mysql.operators.Operator;
import mysql.Table;
import mysql.clauses.*;
import mysql.temp.SelectExpression;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:04
 */
public class Select extends Statement<Select> {
    private final From from;
    private final Where<Select> where;
    private final GroupBy groupBy;
    private final Having having;
    private final OrderBy orderBy;
    private final Limit limit;

    public Select(SelectExpression... selectExpressions) {
        new SelectExpressions(this, selectExpressions);
        from = new From(this);
        where = new Where<>(this);
        groupBy = new GroupBy(this);
        having = new Having(this);
        orderBy = new OrderBy(this);
        limit = new Limit(this);
    }

    public Select where(Operator operator, Object... arguments){
        return where.add(operator, arguments);
    }

    public Select from(Table table) {
        return from.add(table);
    }

    public Select where(Object left, Object right) {
        return where.where(left, right);
    }

    public Select having(Object left, Object right) {
        return having.having(left, right);
    }

    public Select groupBy(Integer... columns) {
        return groupBy.add(columns);
    }

    public Select limit(int offset, int rowCount){
        return limit.set(offset, rowCount);
    }

    public Select orderBy(Integer... columns) {
        return orderBy.add(columns);
    }
}
