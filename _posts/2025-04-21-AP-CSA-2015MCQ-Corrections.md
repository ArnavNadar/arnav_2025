---
toc: true
layout: post
title: AP CSA MCQ Corrections
description: MCQ Corrections
type: reference
comments: true
permalink: /2015mcqCorrections
categories: [AP CSA, Java]
---

![Image](https://github.com/user-attachments/assets/6c89bbfd-8ef9-4da0-b4d5-c3b1bb265cd3)




-----------------------------------------------------------------------------------------------------------------------------------------------



![Image](https://github.com/user-attachments/assets/6c577e31-e2cc-4c1d-80fe-54f64da3667c)

What I Did Wrong
I made a mistake in how I was calling methods. I think I overcomplicated the accessor method calls by trying to use equals() when I should have just used simple getter methods.
What I Need to Improve

Understand the correct way to call getter methods in Java
Practice writing clean, straightforward method calls
Remember that getMethodName() is used directly on the object
Stop trying to add unnecessary complexity to simple method calls



![Image](https://github.com/user-attachments/assets/099ffda9-fa44-4d82-ab7a-a37156539049)

What I Did Wrong
I miscounted the number of iterations in the nested loops. I selected 8 when the actual count was 10.
What I Need to Improve

Slow down and carefully trace through nested loop executions
Draw out loop iterations to visualize the progression
Practice counting loop increments more carefully
Understand how nested loops interact and increment counters



![Image](https://github.com/user-attachments/assets/b1182b5b-27d3-4362-8511-b6e8eec6ff11)

What I Need to Improve

Pay closer attention to loop conditions and printing logic
Practice visualizing how nested loops create patterns
Take time to trace each iteration carefully
Understand how different loop parameters affect output



![Image](https://github.com/user-attachments/assets/97aee468-c1b1-4ccf-9cf8-c6d440bf8470)

What I Did Wrong
I selected option D, which was incorrect. I didn't properly understand how the recursive method showMe() works when called with different argument values.
Understanding the Method
The method has a recursive structure:

```java

public static void showMe(int arg) {
    if (arg < 10) {
        showMe(arg + 1);
    } else {
        System.out.print(arg + " ");
    }
}


```

My Misunderstanding

I didn't trace the recursive calls correctly
I didn't understand how the base condition (arg < 10) affects the method's behavior
I failed to follow the method's execution path step by step

What I Need to Improve

Practice tracing recursive method calls
Understand base conditions in recursive methods
Visualize how recursive calls build up and resolve
Slow down and carefully follow the method's logic
Learn to track method calls and their arguments mentally

