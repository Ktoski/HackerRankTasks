package BinaryTree;

import java.util.*;

public class BinaryTree {

    // https://www.baeldung.com/java-binary-tree

    private Node root;
    private int numberOfPaths;
    private List<UniquePath> uniquePaths = new ArrayList<>();
    private boolean hasTreeFeatures;

    private Node addRecursive(Node current, int value){
        if (current == null) {
            System.out.println("::: adding : " + value);
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    public BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        /*bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);*/

        return bt;
    }

    private void preOrderTraverseRecursive(Node root){

        if(root != null) {
            System.out.println("value parent: " + root.value);

            boolean hasAnyLeaves = checkIfHasLeaves(root);
            if(hasAnyLeaves) {
                if(root.left != null) System.out.println(":: value left: " + root.left.value);
                if(root.right != null) System.out.println(":: value right: " + root.right.value);

                preOrderTraverseRecursive(root.left);
                preOrderTraverseRecursive(root.right);
            }else{
                numberOfPaths++;
            }
        }
    }

    public void populatePathsList(){
        int [] pathValues = new int[1000];
        populatePathsRecursive(root, pathValues, 0);
    }

    private void populatePathsRecursive(Node node, int [] path, int pathLen){

        if (node == null)
            return;

        path[pathLen] = node.value;
        pathLen++;
        System.out.println("pathLen " + pathLen + " val " + node.value);

        boolean hasAnyLeaves = checkIfHasLeaves(node);
        if (!hasAnyLeaves) {
            printArray(path, pathLen);
            uniquePaths.add(new UniquePath(path, pathLen));
        }
        else {
            populatePathsRecursive(node.left, path, pathLen);
            populatePathsRecursive(node.right, path, pathLen);
        }

    }

    private void printArray(int [] pathValues, int len)
    {
        for (int i = 0; i < len; i++) {
            System.out.print(pathValues[i] + " |");
        }
        System.out.println("");
    }

    private void traverseBreadthRecursive(Node root){
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<Node>();

        nodes.add(root);

        while(!nodes.isEmpty()){

            Node node = nodes.remove();
            System.out.println(": node to display: " + node.value);
            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right!= null) {
                nodes.add(node.right);
            }
        }
    }

    private boolean checkIfHasLeaves(Node node){
        return ! (node.right == null && node.left == null);
    }

    private boolean checkIfHasBothLeaves(Node node){
        return (node.right != null && node.left != null);
    }

    void preOrderTraverseDepthTree(){
        preOrderTraverseRecursive(this.root);
    }

    void traverseBreadthFirstTree(){
        traverseBreadthRecursive(this.root);
    }

    public void deleteNode(int valueOfNodeToDelete){
        deleteNodeRecursive(this.root, valueOfNodeToDelete);
    }

    private void deleteNodeRecursive(Node node, int valueOfNodeToDelete) {

        if (node != null) {
            if (valueOfNodeToDelete == node.value) {
                System.out.println("removing 0 ... " + node.value);
                if(checkIfHasBothLeaves(node)) { // case has both leaves
                    System.out.println("removing 1 ... " + node.value);
                    Node successor = findInOrderSuccessorNode(node.right);
                    node.value = successor.value;
                    deleteNodeRecursive(successor, successor.value);
                }else if(checkIfHasOneLeave(node)){ // case has one leaf
                    System.out.println("removing 2 ... " + node.value);
                    deleteNodeWithOneLeave(node);
                }else{ // has no leafs case
                    System.out.println("removing 5 ... " + node.value);
                    node.value = -1;
                    /*Node parentNode = findParentNode(root, node, null);
                    System.out.println("parent... " + parentNode);
                    if(node == parentNode.left) parentNode.left = null;
                    if(node == parentNode.right) parentNode.right = null;*/
                }
            } else {
                //parentNode = node;
                if(valueOfNodeToDelete < node.value) {
                    if(root.left != null) deleteNodeRecursive(node.left, valueOfNodeToDelete);
                }else {
                    if(root.right != null) deleteNodeRecursive(node.right, valueOfNodeToDelete);
                }
            }
        }
    }

    private Node findParentNode(Node root, Node leave, Node parent){

        if(root == null)
            return null;
        if(root.value == leave.value){
            return parent;
        } else{
            findParentNode(root.left, leave, parent);
            findParentNode(root.right, leave, parent);
        }
        return null;
    }

    private boolean checkIfHasOneLeave(Node node){
        if(node.left == null && node.right != null)
            return true;
        if(node.left != null && node.right == null)
            return true;
        else
            return false;
    }

    private void deleteNodeWithOneLeave(Node node){
        if(node.left != null){
            System.out.println("removing 3 ... " + node.value);
            node.value = node.left.value;
            node.left = null;
        }else{
            System.out.println("removing 4 ... " + node.value);
            node.value = node.right.value;
            node.right = null;
        }
    }

    private Node findInOrderSuccessorNode(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }




    private void restoreTreeFeatures(){}

    public boolean checkIfHasTreeFeatures(){
        checkTreeFeaturesRecursive(this.root);
        return this.hasTreeFeatures;
    }

    private void checkTreeFeaturesRecursive(Node root){

        if(! this.hasTreeFeatures) {
            if (root != null) {

                boolean hasAnyLeaves = checkIfHasLeaves(root);
                if (hasAnyLeaves) {
                    if (root.left != null) if (root.value < root.left.value) this.hasTreeFeatures = false;
                    if (root.right != null) if (root.value > root.right.value) this.hasTreeFeatures = false;

                    checkTreeFeaturesRecursive(root.left);
                    checkTreeFeaturesRecursive(root.right);
                } else {
                    this.hasTreeFeatures = true;
                }
            } else {
                this.hasTreeFeatures = false;
            }
        }

    }

    public int getNumberOfUniquePaths() { return numberOfPaths; }

    public List<UniquePath> getUniquePaths() {
        return uniquePaths;
    }
}
