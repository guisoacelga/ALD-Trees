package Demo01_BinaryTree;

public class Tree {
    private Node root;  // = Wurzelknoten

    // Add per Schleife - Node/Knoten zum Tree hinzufügen
    public void add(int number)
    {
        // Knoten erstellen
        Node newNode = new Node();
        newNode.setNumber(number);

        // Fall: Tree ist noch leer
        if (root == null)
        {
            root = newNode;
        }
        // Fall: Tree ist bereits befüllt
        else
        {
            Node currentNode = root;
            boolean nodeAdded = false;

            while (nodeAdded == false)
            {
                // Neuer Wert ist kleiner als aktueller Knoten (linke Teilbaum)
                if (newNode.getNumber() < currentNode.getNumber())
                {
                    // Fall 1: Linkes Kind ist gesetzt
                    if (currentNode.getLeft() != null)
                    {
                        currentNode = currentNode.getLeft();
                    }
                    // Fall 2: Linkes Kind existiert nicht
                    else
                    {
                        currentNode.setLeft(newNode);
                        nodeAdded = true;
                    }
                }
                // Neuer Wert ist größer als aktueller Knoten (rechte Teilbaum)
                else
                {
                    // Fall 1: Rechtes Kind ist gesetzt
                    if (currentNode.getRight() != null)
                    {
                        currentNode = currentNode.getRight();
                    }
                    // Fall 2: Rechtes Kind existiert nicht
                    else
                    {
                        currentNode.setRight(newNode);
                        nodeAdded = true;
                    }
                }
            }
        }
    }

    // Suche per Rekursion - Suchen einen bestimmten Wert im Baum
    public Node searchByNumber(int number)
    {
        return searchByNumber(root, number);
    }

    private Node searchByNumber(Node currentNode, int number)
    {
        // Fall 0: Gesuchter Wert kommt nie vor im Tree
        if (currentNode == null)
            return null;
        // Fall 1: Aktueller Knoten ist schon der gesuchte
        else if (currentNode.getNumber() == number)
            return currentNode;
        // Fall 2: Gesuchter Wert ist kleiner als der aktuelle Knoten (linke Teilbaum)
        else if (number < currentNode.getNumber())
            return searchByNumber(currentNode.getLeft(), number);
        // Fall 3: Gesuchter Wert ist größer als der aktuelle Knoten (rechte Teilbaum)
        else if (number > currentNode.getNumber())
            return searchByNumber(currentNode.getRight(), number);

        return null;
    }





}
