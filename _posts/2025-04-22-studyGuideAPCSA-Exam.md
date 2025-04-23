---
toc: true
layout: post
title: AP CSA Study Guide
description: Study guide to help for AP CSA Exam
type: progress
comments: true
permalink: /ap-study-guide
categories: [AP CSA]
---

# AP Computer Science A — Study Guide

---

## Unit 1: Primitive Types
- Know basic data types: `int`, `double`, `boolean`, `char`
- Understand variable declaration and initialization
- Perform arithmetic operations: `+`, `-`, `*`, `/`, `%`
- Difference between integer division and floating-point division
- Type casting:
  - Widening: `int` → `double`
  - Narrowing (explicit): `double` → `int`
- Use `final` keyword to create constants

---

## Unit 2: Using Objects
- Create objects using the `new` keyword and constructors
- Understand how to call instance methods (e.g., `str.length()`)
- Know important `String` methods:
  - `.substring(start, end)`
  - `.indexOf(str)`
  - `.equals(str)` for content comparison (not `==`)
- Use static methods from the `Math` class: `Math.abs()`, `Math.pow()`, `Math.random()`
- Understand autoboxing: converting between primitives and wrapper classes (e.g., `int` ↔ `Integer`)

---

## Unit 3: Boolean Expressions and if Statements
- Use comparison operators: `==`, `!=`, `<`, `>`, `<=`, `>=`
- Use logical operators:
  - `&&` (AND)
  - `||` (OR)
  - `!` (NOT)
- Write conditional logic with:
  - `if`
  - `else if`
  - `else`
- Understand short-circuit evaluation:
  - In `&&`, if first is false, second is not checked
  - In `||`, if first is true, second is not checked
- Practice writing truth tables and tracing conditions

---

## Unit 4: Iteration
- Use different loops:
  - `while` — when the number of iterations is unknown
  - `for` — when looping a known number of times
  - `for-each` — to loop through elements in a collection
- Learn common loop tasks:
  - Counting
  - Summing
  - Finding max/min
- Use `break` to exit a loop early, `continue` to skip current iteration
- Practice nested loops (loops inside loops)

---

## Unit 5: Writing Classes
- Define a class with fields (instance variables)
- Write constructors to initialize object data
- Use the `this` keyword to refer to current object
- Write getter (accessor) and setter (mutator) methods
- Understand method overloading (same name, different parameters)
- Practice encapsulation: keep fields `private`, use `public` methods to access them

---

## Unit 6: Array
- Declare and initialize arrays: `int[] nums = new int[5];`
- Access elements using index: `nums[0]`
- Use loops to iterate through arrays
- Practice common array algorithms:
  - Calculate average
  - Count specific values
  - Find max/min
  - Shift or reverse elements
- Be careful with `ArrayIndexOutOfBoundsException`

---

## Unit 7: ArrayList
- Import and declare: `ArrayList<String> list = new ArrayList<>();`
- Dynamic size — no need to define length at creation
- Core methods:
  - `add(element)`
  - `get(index)`
  - `set(index, element)`
  - `remove(index)`
  - `size()`
- Loop through ArrayLists with `for` or enhanced `for`
- Remember: use `.equals()` to compare objects, not `==`

---

## Unit 8: 2D Array
- Declare a 2D array: `int[][] grid = new int[3][4];`
- Access elements with two indices: `grid[row][col]`
- Use nested loops to process all elements
- Common patterns:
  - Row sums
  - Column sums
  - Find a specific value
  - Modify based on row/column index
- Practice both `row-major` and `column-major` order

---

## Unit 9: Inheritance
- Use `extends` to create a subclass (e.g., `class Dog extends Animal`)
- Subclass inherits fields and methods from superclass
- Override methods using `@Override`
- Use `super()` to call parent constructor or methods
- Use polymorphism:
  - Superclass reference, subclass object (e.g., `Animal a = new Dog();`)
  - Method that behaves differently depending on object type
- `instanceof` checks object type before casting

---

## Unit 10: Recursion
- A method that calls itself to solve a smaller problem
- Must have:
  - Base case (stopping condition)
  - Recursive call (simpler version of the problem)
- Understand how the call stack works (LIFO)
- Trace and debug recursive functions
- Common examples:
  - Factorial
  - Fibonacci
  - Sum of array
  - Recursive search
- Know when recursion is helpful vs. when iteration is simpler