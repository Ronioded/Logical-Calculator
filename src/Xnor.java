/* Roni Oded. ID-318798782. */

/**
 * @author Roni Oded.
 * Class Xnor, caractories the logic expression Xnor.
 * Extends BinaryExpression
 */
public class Xnor extends BinaryExpression {

    /**
     * Constructor in order to build an instance of the class.
     * @param expression1 - the first expression.
     * @param expression2 - the second expression.
     */
    public Xnor(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    /**
     * The method return a new instance of the class.
     * @param expression1 - the first expression.
     * @param expression2 - the second expression.
     * @return a new instance combine from expression 1 and 2.
     */
    public Expression newInstance(Expression expression1, Expression expression2) {
        return new Xnor(expression1, expression2);
    }

    /**
     * The method evaluate the expression.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public Boolean evaluate() throws Exception {

        /* evaluate each expression. */
        Boolean val1 = getExpression1().evaluate();
        Boolean val2 = getExpression2().evaluate();
        return ((val1 && val2) || (!val1 && !val2));
    }

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return a new Nand expression.
     */
    @Override
    public Expression nandify() {

        /* nandify each expression. */
        Expression exp1 = getExpression1().nandify();
        Expression exp2 = getExpression2().nandify();
        return new Nand(new Nand(new Nand(exp1, exp1), new Nand(exp2, exp2)), new Nand(exp1, exp2));
    }

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return a new Nor expression.
     */
    @Override
    public Expression norify() {

        /* norify each expression. */
        Expression exp1 = getExpression1().norify();
        Expression exp2 = getExpression2().norify();
        return new Nor(new Nor(exp1, new Nor(exp1, exp2)), new Nor(exp2, new Nor(exp1, exp2)));
    }

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    @Override
    public String toString() {
        return "(" + getExpression1().toString() + " # " + getExpression2().toString() + ")";
    }

    /**
     * The method return a simplified version of the current expression.
     * @return a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {

        /* simplify each expression. */
        Expression exp1 = getExpression1().simplify();
        Expression exp2 = getExpression2().simplify();
        Expression newExp = new Xnor(exp1, exp2);

        /* if exp1 is equal to exp2, newExp is now true. newExp is now new instance of Xnor from exp1 and exp2. */
        if (exp1.isEqual(exp2)) {
            newExp = new Val(true);
        }

        /* return the new expression. */
        return newExp.tryToEvaluate();
    }
}
