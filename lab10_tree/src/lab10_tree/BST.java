package lab10_tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}
	public void add(E e) {
        root = add(root, e);
    }

    private BNode<E> add(BNode<E> node, E e) {
        if (node == null) {
            return new BNode<>(e);
        }

        if (e.compareTo(node.getData()) < 0) {
            node.setLeft(add(node.getLeft(), e));
        } else if (e.compareTo(node.getData()) > 0) {
            node.setRight(add(node.getRight(), e));
        }

        return node;
    }

    // Add a collection of elements col into BST
    public void add(Collection<E> col) {
        for (E element : col) {
            add(element);
        }
    }

    // Compute the depth of a node in BST
    public int depth(E data) {
        return depth(root, data, 0);
    }

    private int depth(BNode<E> node, E data, int currentDepth) {
        if (node == null) {
            return -1;
        }

        if (data.equals(node.getData())) {
            return currentDepth;
        }

        int leftDepth = depth(node.getLeft(), data, currentDepth + 1);
        int rightDepth = depth(node.getRight(), data, currentDepth + 1);

        if (leftDepth != -1) {
            return leftDepth;
        }

        return rightDepth;
    }

    // Compute the height of BST
    public int height() {
        return height(root);
    }

    private int height(BNode<E> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Compute total nodes in BST
    public int size() {
        return size(root);
    }

    private int size(BNode<E> node) {
        if (node == null) {
            return 0;
        }

        return size(node.getLeft()) + size(node.getRight()) + 1;
    }

    // Check whether element e is in BST
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(BNode<E> node, E e) {
        if (node == null) {
            return false;
        }

        int compareResult = e.compareTo(node.getData());

        if (compareResult < 0) {
            return contains(node.getLeft(), e);
        } else if (compareResult > 0) {
            return contains(node.getRight(), e);
        } else {
            return true;
        }
    }

    // Find the minimum element in BST
    public E findMin() {
        if (root == null) {
            return null;
        }

        BNode<E> minNode = findMin(root);
        return minNode.getData();
    }

    private BNode<E> findMin(BNode<E> node) {
        if (node.getLeft() == null) {
            return node;
        }

        return findMin(node.getLeft());
    }

    // Find the maximum element in BST
    public E findMax() {
        if (root == null) {
            return null;
        }

        BNode<E> maxNode = findMax(root);
        return maxNode.getData();
    }

    private BNode<E> findMax(BNode<E> node) {
        if (node.getRight() == null) {
            return node;
        }

        return findMax(node.getRight());
    }

    // Remove element e from BST
    public boolean remove(E e) {
        root = remove(root, e);
        return true; // Assuming successful removal for simplicity
    }

    private BNode<E> remove(BNode<E> node, E e) {
        if (node == null) {
            return null;
        }

        int compareResult = e.compareTo(node.getData());

        if (compareResult < 0) {
            node.setLeft(remove(node.getLeft(), e));
        } else if (compareResult > 0) {
            node.setRight(remove(node.getRight(), e));
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // Case 2: Node with two children
            // Find the smallest node in the right subtree (successor)
            node.setData(findMin(node.getRight()).getData());

            // Delete the successor
            node.setRight(remove(node.getRight(), node.getData()));
        }

        return node;
    }

    // Get the descendants of a node
    public List<E> descendants(E data) {
        List<E> descendantsList = new LinkedList<>();
        BNode<E> node = findNode(root, data);

        if (node != null) {
            collectDescendants(node.getLeft(), descendantsList);
            collectDescendants(node.getRight(), descendantsList);
        }

        return descendantsList;
    }

    private void collectDescendants(BNode<E> node, List<E> descendantsList) {
        if (node != null) {
            descendantsList.add(node.getData());
            collectDescendants(node.getLeft(), descendantsList);
            collectDescendants(node.getRight(), descendantsList);
        }
    }

    // Get the ancestors of a node
    public List<E> ancestors(E data) {
        List<E> ancestorsList = new LinkedList<>();
        findAncestors(root, data, ancestorsList);
        return ancestorsList;
    }

    private boolean findAncestors(BNode<E> node, E data, List<E> ancestorsList) {
        if (node == null) {
            return false;
        }

        if (node.getData().equals(data)) {
            return true;
        }

        if (findAncestors(node.getLeft(), data, ancestorsList) || findAncestors(node.getRight(), data, ancestorsList)) {
            ancestorsList.add(node.getData());
            return true;
        }

        return false;
    }

    private BNode<E> findNode(BNode<E> node, E data) {
        if (node == null) {
            return null;
        }

        int compareResult = data.compareTo(node.getData());

        if (compareResult < 0) {
            return findNode(node.getLeft(), data);
        } else if (compareResult > 0) {
            return findNode(node.getRight(), data);
        } else {
            return node;
        }
    }
    public void preorder() {
        List<E> result = new ArrayList<>();
        preorder(root, result);
        System.out.println("Pre-order: " + result);
    }

    private void preorder(BNode<E> node, List<E> result) {
        if (node != null) {
            result.add(node.getData());
            preorder(node.getLeft(), result);
            preorder(node.getRight(), result);
        }
    }

    // Display BST using postorder approach
    public void postorder() {
        List<E> result = new ArrayList<>();
        postorder(root, result);
        System.out.println("Post-order: " + result);
    }

    private void postorder(BNode<E> node, List<E> result) {
        if (node != null) {
            postorder(node.getLeft(), result);
            postorder(node.getRight(), result);
            result.add(node.getData());
        }
    }

    // Display BST using inorder approach
    public void inorder() {
        List<E> result = new ArrayList<>();
        inorder(root, result);
        System.out.println("In-order: " + result);
    }

    private void inorder(BNode<E> node, List<E> result) {
        if (node != null) {
            inorder(node.getLeft(), result);
            result.add(node.getData());
            inorder(node.getRight(), result);
        }
    }

}
