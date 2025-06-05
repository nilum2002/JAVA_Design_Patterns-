
// Abstract Expression - Defines the interface for interpreting expressions 


interface Expression{
    int interpret();
}




// terminal Expression - represents the numbers in the grammar


class NumberExpression implements Expression{
    private final int number;

    public NumberExpression(int number){
        this.number = number;
    }

    @Override
    public int interpret(){
        return number;
    }
}



// Non Terminal Expression - Represents addition in Grammar
class AddExpression implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;


    public AddExpression(Expression leftExpression, Expression rightExpression){
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;

    }


    @Override
    public int interpret(){
        return leftExpression.interpret() + rightExpression.interpret();
    }
}


// Non Terminal Expression - Represents subtraction in the grammer 


class SubtractExpression implements Expression{
    private final Expression leftExpression;
    private final Expression rightExpression;


    public SubtractExpression(Expression leftExpression, Expression rightExpression){
        this.rightExpression = rightExpression;
        this.leftExpression = leftExpression;
    }

    @Override
    public int interpret(){
        return leftExpression.interpret() - rightExpression.interpret();
    }
}
// client code 
public class InterpreterEx {
    public static void main(String[] args) {
        Expression five = new NumberExpression(5);
        Expression three = new NumberExpression(3);

        Expression addition = new AddExpression(five, three);
        Expression substraction = new SubtractExpression(five, three);


        System.out.println("Result of Addition " + addition.interpret());
        System.out.println("Result in Subtraction  " + substraction.interpret());
    }
}
