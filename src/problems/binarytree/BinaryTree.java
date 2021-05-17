package problems.binarytree;


/*      Binary Tree
 *                1
 *              /   \
 *            2      3
 *          /  \   /  \
 *         5    6  7   8
 *
 * */

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        Node root = buildTree();

//        preorder(root);
//        System.out.println();
//        inorder(root);
//        System.out.println();
//        postorder(root);
//        System.out.println();
//        levelOrderTraversal(root);
//        System.out.println();
//        leftView(root);
//        rightView(root);
//        sumAtKthLevel(root, 2);
//        int nodeCount = countAllNodes(root);
//        System.out.println("The number of nodes present is equal to " + nodeCount);

//        int nodeSum = sumAllNodeValue(root);
//        System.out.println("The sum of all node is equal to " + nodeSum);

//        int rootSum = replaceRootValueByItsChild(root);
//        System.out.println("The sum at root " + rootSum);

//        int height = height(root);
//        System.out.println("The height of the tree " + height);

        Node root1 = buildTreeWithDiameterFromNode();
        preorder(root1);
        int diameter = diameter(root1);
        System.out.println("The diameter of the tree " + diameter);

    }

    //TODO: Check logic again
    private static int diameter(Node root) {
        if (root == null) return 0;

        int diameterViaRoot = height(root.leftChild) + height(root.rightChild) + 1;
        int leftDiameter = diameter(root.leftChild);
        int rightDiameter = diameter(root.rightChild);

        return Math.max(diameterViaRoot, Math.max(leftDiameter, rightDiameter));
    }

    private static int height(Node root) {
        if (root == null) return 0;

        int left = height(root.leftChild);
        int right = height(root.rightChild);

        return Math.max(left, right) + 1;
    }

    private static int replaceRootValueByItsChild(Node root) {
        if (root.leftChild == null & root.rightChild == null) return root.data;

        return replaceRootValueByItsChild(root.leftChild) + replaceRootValueByItsChild(root.rightChild);
    }

    private static int sumAllNodeValue(Node root) {
        if (root == null) return 0;

        return sumAllNodeValue(root.leftChild) + sumAllNodeValue(root.rightChild) + root.data;
    }

    private static int countAllNodes(Node root) {
        if (root == null) return 0;

        return countAllNodes(root.leftChild) + countAllNodes(root.rightChild) + 1;
    }

    private static void sumAtKthLevel(Node root, int level) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        int sum = 0;

        while (!queue.isEmpty()) {
            int nodeCountAtEachLevel = queue.size();

            for (int i = 0; i < nodeCountAtEachLevel; i++) {
                Node currentNode = queue.poll();
                if (currentLevel == level) sum += currentNode.data;

                if (currentNode.leftChild != null) queue.add(currentNode.leftChild);
                if (currentNode.rightChild != null) queue.add(currentNode.rightChild);
            }
            currentLevel++;
        }

        System.out.println("The sum at level " + level + " is " + sum);
    }

    private static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preorder(root.leftChild);
        preorder(root.rightChild);
    }

    private static void inorder(Node root) {
        if (root == null) return;

        inorder(root.leftChild);
        System.out.print(root.data + " ");
        inorder(root.rightChild);
    }

    private static void postorder(Node root) {
        if (root == null) return;

        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.print(root.data + " ");
    }

    private static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            System.out.print(currentNode.data + " ");

            if (currentNode.leftChild != null) queue.add(currentNode.leftChild);
            if (currentNode.rightChild != null) queue.add(currentNode.rightChild);
        }
    }

    private static void leftView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCountAtEachLevel = queue.size();

            for (int i = 0; i < nodeCountAtEachLevel; i++) {
                Node currentNode = queue.poll();
                if (i == 0) System.out.print(currentNode.data + " ");

                if (currentNode.leftChild != null) queue.add(currentNode.leftChild);
                if (currentNode.rightChild != null) queue.add(currentNode.rightChild);
            }

        }
    }

    private static void rightView(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodeCountAtEachLevel = queue.size();

            for (int i = 0; i < nodeCountAtEachLevel; i++) {
                Node currentNode = queue.poll();
                if (i == nodeCountAtEachLevel - 1) System.out.print(currentNode.data + " ");

                if (currentNode.leftChild != null) queue.add(currentNode.leftChild);
                if (currentNode.rightChild != null) queue.add(currentNode.rightChild);
            }

        }
    }

    private static Node buildTree() {
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(5);
        root.leftChild.rightChild = new Node(6);
        root.rightChild.leftChild = new Node(7);
        root.rightChild.rightChild = new Node(8);
        return root;
    }

    private static Node buildTreeWithDiameterFromNode() {
        Node root = new Node(1);
        root.leftChild = new Node(2);
        root.rightChild = new Node(3);
        root.leftChild.leftChild = new Node(5);
        root.leftChild.rightChild = new Node(6);
        root.leftChild.rightChild.rightChild = new Node(7);
        root.leftChild.rightChild.rightChild.rightChild = new Node(8);
        return root;
    }
}

/*      Binary Tree
 *                1
 *              /   \
 *            2      3
 *          /  \   /  \
 *         5    6  7   8
 *
 * */