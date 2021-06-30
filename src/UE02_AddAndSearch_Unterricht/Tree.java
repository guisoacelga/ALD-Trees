package UE02_AddAndSearch_Unterricht;

public class Tree {
    private Node root;

    public void add(int number) {
        Node newNode = new Node(number);

        // Baum ist noch leer
        if (root == null)
            root = newNode;
            // Sonst richtige Stelle suchen und dort einfügen
        else {
            // Variante 1: Rekursiv
            addRecursive(root, newNode);

            // Variante 2: Schleife
            //addLoop(root, newNode);
        }
    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {
        // newNode = 5
        // 1. CurrentNode = root = 25
        // 2. CurrentNode = 20
        // 3. CurrentNode = 15

        // Fall 1: Neuer Wert ist kleiner
        if (newNode.getNumber() < currentNode.getNumber())
        {
            // Fall 1: Es gibt ein linkes Kind
            if (currentNode.getLeft() != null)
                addRecursive(currentNode.getLeft(), newNode);  // 15.getLeft() --> NULL
            // Fall 2: Es gibt kein linkes Kind
            else
                currentNode.setLeft(newNode);
        }
        // Fall 2: Neuer Wert ist größer
        else if (newNode.getNumber() > currentNode.getNumber())
        {
            // Fall 1: Es gibt ein rechtes Kind
            if (currentNode.getRight() != null)
                addRecursive(currentNode.getRight(), newNode);
            // Fall 2: Es gibt kein rechtes Kind
            else
                currentNode.setRight(newNode);
        }
    }

    // Add - Variante Loop (Punkt c)
    private void addLoop(Node startNode, Node newNode) {
        Node currentNode = startNode;
        boolean nodeAdded = false;

        // bei NewNode = 5
        // 1. CurrentNode = 25
        // 2. CurrentNode = 20
        // 3. CurrentNode = 15

        // bei NewNode = 60
        // 1. CurrentNode = 25
        // 2. CurrentNode = 75
        // 3. CurrentNode = 30

        while (nodeAdded == false)
        {
            if (newNode.getNumber() < currentNode.getNumber()) // --> linke Teilbaum interessant
            {
                // Fall 1: Linkes Kind ist leer
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    nodeAdded = true;
                }
                // Fall 2: Linkes Kind ist gesetzt
                else
                    currentNode = currentNode.getLeft();
            }
            else if (newNode.getNumber() > currentNode.getNumber())  // --> recht Teilbaum interessant
            {
                // Fall 1: *Rechtes* Kind ist leer
                if (currentNode.getRight() == null)
                {
                    currentNode.setRight(newNode);
                    nodeAdded = true;
                }
                // Fall 2: *Rechtes* Kind gesetzt
                else
                    currentNode = currentNode.getRight();
            }
        }
    }

    public Node searchNumber(int number) {
        System.out.print("SearchNumber - ");

        // TODO: Entweder Variante 1 oder 2 einkommentieren
        // Variante 1: Aufruf Rekursiv
        return searchNumberRecursive(root, number);
        // Variante 2: Aufruf Schleife
        //return searchNumberLoop(number);
    }

    // Suche - Variante Rekursion
    private Node searchNumberRecursive(Node currentNode, int number) {
        // TODO: Implementierung hinzufügen
        return null;
    }

    // Suche - Variante Schleife
    private Node searchNumberLoop(int number) {
        // TODO: Implementierung hinzufügen
        return null;
    }

    /**
     * Funktion zur Ausgabe des gesamten Baums.
     */
    public void printTree() {
        printTree(root, "");
    }

    /**
     * Funktion zur Ausgabe des Baums unterhalb eines Knotens
     *
     * @param currentNode Knoten, dessen Teilbaum ausgegeben werden soll
     * @param prefix      Zur Einr�ckung
     */
    public void printTree(Node currentNode, String prefix) {
        if (currentNode == null) {
            return;
        }
        System.out.println(prefix + currentNode.getNumber());
        printTree(currentNode.getLeft(), prefix + "L ");
        printTree(currentNode.getRight(), prefix + "R ");
    }


}
