import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        root.insert(value);
    }

    public int countNodes() {
        if (root == null) {
            return 0;
        }
        return root.countNodes();
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        }
        return root.contains(value);
    }

    public void printBFS() {
        if (root == null) {
            System.out.println(" ");
            return;
        }
        root.printBFS();
    }

    public int height() {
        if (root == null) {
            return 0;
        }
        return root.height();
    }

    public void printLevelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node tmpNode = q.poll();

            System.out.println(tmpNode.value + " ");
            if (tmpNode.left != null) {
                q.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                q.add(tmpNode.right);
            }
        }
    }

    public String toStringInorder() {
        if (root == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        root.toStringInorder(sb);
        return sb.toString();
    }

    public String toStringPreorder() {
        if (root == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        root.toStringPreorder(sb);
        return sb.toString();
    }

    public String toStringPostorder() {
        if (root == null) {
            return " ";
        }
        StringBuilder sb = new StringBuilder();
        root.toStringPostorder(sb);
        return sb.toString();
    }

    /**
     * Node class
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }


        public Node insert(int newValue) {
            if (newValue == value) {
                return this;
            }
            if (newValue < value) {
                if (left == null) {
                    left = new Node(newValue);
                    return left;
                }
                return left.insert(newValue);
            }
            if (right == null) {
                right = new Node(newValue);
                return right;
            }
            return right.insert(newValue);
        }

        public int countNodes() {
            int l = left != null ? left.countNodes() : 0;
            int r = right != null ? right.countNodes() : 0;

            return  1 + l + r;
        }

        public boolean contains(int otherValue) {
            if (value == otherValue) {
                return true;
            }
            if (otherValue < value) {
                if (left == null) {
                    return false;
                }
                return left.contains(otherValue);
            }
            if (right == null) {
                return false;
            }
            return right.contains(otherValue);
        }

        public Node delete(int otherValue) {
            // TODO
            return null;
        }

        public void printBFS() {
            System.out.print(value + " ");
            if (left != null) {
                left.printBFS();
            }
            if (right != null) {
                right.printBFS();
            }
        }

        public int height() {
            int lHeight = left != null ? left.height() : 0;
            int rHeight = right != null ? right.height() : 0;
            return 1 + Math.max(lHeight, rHeight);
        }

        /**
         * Returns the inorder string for the tree.
         *
         * @param sb the StringBuilder to append the values.
         */
        public void toStringInorder(StringBuilder sb) {
            if (left != null) {
                left.toStringInorder(sb);
            }
            sb.append(value + " ");
            if (right != null) {
                right.toStringInorder(sb);
            }
        }

        public void toStringPreorder(StringBuilder sb) {
            sb.append(value + " ");
            if (left != null) {
                left.toStringPreorder(sb);
            }
            if (right != null) {
                right.toStringPreorder(sb);
            }
        }

        public void toStringPostorder(StringBuilder sb) {
            if (left != null) {
                left.toStringPostorder(sb);
            }
            if (right != null) {
                right.toStringPostorder(sb);
            }
            sb.append(value + " ");
        }
    }
}
