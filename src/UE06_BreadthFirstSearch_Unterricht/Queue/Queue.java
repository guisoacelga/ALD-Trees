package UE06_BreadthFirstSearch_Unterricht.Queue;

import UE06_BreadthFirstSearch_Unterricht.Tree.TreeNode;

public class Queue {
    private QueueNode front, rear;

    // enqueue (Hinzufügen)
    public void enqueue(TreeNode treeNode)
    {
        // Neuen Knoten erstellen
        QueueNode newNode = new QueueNode();
        newNode.setTreeNode(treeNode);

        // Fall: Queue ist leer
        if (isEmpty() == true)
        {
            front = newNode;
            rear = newNode;
        }
        // Fall: Queue ist nicht leer -> neue Wert am Ende hinzufügen
        else
        {
            rear.setNext(newNode);  //rear = altes Rear
            rear = newNode;  // rear aktualisieren
        }
    }

    // dequeue: Erstes Element zurückliefen und aus der Queue entfernen
    public QueueNode dequeue()
    {
        // Fall: Queue ist leer
        if (isEmpty() == true)
            return null;

        QueueNode currentNode = front;
        front = front.getNext();

        // Wenn Queue leer wird, dann REAR auch anpassen
        if (front == null)
            rear = null;

        return currentNode;
    }

    // isEmpty
    public boolean isEmpty()
    {
        return (front == null);
    }


}
