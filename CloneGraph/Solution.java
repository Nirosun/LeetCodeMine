/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)	return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map =
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            if (!map.containsKey(n)) {
                map.put(n, new UndirectedGraphNode(n.label));
                for (UndirectedGraphNode neighbor : n.neighbors) {
                    queue.add(neighbor);
                }
            }
        }

        HashSet<UndirectedGraphNode> visit = new HashSet<UndirectedGraphNode>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            if (!visit.contains(n))	{
                visit.add(n);
                UndirectedGraphNode c = map.get(n);
                for (UndirectedGraphNode neighbor : n.neighbors) {
                    c.neighbors.add(map.get(neighbor));
                    queue.add(neighbor);
                }
            }
        }
        return map.get(node);
    }
}
