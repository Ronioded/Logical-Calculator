/* Roni Oded. ID-318798782. */

/* import classes. */
import java.util.Map;
import java.util.List;

/**
 * @author Roni Oded.
 * Interface Expression, interface in order to describe the methods for a logic expression.
 */
public interface Expression {

    /**
     * Evaluate the expression and return the result. If the expression contains a variable which is not declared,
     * an exception is thrown.
     * @param assignment - the types the are declared in the assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    Boolean evaluate() throws Exception;

    /**
     * The method return a list on the variables in the expression.
     * @return a list on the variables in the expression.
     */
    List<String> getVariables();

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    String toString();

    /**
     * The method return a new expression in which all occurrences of the variable var are replaced with the provided
     * expression (Does not modify the current expression).
     * @param var        - the var that needs to be replaced.
     * @param expression - provided expression in order to change all occurrences of the variable var.
     * @return a new expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return a new Nand expression.
     */
    Expression nandify();

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nor
     * operation.
     * @return a new Nor expression.
     */
    Expression norify();

    /**
     * The method return a simplified version of the current expression.
     * @return a simplified version of the current expression.
     */
    Expression simplify();

    /**
     * The method check if this expression and other expression are equal.
     * @param expression - the expression to check if this and expression are equal.
     * @return true if they are equal. else, return false.
     */
    boolean isEqual(Expression expression);

    /**
     * The method is trying to evaluate the expression.
     * @return an evaluate expression or this expression.
     */
    Expression tryToEvaluate();
}