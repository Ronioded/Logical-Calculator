/* Roni Oded. ID-318798782. */

/* import classes */
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * @author Roni Oded.
 * Class UnaryExpression, abstract class in order to describe the unary expressions.
 * Extends the BaseExpression.
 */
public abstract class UnaryExpression extends BaseExpression {

    /* field in the class. */
    private Expression expression;

    /**
     * Constructor in order to build an instance of the class.
     * @param expression - the expression.
     */
    public UnaryExpression(Expression expression) {
        this.expression = expression;
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
        /* evaluate the expressions. */
        Val value = new Val(expression.evaluate(assignment));

        /* return new instance of the class from value, evaluate too. */
        return newInstance(value).evaluate();
    }

    /**
     * Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public abstract Boolean evaluate() throws Exception;

    /**
     * The method return the expression.
     * @return the expression.
     */
    protected Expression getExpression() {
        return expression;
    }

    /**
     * The method return a list on the variables in the expression.
     * @return a list on the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();

        /* checking variables in expression and adding it to the list if there is. */
        if (!(expression.getVariables().isEmpty())) {
            list.addAll(expression.getVariables());
        }

        /* return the list after remove the double times variables if there is. */
        return checkDoubles(list);
    }

    /**
     * The method return a new expression in which all occurrences of the variable var are replaced with the provided
     * expression (Does not modify the current expression).
     * @param var        - the var that needs to be replaced.
     * @param exp - provided expression in order to change all occurrences of the variable var.
     * @return a new expression.
     */
    @Override
    public Expression assign(String var, Expression exp) {

        /* assign the expression. */
        Expression newExpression = expression.assign(var, exp);

        /* return new expression from newExpression. */
        return newInstance(newExpression);
    }

    /**
     * The method return a new instance of the classes that combine from expression1 and expression2.
     * @param e - the expression.
     * @return a new expression from expression1 and expression2.
     */
    public abstract Expression newInstance(Expression e);

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    @Override
    public abstract String toString();
}
