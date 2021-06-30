package UE04_RotateTree_Unterricht;

public class Tree
{
    private Node root;

    public void addNode(TvShow newTvShow)
    {
        Node newNode = new Node(newTvShow);

        // Fall: Baum ist noch leer
        if (root == null) {
            root = newNode;
        }
        // Fall: Baum nicht leer ist
        else {
            addNodeRecursive(root, newNode);
        }
    }

    private void addNodeRecursive(Node currentNode, Node newNode)
    {
        // Fall 1: newNode kleiner als currentNode
        if (newNode.getTvShow().getRank() < currentNode.getTvShow().getRank())
        {
            // Fall a: Linkes Kind ist leer
            if (currentNode.getLeft() == null)
                currentNode.setLeft(newNode);
            // Fall b: Linkes Kind existiert
            else
                addNodeRecursive(currentNode.getLeft(), newNode);
        }
        // Fall 2: newNode größer als currentNode
        else if (newNode.getTvShow().getRank() > currentNode.getTvShow().getRank())
        {
            // Fall a: Rechtes Kind ist leer
            if (currentNode.getRight() == null)
                currentNode.setRight(newNode);
            // Fall b: Rechtes Kind existiert
            else
                addNodeRecursive(currentNode.getRight(), newNode);
        }
    }

    public int getMaxDepth()
    {
        return getMaxDepth(root);
    }

    private int getMaxDepth(Node currentTree)
    {
        if (currentTree == null)
            return 0;
        else
        {
            int leftDepth = getMaxDepth(currentTree.getLeft());
            int rightDepth = getMaxDepth(currentTree.getRight());

            if (leftDepth > rightDepth)
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    /**
     * Knoten nach rechts rotieren:
     *
     *       N				 L
     *      / \             / \
     *     L   r     =>    ll  N
     *    / \			      / \
     *   ll lr               lr  r
     */

    public void rotateRight()
    {
        // Geht vom Wurzelknoten aus
        // N = root

        // FEHLER: NULL.getLeft(), NULL.getRight(), NULL.setLeft()
        // GEHT: 1.setLeft(null)

        // Fall: Baum ist leer ODER L ist null --> Keine Rotation durchführen
        if (root == null)
            return;
        if (root.getLeft() == null)
            return;

        // Hilfsvariablen
        Node nNode = root;
        Node lNode = nNode.getLeft();  // lNode != NULL --> sind wir uns sicher
        Node lrNode = null;

        lrNode = lNode.getRight();  // Befehl ist immer erlaubt, da lNode sicher nicht NULL ist (haben wir zu Beginn schon abgefragt)
        lNode.setRight(nNode);
        nNode.setLeft(lrNode);
    }


    /**
     * Knoten nach links rotieren:
     *
     *       N				 R
     *      / \             / \
     *     l   R     =>    N  rr
     *        / \	      / \
     *       rl rr       l  rl
     */
    public void rotateLeft()
    {
        // Wenn Baum leer ist --> keine Rotation
        if (root == null)
            return;
        // Wenn R NULL ist --> keine Rotation
        if (root.getRight() == null)
            return;

        // Hilfsvariablen
        Node nNode = root;
        Node rNode = root.getRight();
        Node rlNode = rNode.getLeft();

        // Umhängen
        root = rNode;
        rNode.setLeft(nNode);
        nNode.setRight(rlNode);
    }

    public int getNodeCount()
    {
        return getNodeCount(root);
    }

    private int getNodeCount(Node currentNode)
    {
        if (currentNode == null)
            return 0;
        else
        {
            Node leftNode = currentNode.getLeft();
            if (leftNode != null)
                return (1 + getNodeCount(leftNode));

            Node rightNode = currentNode.getRight();
            if (rightNode != null)
                return (1 + getNodeCount(rightNode));

            return 1;
        }
    }
}
