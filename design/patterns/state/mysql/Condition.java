package design.patterns.state.mysql;

import design.Base;
import design.NamingStrategy;
import design.patterns.state.mysql.operators.comparison.*;
import design.patterns.state.mysql.operators.Operator;
import design.patterns.state.mysql.operators.comparison.Between;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:34
 */
public class Condition extends Base {
    public static final GreaterThan GREATER_THAN = new GreaterThan();
    public static final GreaterThanOrEquals GREATER_THAN_OR_EQUALS = new GreaterThanOrEquals();

    public static final Equals EQUALS = new Equals();
    public static final NotEquals NOT_EQUALS = new NotEquals();

    public static final LessThanOrEquals LESS_THAN_OR_EQUALS = new LessThanOrEquals();
    public static final LessThan LESS_THAN = new LessThan();

    public static final Between BETWEEN = new Between();
    public static final Like LIKE = new Like();
    public static final In IN = new In();

    private final Operator operator;
    private final Object[] operands;

    public Condition(Operator operator, Object... operands) {
        super(NamingStrategy.asIs);
        this.operator = operator;
        this.operands = operands;
    }

    @Override
    public String toString() {
        List<Object> list = new ArrayList<>();

        for (Object operand : operands)
            list.add(operand instanceof String ? "'" + operand + "'" : operand);

        return MessageFormat.format(operator.pattern, list.toArray());
    }
}
