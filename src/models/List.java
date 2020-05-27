package models;

import java.util.ArrayList;

public class List {
	
	//INSTANCE VARIABLE(S)
    private ArrayList<Expression> _a;

    //CONSTRUCTOR
    public List(int n) {
        this._a = this.generateProblemList(n);
    }

    //GETTER
    public ArrayList<Expression> getList() {
        return this._a;
    }
    
    /*
     * This method generates the list of problems/Expression
     * objects depending on the specified value of n, which
     * indicates the size of the list. It also uses 2 random values
     * to indicate the first number and the second number in
     * the expression. In addition, the method makes sure that 
     * the expressions in the list will always have a result 
     * of 0 or higher. After all of this, the method returns
     * the list of problems/Expression objects.
     */
    public ArrayList<Expression> generateProblemList(int n) {
        ArrayList<Expression> x = new ArrayList<Expression>();
        for (int i = 0; i < n; ++i) {
            int a = (int)(Math.random() * 10.0);
            int b = (int)(Math.random() * 10.0);
            Expression e = new Expression(a, b);
            while (e.getResult() < 0) {
                a = (int)(Math.random() * 10.0);
                b = (int)(Math.random() * 10.0);
                e = new Expression(a, b);
            }
            x.add(e);
        }
        return x;
    }
}

