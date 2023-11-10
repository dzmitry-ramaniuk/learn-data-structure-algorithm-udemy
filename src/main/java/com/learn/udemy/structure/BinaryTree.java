package com.learn.udemy.structure;

public class BinaryTree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.getData()) {
            node.setLeftChild(delete(node.getLeftChild(), value));
        } else if (value > node.getData()) {
            node.setRightChild(delete(node.getRightChild(), value));
        } else {
            if (node.getLeftChild() == null) {
                return node.getRightChild();
            } else if (node.getRightChild() == null) {
                return node.getLeftChild();
            }

            node.setData(node.getRightChild().min());
            node.setRightChild(delete(node.getRightChild(), node.getData()));
        }

        return node;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        } else {
            return root.max();
        }
    }
}
