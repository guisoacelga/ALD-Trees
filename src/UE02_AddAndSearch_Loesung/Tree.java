package UE02_AddAndSearch_Loesung;

public class Tree {
    private Node root;

    public void add(int number) {
        Node newNode = new Node(number);

        // Baum ist noch leer
        if (root == null)
            root = newNode;
            // Sonst richtige Stelle suchen und dort einfügen
        else {
            // TODO: Entweder Variante 1 oder Variante 2 einkommentieren
            // Variante 1: Rekursiv
            //addRecursive(root, newNode);
            // Variante 2: Schleife
            addLoop(newNode);
        }
    }

    private void addRecursive(Node currentNode, Node newNode) {
        // Neue Zahl ist kleiner als die des Knoten --> Linker Teilbaum
        if (newNode.getNumber() < currentNode.getNumber()) {
            // Linken Teilbaum holen
            Node leftTree = currentNode.getLeft();

            // Wenn linker Teilbaum leer, dann dort anhängen
            if (leftTree == null)
                currentNode.setLeft(newNode);
                // Sonst tiefer in den linken Baum gehen
            else
                addRecursive(leftTree, newNode);
        }
        // Neue Zahl ist größer als die des Knoten --> Rechter Teilbaum
        else {
            // Rechten Teilbaum holen
            Node rightTree = currentNode.getRight();

            // Wenn rechter Teilbaum leer, dann dort anhängen
            if (rightTree == null)
                currentNode.setRight(newNode);
                // Sonst tiefer in den rechten Teilbaum gehen
            else
                addRecursive(rightTree, newNode);
        }
    }

    private void addLoop(Node newNode) {
        Node currentNode = root;
        Boolean nodeAdded = false;

        while (nodeAdded == false) {
            // Neuer Knoten ist kleiner als aktueller Knoten -> linker Teilbaum
            if (newNode.getNumber() < currentNode.getNumber()) {
                // Wenn linkes Kind frei ist, dann dort einfügen
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(newNode);
                    nodeAdded = true;
                }
                // sonst beim linken Kind weitersuchen
                else
                    currentNode = currentNode.getLeft();
            }
            // Neuer Knoten ist größer als aktueller Knoten -> rechter Teilbaum
            else {
                // Wenn rechtes Kind frei ist, dann dort einfügen
                if (currentNode.getRight() == null) {
                    currentNode.setRight(newNode);
                    nodeAdded = true;
                }
                // sonst beim rechten Kind weitersuchen
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
        System.out.print("CurrentNode: " + ((currentNode == null) ? "NULL" : currentNode.getNumber()) + ", ");

        if (currentNode == null)
            return null;
        else if (currentNode.getNumber() == number)
            return currentNode;
        else if (number < currentNode.getNumber())
            return searchNumberRecursive(currentNode.getLeft(), number);
        else
            return searchNumberRecursive(currentNode.getRight(), number);
    }

    // Suche - Variante Schleife
    private Node searchNumberLoop(int number) {
        Node currentNode = root;

        while (currentNode != null) {
            System.out.print("CurrentNode: " + ((currentNode == null) ? "NULL" : currentNode.getNumber()) + ", ");

            if (number == currentNode.getNumber())
                return currentNode;
                // Gesuchte Nummer ist kleiner als Knoten. Darum beim linken Teilbaum weitersuchen.
            else if (number < currentNode.getNumber())
                currentNode = currentNode.getLeft();
                // Gesuchte Nummer ist größer als Knoten. Darum beim rechten Teilbaum weitersuchen.
            else if (number > currentNode.getNumber())
                currentNode = currentNode.getRight();
        }

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
