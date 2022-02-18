/* Roni Oded. ID-318798782. */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Roni Oded.
 * Class BinaryExpression, abstract class in order to describe the binary expressions.
 * extends the BaseExpression.
 */
public abstract class BinaryExpression extends BaseExpression {

    /* fields in the class. */
    private Expression expression1;
    private Expression expression2;

    /**
     * Constructor in order to build an instance of the class.
     * @param expression1 - the first expression.
     * @param expression2 - the second expression.
     */
    public BinaryExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    /**
     * Evaluate the expression and return the result. If the expression contains a variable which is not declared,
     * an exception is thrown.
     * @param assignment - the types the are declared in the assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {

        /* evaluate each one of the expressions. */
        Val value1 = new Val(expression1.evaluate(assignment));
        Val value2 = new Val(expression2.evaluate(assignment));

        /* return new instance of the class from value1 and value2, evaluate them too. */
        return newInstance(value1, value2).evaluate();
    }

    /**
     * Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public abstract Boolean evaluate() throws Exception;

    /**
     * The method return the first expression.
     * @return the first expression.
     */
    protected Expression getExpression1() {
        return expression1;
    }

    /**
     * The method return the second expression.
     * @return the second expression.
     */
    protected Expression getExpression2() {
        return expression2;
    }

    /**
     * The method return a list on the variables in the expression.
     * @return a list on the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();

        /* checking variables in expression1 and adding it to the list if there is. */
        if (!(expression1.getVariables().isEmpty())) {
            list.addAll(expression1.getVariables());
        }

        if (!(expression2.getVariables().isEmpty())) {
            list.addAll(expression2.getVariables());
        }

        /* return the list after remove the double times variables if there is. */
        return checkDoubles(list);
    }

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    @Override
    public abstract String toString();

    /**
     * The method return a new expression in which all occurrences of the variable var are replaced with the provided
     * expression (Does not modify the current expression).
     * @param var        - the var that needs to be replaced.
     * @param expression - provided expression in order to change all occurrences of the variable var.
     * @return a new expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        /* assign each expression. */
        Expression exp1 = expression1.assign(var, expression);
        Expression exp2 = expression2.assign(var, expression);

        /* return new expression from exp1 and exp2. */
        return newInstance(exp1, exp2);
    }

    /**
     * The method return a new instance of the classes that combine from exp1 and exp2.
     * @param exp1 - the first expression.
     * @param exp2 - the second expression.
     * @return a new expression from exp1 and exp2.
     */
    public abstract Expression newInstance(Expression exp1, Expression exp2);

    /**
     * the method return a simplified version of the current expression.
     * @return a simplified version of the current expression.
     */
    @Override
    public abstract Expression simplify();

    /**
     * the method return the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return a new Nand expression.
     */
    @Override
    public abstract Expression nandify();

    /**
     * the method return the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return a new Nor expression.
     */
    @Override
    public abstract Expression norify();
}
