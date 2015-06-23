public class Solution {
    static class Vertex {
        int id;
        
        Set<Integer> in = new HashSet<Integer>();
        Set<Integer> out = new HashSet<Integer>();
        
        public Vertex(int id) {
            this.id = id;
        }
        
        public boolean isSink() {
            return out.isEmpty();
        }
    }
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Vertex> vertexs = new HashMap<Integer, Vertex>();
        
        for (int[] p : prerequisites) {
            if (!vertexs.containsKey(p[0])) {
                vertexs.put(p[0], new Vertex(p[0]));
            }
            vertexs.get(p[0]).out.add(p[1]);
            if (!vertexs.containsKey(p[1])) {
                vertexs.put(p[1], new Vertex(p[1]));
            }
            vertexs.get(p[1]).in.add(p[0]);
        }
        
        outer:
        while (!vertexs.isEmpty()) {
            for (Map.Entry<Integer, Vertex> entry : vertexs.entrySet()) {
                Vertex v = entry.getValue();
                if (v.isSink()) {
                    vertexs.remove(v.id);
                    
                    for (Integer id : v.in) {
                        vertexs.get(id).out.remove(v.id);
                    }
                    
                    continue outer;
                }
            }
            
            return false;
        }
        
        return true;
    }
}