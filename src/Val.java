/* Roni Oded. ID-318798782. */

/* import classes */
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * @author Roni Oded.
 * Class Val, caractories the values of an expression.
 * Extends BaseExpression
 */
public class Val implements Expression {

    /* field in the class. */
    private Boolean val;

    /**
     * Constructor in order to build an instance of the class.
     * @param value - the value of the expression.
     */
    public Val(Boolean value) {
        val = value;
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
        return val;
    }

    /**
     * The method evaluate the expression.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return val;
    }

    /**
     * The method return a list on the variables in the expression.
     * @return a list on the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    /**
     * The method return a new expression in which all occurrences of the variable var are replaced with the provided
     * expression (Does not modify the current expression).
     * @param var        - the var that needs to be replaced.
     * @param expression - provided expression in order to change all occurrences of the variable var.
     * @return a new expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * The method return the string representation of the expression.
     * @return the string representation of the expression.
     */
    @Override
    public String toString() {

        /* if val is true, return T, else, return F. */
        if (val) {
            return "T";
        } else {
            return "F";
        }
    }

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return a new Nand expression.
     */
    @Override
    public Expression nandify() {
        return this;
    }

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nor operation.
     * @return a new Nor expression.
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * The method return a simplified version of the current expression.
     * @return a simplified version of the current expression.
     */
    @Override
    public Expression simplify() {
        return this;
    }

    /**
     * The method check if this expression and other expression are equal.
     * @param expression - the expression to check if this and expression are equal.
     * @return true if they are equal. else, return false.
     */
    @Override
    public boolean isEqual(Expression expression) {
        return (this.toString().equals(expression.toString()));
    }

    /**
     * The method is trying to evaluate the expression.
     * @return an evaluate expression or this expression.
     */
    @Override
    public Expression tryToEvaluate() {
        return this;
    }
}
