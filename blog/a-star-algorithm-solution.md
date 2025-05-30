---
layout: post
title: "Understanding A* Algorithm: A Step-by-Step Solution"
date: 2024-03-19
categories: [algorithms, computer-science]
tags: [a-star, pathfinding, algorithms, heuristics]
author: Arnav Nadar
---

# Understanding A* Algorithm: A Step-by-Step Solution

In this post, we'll solve a practical A* algorithm problem and understand its key concepts through multiple-choice questions. A* is a powerful pathfinding algorithm that combines the best of Dijkstra's algorithm and Greedy Best-First Search.

## Problem Statement

Consider the following graph and heuristic values toward goal D:

```
      (A)
     /   \
   2/     \4
   /       \
 (B) —3— (C)
   \       /
   5\     /1
     \   /
      (D)
```

### Given Information:
- Edge weights:
  - A–B = 2
  - A–C = 4
  - B–C = 3
  - B–D = 5
  - C–D = 1

- Heuristic estimates h(n) (straight‑line distance to D):
  - h(A) = 6
  - h(B) = 4
  - h(C) = 2
  - h(D) = 0

## Step-by-Step Solution

Let's solve this using the A* algorithm. We'll track three important values for each node:
- g(n): cost from start to current node
- h(n): heuristic estimate to goal
- f(n) = g(n) + h(n): total estimated cost

### Step 1: Start at A
- A: g(A) = 0, h(A) = 6, f(A) = 0 + 6 = 6

### Step 2: Expand A
Neighbors of A:
- B: g(B) = 2, h(B) = 4, f(B) = 2 + 4 = 6
- C: g(C) = 4, h(C) = 2, f(C) = 4 + 2 = 6

We select B (tie-break with lower g-value)

### Step 3: Expand B
Neighbors of B:
- C: g(C) = 2 + 3 = 5, h(C) = 2, f(C) = 5 + 2 = 7
- D: g(D) = 2 + 5 = 7, h(D) = 0, f(D) = 7 + 0 = 7

We select C (lower f-value)

### Step 4: Expand C
Neighbors of C:
- D: g(D) = 4 + 1 = 5, h(D) = 0, f(D) = 5 + 0 = 5

We select D (goal reached)

### Final Answer:
- Shortest path: A → C → D
- Total cost: 5 (4 + 1)

## Key Concepts: Multiple-Choice Questions

Let's test our understanding with some key concepts about A* algorithm:

### 1. Optimality Guarantee
**Question:** Which property of a heuristic h(n) guarantees that A* will find the optimal path?

**Answer:** B. Admissibility

**Explanation:** A heuristic is admissible if it never overestimates the true cost to reach the goal. This property ensures that A* will always find the optimal path. If a heuristic overestimates the cost, it might cause the algorithm to miss the optimal path.

### 2. Greedy Best-First Search
**Question:** Greedy Best‑First Search selects which node to expand next?

**Answer:** B. The node with the smallest h(n) (estimated cost to goal)

**Explanation:** Greedy Best-First Search only considers the heuristic value h(n) and ignores the actual cost g(n) from the start node. This makes it faster but potentially less accurate than A*.

### 3. Admissible Heuristics
**Question:** On a 4‑connected grid (no diagonal moves), which of these is an admissible heuristic for pathfinding?

**Answer:** B. Manhattan distance

**Explanation:** Manhattan distance is admissible for 4-connected grids because it never overestimates the actual path cost when only horizontal and vertical moves are allowed. It represents the minimum possible distance between two points on such a grid.

### 4. A* vs Greedy Best-First Search
**Question:** Which of the following is a drawback of Greedy Best‑First Search compared to A*?

**Answer:** B. It may expand nodes in non‑optimal order and fail to find the shortest path

**Explanation:** Greedy Best-First Search only considers the heuristic value and ignores the actual cost from the start, which can lead to suboptimal paths. A* combines both the actual cost and heuristic estimate, making it more reliable for finding optimal paths.

## Conclusion

The A* algorithm is a powerful tool for pathfinding that combines the completeness of Dijkstra's algorithm with the efficiency of heuristic-based search. By using both the actual cost (g) and heuristic estimate (h), it can find optimal paths while being more efficient than pure Dijkstra's algorithm.

The key to A*'s success is using an admissible heuristic - one that never overestimates the true cost. This ensures that the algorithm will always find the optimal path while potentially exploring fewer nodes than other algorithms.

---

*Feel free to leave a comment if you have any questions about the A* algorithm or the solution!*