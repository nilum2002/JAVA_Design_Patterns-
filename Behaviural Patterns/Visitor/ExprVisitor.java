/**
 * Visitor interface defining operations to be performed on expression elements
 */
public interface ExprVisitor {
    /**
     * Visit a number expression
     * @param numberExpr The number expression to visit
     * @return The computed result
     */
    int visit(NumberExpr numberExpr);

    /**
     * Visit an addition expression
     * @param addExpr The addition expression to visit
     * @return The computed result
     */
    int visit(AddExpr addExpr);

    /**
     * Visit a multiplication expression
     * @param mulExpr The multiplication expression to visit
     * @return The computed result
     */
    int visit(MulExpr mulExpr);
}

/**
 * Base interface for all expressions
 */
interface Expr {
    /**
     * Accepts a visitor to perform an operation
     * @param visitor The visitor to accept
     * @return The result of the visitor's operation
     */
    int accept(ExprVisitor visitor);
}

/**
 * Represents a numeric value in the expression tree
 */
class NumberExpr implements Expr {
    private final int value;

    public NumberExpr(int value) { 
        this.value = value; 
    }

    @Override
    public int accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }

    public int getValue() {
        return value;
    }
}

/**
 * Represents an addition operation in the expression tree
 */
class AddExpr implements Expr {
    private final Expr left;
    private final Expr right;

    public AddExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }

    public Expr getLeft() { return left; }
    public Expr getRight() { return right; }
}

/**
 * Represents a multiplication operation in the expression tree
 */
class MulExpr implements Expr {
    private final Expr left;
    private final Expr right;

    public MulExpr(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int accept(ExprVisitor visitor) {
        return visitor.visit(this);
    }

    public Expr getLeft() { return left; }
    public Expr getRight() { return right; }
}

/**
 * Visitor implementation that evaluates expressions
 */
class EvalVisitor implements ExprVisitor {
    @Override
    public int visit(NumberExpr numberExpr) {
        return numberExpr.getValue();
    }

    @Override
    public int visit(AddExpr addExpr) {
        return addExpr.getLeft().accept(this) + addExpr.getRight().accept(this);
    }

    @Override
    public int visit(MulExpr mulExpr) {
        return mulExpr.getLeft().accept(this) * mulExpr.getRight().accept(this);
    }
}