public class ServidorTreeImplementation {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        Node root;

        public void insert(int value) {
            root = insertRec(root, value);
        }
        
        private Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }
            if (value < root.data) {
                root.left = insertRec(root.left, value);
            } else if (value > root.data) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        public boolean search(int value) {
            return searchRec(root, value);
        }

        private boolean searchRec(Node root, int value) {
            if (root == null) {
                return false;
            }
            if (root.data == value) {
                return true;
            }
            return value < root.data ? searchRec(root.left, value) : searchRec(root.right, value);
        }

        public void delete(int value) {
            root = deleteRec(root, value);
        }

        private Node deleteRec(Node root, int value) {
            if (root == null) {
                return root;
            }

            if (value < root.data) {
                root.left = deleteRec(root.left, value);
            } else if (value > root.data) {
                root.right = deleteRec(root.right, value);
            } else {
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                root.data = minValue(root.right);

                root.right = deleteRec(root.right, root.data);
            }

            return root;
        }

        private int minValue(Node root) {
            int minValue = root.data;
            while (root.left != null) {
                root = root.left;
                minValue = root.data;
            }
            return minValue;
        }

        public void inorderTraversal() {
            inorderRec(root);
            System.out.println();
        }

        private void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.print(root.data + " ");
                inorderRec(root.right);
            }
        }

        public void preorderTraversal() {
            preorderRec(root);
            System.out.println();
        }

        private void preorderRec(Node root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preorderRec(root.left);
                preorderRec(root.right);
            }
        }

        public void postorderTraversal() {
            postorderRec(root);
            System.out.println();
        }

        private void postorderRec(Node root) {
            if (root != null) {
                postorderRec(root.left);
                postorderRec(root.right);
                System.out.print(root.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("In-order traversal: ");
        tree.inorderTraversal();

        System.out.print("Pre-order traversal: ");
        tree.preorderTraversal();
        
        System.out.print("Post-order traversal: ");
        tree.postorderTraversal();

        int searchValue = 40;
        System.out.println("Search for " + searchValue + ": " + tree.search(searchValue));

        int deleteValue = 50;
        System.out.println("Deleting " + deleteValue);
        tree.delete(deleteValue);
        
        System.out.print("In-order traversal after deletion: ");
        tree.inorderTraversal();
    }
}
