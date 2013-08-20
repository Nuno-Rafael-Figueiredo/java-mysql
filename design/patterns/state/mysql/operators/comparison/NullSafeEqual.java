package design.patterns.state.mysql.operators.comparison;

/**
 * User: Nuno
 * Date: 20-08-2013
 * Time: 14:33
 */
public class NullSafeEqual extends ComparisonOperator {
    public NullSafeEqual(){
        super("<=>");
    }
}
