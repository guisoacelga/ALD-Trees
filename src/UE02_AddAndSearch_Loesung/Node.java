package UE02_AddAndSearch_Loesung;

public class Node
{
    private final int number;
    private Node left, right;

    // *** Konstruktor ***

    public Node(int number)
    {
        this.number = number;
    }

    // *** Getter- & Setter-Methoden ***

    public int getNumber()
    {
        return number;
    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }
}
