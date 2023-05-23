# Graphs Data Structure

Instructions

- Download notes
- Download Assignments

---

Tables of contents

- BFS
- DFS
- All paths
- Cycle detection in directed graph
- Topological Sorting
- Cycle detection in un-directed graph
- Shortest path algos
  - Dijkstra's algorithm
  - Bellman ford algorithm
- Minimum Spanning Tree
  - Prim's Algorithm
- Strongly Components
  - Kosaraju's Algorithm

---

## BFS

```java

static void bfs(ArrayList<Edge> graph[], int start){
  Queue<Integer> queue = new LinkedList<>();
  boolean vis []= new boolean[];

  queue.add(start);
  vis[start] = true;

  while(!queue.isEmpty()){
    int curr = queue.pop();
    System.out.println(curr);

    for(Edge e : graph[curr]){
      if(!vis[e.dest]){
        vis[e.dest] = true;
        queue.add(e.dest);
      }
    }
  }
}

```

## DFS

### Method-1 (recursion)

```java

static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]){
  vis[curr] = true;
  System.out.println(curr);

  for(Edge e : graph[curr]){
    if(!vis[e.dest]){
      dfs(e.dest);
    }
  }
}

```

### Method-2 (using stack)

```java

static void dfs(ArrayList<Edge> graph[], int start){
  Stack<Integer> stack = new Stack<>();
  boolean vis []= new boolean[];

  stack.add(start);
  vis[e.dest] = true;

  while(!stack.isEmpty()){
    int curr = queue.pop();
    System.out.println(curr);

    for(Edge e : graph[curr]){
      if(!vis[e.dest]){
        vis[e.dest] = true;
        stack.push(e.dest);
      }
    }
  }
}

```

## All Paths

```java

static void allPath(ArrayList<Edge> graph[], boolean vis[], int curr, String path, int target){
  vis[curr] = true;

  if(curr == target){
    System.out.println(path+curr);
    return;
  }

  for(Edge e : graph[curr]){
    if(!vis[e.dest]){
      allPath(graph, vis, e.dest, path+curr+"-",target);
    }
  }
}

```

## Cycle detection in un-directed Graphs

```java

static boolean hasCycle(ArrayList<Edge> graph[], int curr, boolean vis[], boolean recur[]){
  vis[curr] = true;
  recur[curr] = true;

  for(Edge e : graph[curr]){
    if(recur[e.dest]){
      return true;
    }
    return hasCycle(graph, e.dest, vis, recur);
  }

  recur[curr] = false;
  return false;
}

```
