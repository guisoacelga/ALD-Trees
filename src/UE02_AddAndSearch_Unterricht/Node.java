package UE02_AddAndSearch_Unterricht;

public class Node
{
    private int number;  // Wert
    private Node left, right;  // Referenzen

    // *** Konstruktor ***

    public Node(int number)
    {
        this.number = number;
    }

    // *** Getter- & Setter-Methoden ***
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
