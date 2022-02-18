/* Roni Oded. ID-318798782. */

/**
 * @author Roni Oded.
 * Class Not, caractories the logic expression Not.
 * Extends UnaryExpression.
 */
public class Not extends UnaryExpression {

    /**
     * Constructor in order to build an instance of the class.
     * @param expression - the expression.
     */
    public Not(Expression expression) {
        super(expression);
    }

    /**
     * The method evaluate the expression.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public Boolean evaluate() throws Exception {
            return !(getExpression().evaluate());
    }

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    @Override
    public String toString() {
        return "~(" + getExpression().toString() + ")";
    }

    /**
     * The method return a new instance of the class.
     * @param expression - the expression.
     * @return a new instance combine from expression.
     */
    public Expression newInstance(Expression expression) {
        return new Not(expression);
    }

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return a new Nand expression.
     */
    @Override
    public Expression nandify() {

        /* nandify the expression. */
        Expression exp = getExpression().nandify();
        return new Nand(exp, exp);
    }

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return a new Nor expression.
     */
    @Override
    public Expression norify() {

        /* norify the expression. */
        Expression exp = getExpression().norify();
        return new Nor(exp, exp);
    }

    /**
     * The method return a simplified version of the current expression.
     * @return a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {

        /* simplify the expression. */
        Expression exp = getExpression().simplify();
        Expression newExp = new Not(exp);

        /* if exp can be evaluated, newExp is now not on val. */
        try {
            Boolean val = exp.evaluate();
            if (val != null) {
                newExp = new Val(!val);
            }
        } catch (Exception e) {
            System.out.print("");
        }

        /* return the new expression. */
        return newExp.tryToEvaluate();
    }
}
