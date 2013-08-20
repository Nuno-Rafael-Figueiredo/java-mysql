package design.patterns.state.mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:43
 */
public class NotEquals extends ComparisonOperator {
    public NotEquals() {
        super("<>", "!=");
    }
}
