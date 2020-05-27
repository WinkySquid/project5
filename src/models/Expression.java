package models;

public class Expression {
	
	//INSTANCE VARIABLES
    private int _first;
    private int _second;
    private int _operation;

    //CONSTRUCTOR
    public Expression(int x, int y) {
        this._first = x;
        this._second = y;
        this._operation = this.getOperation();
    }

    /*
     * This method calculates the resulting value of the Expression
     * object depending on the values of _first, _second, and _operation
     * and returns the value. The Expression object is represented by
     * the first number (int variable) plus the product of the second 
     * number and the operation value calculated in the getOperation method.
     */
    public int getResult() {
        return this._first + (this._second * this._operation);
    }

    /*
     * This method returns the value indicating the operation
     * to be performed based on a random double generator between
     * 0.0 (inclusive) and 1.0 (exclusive). -1 means subtraction,
     * and 1 means addition.
     */
    public int getOperation() {
        double x = Math.random();
        if (x < 0.5) {
            return 1;
        }
        return -1;
    }

    /*
     * This method overrides the original toString
     * method in the Object class and returns a String
     * that represents the expression that is generated
     * depending the value of _operation.
     */
    public String toString() {
        if (this._operation == -1) {
            return this._first + " - " + this._second;
        }
        return this._first + " + " + this._second;
    }
}

