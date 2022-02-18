/* Roni Oded. ID-318798782. */

/* import classes */
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * @author Roni Oded.
 * class Var, caractories the variables of an expression.
 * extends BaseExpression
 */
public class Var implements Expression {

    /* field in the class. */
    private String str;

    /**
     * Constructor in order to build an instance of the class.
     * @param string - the string to put in the var.
     */
    public Var(String string) {
        str = string;
    }

    /**
     * The method evaluate the expression.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {

        /* if the assignment contain str, return the value from the assigment. else, throw exception. */
        if (assignment.containsKey(str)) {
            return assignment.get(str);
        } else {
            throw new Exception("Var is not the assigment");
        }
    }

    /**
     * Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("There is no value to Var");
    }

    /**
     * The method return a list on the variables in the expression.
     * @return a list on the variables in the expression.
     */
    @Override
    public List<String> getVariables() {

        /* create new list, add str to the list and return it. */
        List<String> list = new ArrayList<>();
        list.add(str);
        return list;
    }

    /**
     * The method return the string representation of the expression.
     * @return the string str.
     */
    public String toString() {
        return str;
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

        /* if var is equal to str, the expression is being returned, else return this var.*/
        if (var.equals(str)) {
            return expression;
        } else {
            return this;
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
        return (str.equals(expression.toString()));
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
