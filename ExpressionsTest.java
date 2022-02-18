/* Roni Oded. ID-318798782. */

/* imports classes. */
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Roni Oded.
 * class ExpressionsTest - Test the expressions.
 */
public class ExpressionsTest {

    /**
     * Main function - have tests of the exercise as required.
     * @param args - command line arguments.
     */
    public static void main(String[] args) {

        /* new expression with at least 3 variables. then print it. */
        Expression expression = new Or(new Nand(new And(new Var("x"), new Val(true)), new Var("y")),
                new Var("z"));
        System.out.println(expression);

        /* declare new assigment with values to the variables. */
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", true);
        assignment.put("z", false);

        /* try to evaluate the expression and print the value. */
        try {
            System.out.println(expression.evaluate(assignment));
        } catch (Exception e) {
            System.out.println("Exception");
        }

        /* print the nandify, norify and simplify way. */
        System.out.println(expression.nandify());
        System.out.println(expression.norify());
        System.out.println(expression.simplify());
    }
}
