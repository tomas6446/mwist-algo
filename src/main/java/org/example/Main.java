package org.example;

/**
 * @author Tomas Kozakas
 */
public class Main {
    public static void main(String[] args) {
        Node r = new Node("r", 5);
        Node a = new Node("a", 3);
        Node b = new Node("b", 2);
        Node c = new Node("c", 2);

        r.children.add(a);
        r.children.add(b);
        a.children.add(c);

        Tree tree = new Tree();
        System.out.println("Max weight independent set: " + tree.maxWeightIndependentSet(r));
    }
}