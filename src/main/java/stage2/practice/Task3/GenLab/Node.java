package stage2.practice.Task3.GenLab;

public class Node {
        int n;
        String name;
        boolean visited;

        Node(int n, String name) {
            this.n = n;
            this.name = name;
            visited = false;
        }

        void visit() {
            visited = true;
        }

        void unvisit() {
            visited = false;
        }

    public boolean isVisited() {
            return visited=true;
    }
}

