/* Roni Oded. ID-318798782. */

/**
 * @author Roni Oded.
 * Class Xor, caractories the logic expression Xor.
 * Extends BinaryExpression
 */
public class Xor extends BinaryExpression {

    /**
     * Constructor in order to build an instance of the class.
     * @param expression1 - the first expression.
     * @param expression2 - the second expression.
     */
    public Xor(Expression expression1, Expression expression2) {
        super(expression1, expression2);
    }

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    @Override
    public String toString() {
        return "(" + getExpression1().toString() + " ^ " + getExpression2().toString() + ")";
    }

    /**
     * The method return a new instance of the class.
     * @param expression1 - the first expression.
     * @param expression2 - the second expression.
     * @return a new instance combine from expression 1 and 2.
     */
    public Expression newInstance(Expression expression1, Expression expression2) {
        return new Xor(expression1, expression2);
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
        return ((val1 && !val2) || (!val1 && val2));
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
        return new Nand(new Nand(exp1, new Nand(exp1, exp2)), new Nand(exp2, new Nand(exp1, exp2)));
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
        return new Nor(new Nor(new Nor(exp1, exp1), new Nor(exp2, exp2)), new Nor(exp1, exp2));
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
        Expression newExp = new Xor(exp1, exp2);

        /* if exp1 and exp2 are equal, newExp is now false. */
        if (exp1.isEqual(exp2)) {
            newExp = new Val(false);
        }

        /* try to evaluate exp1, if it's true,newExp is now not exp2.if it throws exception, there is no way to evaluate
         it so there is no way to simplify in this case, catch the exception and moving to the next condition. */
        try {
            if (exp1.evaluate()) {
                newExp = new Not(exp2);
            }
        } catch (Exception e) {
            System.out.print("");
        }

        /* try to evaluate exp2,if it's true,newExp is now not exp1. if it throws exception, there is no way to evaluate
         it so there is no way to simplify in this case, catch the exception and moving to the next condition. */
        try {
            if (exp2.evaluate()) {
                newExp = new Not(exp1);
            }
        } catch (Exception e) {
            System.out.print("");
        }

        /* try to evaluate exp1, if it's false,newExp is now exp2. if it throws exception, there is no way to evaluate
         it so there is no way to simplify in this case, catch the exception and moving to the next condition. */
        try {
            if (!(exp1.evaluate())) {
                newExp = exp2;
            }
        } catch (Exception e) {
            System.out.print("");
        }

        /* try to evaluate exp2, if it's false,newExp is now exp1. if it throws exception, there is no way to evaluate
         it so there is no way to simplify in this case, catch the exception and moving to the next condition. */
        try {
            if (!(exp2.evaluate())) {
                newExp = exp1;

            }
        } catch (Exception e) {
            System.out.print("");
        }

        /* return the new expression. */
        return newExp.tryToEvaluate();
    }
}
