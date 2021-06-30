package UE02_AddAndSearch;

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
            addLoop(root, newNode);
        }
    }

    // Add - Variante Rekursion
    private void addRecursive(Node currentNode, Node newNode) {
        // TODO: Implementierung hinzufügen
    }

    // Add - Variante Loop
    private void addLoop(Node startNode, Node newNode) {
        // TODO: Implementierung hinzufügen
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
