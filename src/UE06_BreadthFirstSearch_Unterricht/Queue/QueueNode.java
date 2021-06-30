package UE06_BreadthFirstSearch_Unterricht.Queue;

import UE06_BreadthFirstSearch_Unterricht.Tree.TreeNode;

public class QueueNode {
    private TreeNode treeNode;  // Wert
    private QueueNode next;  // Referenz

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
