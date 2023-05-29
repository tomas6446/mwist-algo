package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tomas Kozakas
 */

/*
    Pseudocode for Maximum-Weight Independent Set on Trees:

    1. Root the tree at a node r.
    2. Traverse all nodes of T in post-order:
        a. If the node is a leaf, then set the values:
           M_out[node] = 0
           M_in[node] = w_node
        b. Else for other nodes, set the values:
           M_out[node] = Sum(max(M_out[child], M_in[child])) for all child of node
           M_in[node] = w_node + Sum(M_out[child]) for all child of node
    3. Return max(M_out[r], M_in[r])
*/
public class Mwist {
    private final Map<Node, Integer> M_in = new HashMap<>();
    private final Map<Node, Integer> M_out = new HashMap<>();

    public int maxWeightIndependentSet(Node root) {
        computeWeights(root);
        return Math.max(M_out.get(root), M_in.get(root));
    }

    private void computeWeights(Node node) {
        if (node.children.isEmpty()) {  // node is a leaf
            M_in.put(node, node.weight);
            M_out.put(node, 0);
        } else {
            for (Node child : node.children) {
                computeWeights(child);
            }
            M_in.put(node, node.weight + node.children.stream().mapToInt(n -> M_out.get(n)).sum());
            M_out.put(node, node.children.stream().mapToInt(n -> Math.max(M_out.get(n), M_in.get(n))).sum());
        }

        // print M_in and M_out for the node
        System.out.printf("Node %s: M_in = %d, M_out = %d%n", node.name, M_in.get(node), M_out.get(node));
    }
}
