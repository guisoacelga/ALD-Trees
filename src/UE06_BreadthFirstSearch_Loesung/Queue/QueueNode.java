package UE06_BreadthFirstSearch_Loesung.Queue;
import UE06_BreadthFirstSearch_Loesung.Tree.TreeNode;

public class QueueNode {
    private TreeNode treeNode;
    private QueueNode next;

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
