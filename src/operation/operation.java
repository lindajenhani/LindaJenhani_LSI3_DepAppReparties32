package operation;

import java.io.Serializable;

public class operation implements Serializable {
    private int op1, op2, result1;
    private char operation;

    public operation(int op1, int op2, char operation) {
        // Constructeur de la classe, initialise les valeurs des opérateurs et de l'opération.
        this.op1 = op1;
        this.op2 = op2;
        this.operation = operation;
    }

    public int getOp1() {
        // Méthode pour obtenir la valeur de op1.
        return this.op1;
    }

    public int getOp2() {
        // Méthode pour obtenir la valeur de op2.
        return this.op2;
    }

    public int getResult1() {
        // Méthode pour obtenir le résultat de l'opération.
        return this.result1;
    }

    public char getOperation() {
        // Méthode pour obtenir le type d'opération (+, -, *, /).
        return this.operation;
    }

    public void setOp1(int op1) {
        // Méthode pour définir la valeur de op1.
        this.op1 = op1;
    }

    public void setOp2(int op2) {
        // Méthode pour définir la valeur de op2.
        this.op2 = op2;
    }

    public void setResult1(int result1) {
        // Méthode pour définir le résultat de l'opération.
        this.result1 = result1;
    }

    public void setOperation(char operation) {
        // Méthode pour définir le type d'opération (+, -, *, /).
        this.operation = operation;
    }
}

