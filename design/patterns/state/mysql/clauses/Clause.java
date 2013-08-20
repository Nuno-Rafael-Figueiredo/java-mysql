package design.patterns.state.mysql.clauses;

import design.Base;
import design.NamingStrategy;
import design.patterns.state.mysql.statements.Statement;

/**
 * User: Nuno
 * Date: 04-08-2013
 * Time: 18:08
 */
public abstract class Clause<E extends Statement> extends Base {
    protected final E statement;
    private boolean used = false;

    protected Clause(E statement) {
        super(NamingStrategy.clause);
        this.statement = statement;
        this.statement.add(this);
    }

    protected void setUsed() {
        if (!used)
            statement.setUsed(this);
        used = true;
    }

}
