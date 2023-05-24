package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomas Kozakas
 */
public class Node {
    public String name;
    public int weight;
    public List<Node> children;

    public Node(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.children = new ArrayList<>();
    }
}
