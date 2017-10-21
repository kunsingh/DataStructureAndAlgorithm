package com.test.bst;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

    Node root;

    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            Node curr = root;
            Node parent = root;
            while (true) {
                parent = curr;
                if (node.value < curr.value) {
                    curr = curr.left;
                    if (curr == null) {
                        parent.left = node;
                        node.parent = parent;
                        return;
                    }

                } else if (node.value > curr.value) {
                    curr = curr.right;
                    if (curr == null) {
                        parent.right = node;
                        node.parent = parent;
                        return;
                    }
                }
            }
        }
    }
    
    public int findKthSmallest(int k){
        
        
        return -1;
    }

    public boolean deleteNode(int value) {
        Node curr = root;
        Node parent = root;
        boolean isLeftChild = false;
        // search for the node
        while (curr.value != value) {
            parent = curr;
            if (value < curr.value) {
                isLeftChild = true;
                curr = curr.left;
            }
            if (value > curr.value) {
                isLeftChild = false;
                curr = curr.right;
            }
            // if value is not in tree
            if (curr == null) {
                return false;
            }
        }
        // CASE-1: No child- point the deleted node parent to null.
        if (curr.left == null && curr.right == null) {
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }// CASE-2: One child- point the deleted node parent to the child of
         // deleted node.
        else if (curr.right == null) { // One child - left
            if (curr == root) {
                root = curr.left;
            } else if (isLeftChild) {
                parent.left = curr.left;
            } else {
                parent.right = curr.left;
            }
        } else if (curr.left == null) { // One child - right
            if (curr == root) {
                root = curr.right;
            } else if (isLeftChild) {
                parent.left = curr.right;
            } else {
                parent.right = curr.right;
            }
        } else {
            // CASE-3: Two Children- replace the node with its successor
            Node successor = getSuccessor(curr);

            if (successor != curr.right) {
                // If there is any right subtree of successor then point it to
                // the successor's parent left
                successor.parent.left = successor.right;
                // point right subtree of the deleted node to the right of
                // successor
                successor.right = curr.right;
            }

            if (curr == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            // point left subtree of the deleted node to the left of successor
            successor.left = curr.left;
        }
        return false;
    }

    public Node getSuccesor_(Node deleteNode) {
        Node successorParent = deleteNode;
        Node successor = deleteNode;
        Node currNode = deleteNode.right;
        while (currNode != null) {
            successorParent = successor;
            successor = currNode;
            currNode = currNode.left;
        }
        if (successor != deleteNode.right) {
            successorParent.left = successor.right;
            successor.right = deleteNode.right;
        }
        return successor;
    }

    public int findMaximum() {
        Node currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode.value;
    }

    public Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        Node successor = null;
        Node currentNode = node.right;
        if (currentNode != null) {
            while (currentNode != null) {
                successor = currentNode;
                currentNode = currentNode.left;
            }
        } else {
            currentNode = node.parent;
            while (currentNode != null && currentNode.value < node.value) {
                currentNode = currentNode.parent;
            }
            successor = currentNode;
        }
        return successor;
    }

    public Node getPredecessor(Node node) {
        if (node == null) {
            return null;
        }
        Node predecessor = null;
        Node currentNode = node.left;
        if (currentNode != null) {
            while (currentNode != null) {
                predecessor = currentNode;
                currentNode = currentNode.right;
            }
        } else {
            currentNode = node.parent;
            while (currentNode != null && currentNode.value > node.value) {
                currentNode = currentNode.parent;
            }
            predecessor = currentNode;
        }
        return predecessor;
    }

    public void preOrderTraversalOfTree() {
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        stack.push(currNode);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (null == node) {
                break;
            }
            System.out.print(node.value + " ");
            if (null != node.right)
                stack.push(node.right);
            if (null != node.left)
                stack.push(node.left);
        }
        System.out.println();
    }

    public void inOrderTraversalOfTree() {
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        while (true) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (stack.isEmpty())
                break;
            currNode = stack.pop();
            System.out.print(currNode.value + " ");
            currNode = currNode.right;
        }
        System.out.println();
    }

    public void postOrderTraversalOfTree() {
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        stack.push(currNode);
        Node prev = null;
        while (!stack.isEmpty()) {
            currNode = stack.peek();
            //go down to the tree 
            if (prev == null || prev.left == currNode || prev.right == currNode) {
                if (currNode.left != null)
                    stack.push(currNode.left);
                else if (currNode.right != null)
                    stack.push(currNode.right);
                else {
                    //leaf node
                    System.out.print(currNode.value + " ");
                    stack.pop();
                }
            }
            //going up to the tree
            if (currNode.left == prev) {
                if (currNode.right != null)
                    stack.push(currNode.right);
                else {
                    System.out.print(currNode.value + " ");
                    stack.pop();
                }
            }
            //moving up from right
            if (currNode.right == prev) {
                System.out.print(currNode.value + " ");
                stack.pop();
            }
            prev = currNode;

        }
        System.out.println();
    }

    public void levelOrderTraversal(Node root) {
        assert root != null : "root is null";
        Queue<Node> queue = new LinkedList<>();
        Node currNode = root;
        queue.add(currNode);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            System.out.print(currNode.value);
            if (null != currNode.left) {
                queue.add(currNode.left);
            }
            if (null != currNode.right) {
                queue.add(currNode.right);
            }
        }
        System.out.println();
    }
    public boolean levelOrderSearch(int value) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return false;
        }

        Node currNode = root;
        queue.add(currNode);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (currNode.value == value) {
                return true;
            }
            if (null != currNode.left) {
                queue.add(currNode.left);
            }
            if (null != currNode.right) {
                queue.add(currNode.right);
            }
        }
        return false;
    }

    public int sizeOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (sizeOfBinaryTree(root.left) + 1 + sizeOfBinaryTree(root.right));
        }
    }

    public int largestBST(Node root) {
        if (isBST(root))
            return sizeOfBinaryTree(root);
        else
            return Math.max(largestBST(root.left), largestBST(root.right));
    }

    public Node mirrorOfBinaryTree(Node root) {
        Node temp = null;
        if (root != null) {
            mirrorOfBinaryTree(root.left);
            mirrorOfBinaryTree(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public boolean isMirror(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        } else {
            return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
        }
    }

    public int findHeight() {
        Queue<Node> queue = new LinkedList<>();
        Node currNode = root;
        int level = 0;
        if (currNode == null) {
            return -1;
        }
        queue.add(currNode);
        queue.add(null);
        while (!queue.isEmpty()) {
            currNode = queue.poll();
            if (currNode != null) {
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    level++;
                }
            }
        }
        return level;
    }

    public Node findLowestCommonAccestor(Node child1, Node child2) {
        if (root == null || child1 == null || child2 == null) {
            return null;
        }
        while (root != null) {
            int value = root.value;
            if (value > child1.value && value > child2.value) {
                root = root.left;
            } else if (value < child1.value && value < child2.value) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null; // only if empty tree
    }

    public boolean isBST(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (node.left != null) {
                if (node.value > node.left.value) {
                    stack.push(node.left);
                } else {
                    return false;
                }
            }
            if (node.right != null) {
                if (node.value < node.right.value) {
                    stack.push(node.right);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public void findBSST() {
        findBSSti(root);
    }

    int count = -1;
    public Node bstNode = null;

    private int findBSSti(Node n) {
        if (n == null)
            return 0;
        boolean btFound = false;
        int l = -1, r = -1;
        if (n.left != null) {
            l = findBSSti(n.left);
        } else {
            l = 0;
        }
        if (n.right != null) {
            r = findBSSti(n.right);
        } else {
            r = 0;
        }

        System.out.println(l + "=" + r);
        if (l >= 0 && r >= 0) {
            if (n.left != null) {
                btFound = (n.left.value < n.value);
            } else {
                btFound = true;
            }
        }

        if (btFound) {
            if (n.right != null) {
                btFound = (n.right.value > n.value);
            } else {
                btFound = true;
            }
        }

        if (btFound) {
            int ret = -1;
            ret = (l > r) ? (l + 1) : (r + 1);
            if (ret > count) {
                count = ret;
                bstNode = n;
            }
            return ret;
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        BinarySearchTree tree = new BinarySearchTree();
        Node node2 = new Node(2);
        Node node6 = new Node(6);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node15 = new Node(15);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        tree.add(node10);
        tree.add(new Node(12));
        tree.add(new Node(5));
        tree.add(node6);
        tree.add(node9);
        tree.add(new Node(3));
        tree.add(new Node(2));
        tree.add(node8);
        tree.add(node15);
        tree.add(node11);
        Node root = tree.root;
        tree.displayTree(root);
//        tree.deleteNode(5);
        tree.displayTree(tree.root);
         tree.postOrderTraversalOfTree();
        // tree.inOrderTraversalOfTree();
        // tree.postOrderTraversalOfTree();
        // System.out.println(tree.levelOrderSearch(15));
        System.out.println("SIZE:::  "+tree.sizeOfBinaryTree(tree.root));
        // Node mirrorRoot = tree.mirrorOfBinaryTree(tree.root);
        // tree.displayTree(tree.root);
        // tree.displayTree(mirrorRoot);
        // System.out.println(tree.isMirror(root, mirrorRoot));
         System.out.println("HEIGHT:::: "+tree.findHeight());
         System.out.println(">>>>:::: "+tree.findLowestCommonAccestor(new Node(8), new Node(11)).value);
        // System.out.println(tree.isBST(tree.root));

        System.out.println(tree.findBSSti(tree.root));
        System.out.println("predecessorr9:: " + tree.getPredecessor(node9).value);
        System.out.println("predecessor8:: " + tree.getPredecessor(node8).value);
        System.out.println("predecessor6:: " + tree.getPredecessor(node6).value);
        System.out.println("predecessor15:: " + tree.getPredecessor(node15).value);
        System.out.println("predecessor10:: " + tree.getPredecessor(node10).value);
        System.out.println("predecessor11:: " + tree.getPredecessor(node11).value);
        System.out.println("predecessor2:: " + tree.getPredecessor(node2));
    }

    public void displayTree(Node node) {
        Node root = node;
        Stack<Node> globalStack = new Stack<Node>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (isRowEmpty == false) {
            Stack<Node> localStack = new Stack<Node>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.value);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            } // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        } // end while isRowEmpty is false
        System.out.println("......................................................");
    }
}
