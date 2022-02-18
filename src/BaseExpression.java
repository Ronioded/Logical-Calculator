/* Roni Oded. ID-318798782. */

/* import classes. */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Roni Oded.
 * Class BaseExpression, abstrace class in order to describe all the expressions.
 */
public abstract class BaseExpression implements Expression {

    /**
     * Evaluate the expression and return the result. If the expression contains a variable which is not declared,
     * an exception is thrown.
     * @param assignment - the types the are declared in the assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public abstract Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression.
     * @throws Exception if the expression contains a variable which is not declared.
     */
    @Override
    public abstract Boolean evaluate() throws Exception;

    /**
     * The method return a list on the variables in the expression.
     * @return a list on the variables in the expression.
     */
    @Override
    public abstract List<String> getVariables();

    /**
     * The method return a new expression in which all occurrences of the variable var are replaced with the provided
     * expression (Does not modify the current expression).
     * @param var        - the var that needs to be replaced.
     * @param expression - provided expression in order to change all occurrences of the variable var.
     * @return a new expression.
     */
    @Override
    public abstract Expression assign(String var, Expression expression);

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nand operation.
     * @return a new Nand expression.
     */
    @Override
    public abstract Expression nandify();

    /**
     * The method return the expression tree resulting from converting all the operations to the logical Nor
     * operation.
     * @return a new Nor expression.
     */
    @Override
    public abstract Expression norify();

    /**
     * The method return a simplified version of the current expression.
     * @return a simplified version of the current expression.
     */
    @Override
    public abstract Expression simplify();

    /**
     * The method remove the double times strings in the list.
     * @param list - the list to delete doubles from.
     * @return a new list without double strings.
     */
    public List<String> checkDoubles(List<String> list) {
        List<String> newList = new ArrayList<>();

        /* moving on the strings in the list. */
        for (String str : list) {

            /* if the newList does not have str already, i am adding it to the newList. */
            if (!(newList.contains(str))) {
                newList.add(str);
            }
        }

        /* return the new List. */
        return newList;
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

        /* try to evaluate newExp, if we can evaluate it, return the value. if it throws exception, there is no way to
         evaluate it so there is no way to simplify in this case, catch the exception and return this */
        try {
            Boolean val = evaluate();
            if (val != null) {
                return new Val(val);
            }
        } catch (Exception e) {
            System.out.print("");
        }
        return this;
    }
}
