---
title: A* Algorithm Homework Solution
permalink: /homework/a-star-algorithm-solution
---

# A* Algorithm Homework Solution

## 1. Short Problem

### Problem:
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

Edge weights:
- A–B = 2
- A–C = 4
- B–C = 3
- B–D = 5
- C–D = 1

Heuristic estimates h(n) (straight‑line distance to D):
- h(A) = 6
- h(B) = 4
- h(C) = 2
- h(D) = 0

### Solution:

Let's solve this step by step using A* algorithm. We'll keep track of:
- g(n): cost from start to current node
- h(n): heuristic estimate to goal
- f(n) = g(n) + h(n): total estimated cost

#### Step 1: Start at A
- A: g(A) = 0, h(A) = 6, f(A) = 0 + 6 = 6

#### Step 2: Expand A
Neighbors of A:
- B: g(B) = 2, h(B) = 4, f(B) = 2 + 4 = 6
- C: g(C) = 4, h(C) = 2, f(C) = 4 + 2 = 6

Select B (tie-break with lower g-value)

#### Step 3: Expand B
Neighbors of B:
- C: g(C) = 2 + 3 = 5, h(C) = 2, f(C) = 5 + 2 = 7
- D: g(D) = 2 + 5 = 7, h(D) = 0, f(D) = 7 + 0 = 7

Select C (lower f-value)

#### Step 4: Expand C
Neighbors of C:
- D: g(D) = 4 + 1 = 5, h(D) = 0, f(D) = 5 + 0 = 5

Select D (goal reached)

### Final Answer:
- Shortest path: A → C → D
- Total cost: 5 (4 + 1)

## 2. Multiple‑Choice Questions

1. Which property of a heuristic h(n) guarantees that A* will find the optimal path?
   - **B. Admissibility**
   - Explanation: A heuristic is admissible if it never overestimates the true cost to reach the goal. This property ensures that A* will always find the optimal path.

2. Greedy Best‑First Search selects which node to expand next?
   - **B. The node with the smallest h(n) (estimated cost to goal)**
   - Explanation: Greedy Best-First Search only considers the heuristic value h(n) and ignores the actual cost g(n) from the start node.

3. On a 4‑connected grid (no diagonal moves), which of these is an admissible heuristic for pathfinding?
   - **B. Manhattan distance**
   - Explanation: Manhattan distance is admissible for 4-connected grids because it never overestimates the actual path cost when only horizontal and vertical moves are allowed.

4. Which of the following is a drawback of Greedy Best‑First Search compared to A*?
   - **B. It may expand nodes in non‑optimal order and fail to find the shortest path**
   - Explanation: Greedy Best-First Search only considers the heuristic value and ignores the actual cost from the start, which can lead to suboptimal paths. 