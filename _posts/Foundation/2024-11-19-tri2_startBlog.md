---
layout: post
title: Tri 2 Beginning Review
description: AP CSA College Board MCQ Connections and Code from last tri
courses: {'csse': {'week': 1}, 'csp': {'week': 1}, 'csa': {'week': 1}}
comments: True
---

![score](https://github.com/user-attachments/assets/e4878086-ec7d-4dd5-841a-c2f2f0fd161d)


<div class="carousel-container">
  <div class="carousel" id="carousel">
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/47896f45-7de0-438c-8194-e13b50773c92" alt="Q4">
      <p>I forgot that in Java, when dividing two integers, the result is always going to be an integer. So, 7 divided by 3 actually equals 2, not 2.333333.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/9640269b-f74c-4b9b-b65d-bd595a096b5f" alt="Q6">
      <p>I mistakenly thought we needed to compare the average of the two values to the tolerance but, the correct approach is to calculate the absolute difference between d1 and d2 and then check if it's less than or equal to the tolerance. So, the correct answer is indeed option E.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/15a0c6b7-40a7-4b68-9668-4cafa9c50d90" alt="Q14">
      <p>I incorrectly assumed that the v variable would be an index rather than a direct reference to a Vehicle object. The correct expression to replace /expression/ is actually vehicles.get(i).getMileage(). This will access the i-th Vehicle object from the vehicles list and then call its getMileage() method.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/b1166d4b-38d1-498b-977a-3ad19d2e5a8d" alt="Q16">
      <p>The correct expression to replace /index/ is B: k + a1.length. This ensures that the elements of a2 are appended to the end of the result array after the elements of a1.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/ab09b616-0f72-40d8-a60a-eafc90a415f3" alt="Q18">
      <p>I mistakenly thought Math.random() could take a parameter to specify the range of the random number. However, Math.random() generates a random double between 0.0 and 1.0. To get a random index for the list, we need to multiply this value by the list's size and cast it to an integer. Therefore, the correct answer is B.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/6ef6df54-8cec-463c-9102-d87381737c92" alt="Q22">
      <p>I thought that because `bookArray` is declared as a `Book[]`, only the `length()` method defined in the `Book` class would be used. But, Java allows subclasses to override methods from their superclasses. So, when we call `length()` on an `AudioBook` object within the array, the `length()` method defined specifically for `AudioBook` will be used, leading to a compile-time error.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/d2265cef-43f6-4d6f-b25f-2ac891d86f1f" alt="Q23">
      <p>I misunderstood the loop condition. The loop continues as long as k is greater than 0. In the first iteration, k is animals.size() - 1, which is 5. The element at index 5 is "baboon". Since "baboon" starts with "b", it is moved to the beginning of the list.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/49c3f9b5-c114-4e5c-8f08-dfd31826d736" alt="Q24">
      <p>I misunderstood the order in which the newArray is being filled. The code iterates through oldArray and fills newArray in column-major order. This means that it fills the first column, then the second, and so on.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/403f6aee-2ff0-4295-a063-1e7e866f5ea0" alt="Q25">
      <p>I got this wrong because I may have overcomplicated the solution. I might have considered unnecessary factors or conditions, leading me to choose an incorrect option. The correct approach is a straightforward comparison of the dimensions of the two boxes.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/413c96dc-5b0f-4e73-8680-d66b6b2c29f3" alt="Q33">
      <p>The loop condition sum < 12 || k < 4 will always be true because k is never incremented. This leads to an infinite loop, and nothing will be printed.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/dff58ed4-f0d9-408f-a26a-362336642912" alt="Q34">
      <p>The issue with this code is that it attempts to modify the x and y coordinates of the center point directly. However, since x and y are private instance variables within the Point class, they cannot be accessed and modified directly. This will lead to a compile-time error.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/2667e275-ad50-45b5-b275-a428ee8f3911" alt="Q36">
      <p>I overlooked the fact that the second condition in the if statement is redundant. If x is even and greater than 0, it will always be greater than 3.</p>
    </div>
    <div class="flashcard">
      <img src="https://github.com/user-attachments/assets/453a960e-6eaa-4340-ac0c-75bfac627c16" alt="Q38">
      <p>I believe I overcomplicated the solution by trying to distribute the OR operator. The original expression can be simplified using the distributive property of OR over AND.</p>
    </div>
  </div>
  <button class="carousel-button left" onclick="moveCarousel(-1)">&#8249;</button>
  <button class="carousel-button right" onclick="moveCarousel(1)">&#8250;</button>
</div>

<script>
  let currentIndex = 0;

  function moveCarousel(direction) {
    const cards = document.querySelectorAll('.flashcard');
    currentIndex = (currentIndex + direction + cards.length) % cards.length;

    cards.forEach((card, index) => {
      card.style.display = index === currentIndex ? 'block' : 'none';
    });
  }

  // Initialize the carousel
  document.addEventListener('DOMContentLoaded', () => {
    const cards = document.querySelectorAll('.flashcard');
    cards.forEach((card, index) => (card.style.display = index === 0 ? 'block' : 'none'));
  });
</script>

<style>
  .carousel-container {
    position: relative;
    width: 80%;
    margin: auto;
    text-align: center;
  }
  .carousel {
    display: flex;
    flex-wrap: nowrap;
    overflow: hidden;
  }
  .flashcard {
    display: none;
    flex: 0 0 100%;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    border-radius: 10px;
    padding: 20px;
    text-align: center;
  }
  .carousel-button {
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    background: rgba(0, 0, 0, 0.5);
    color: white;
    border: none;
    font-size: 24px;
    padding: 10px;
    cursor: pointer;
  }
  .carousel-button.left {
    left: 0;
  }
  .carousel-button.right {
    right: 0;
  }
</style>
Topics to Work On:

	•	Logical Conditions: Review loops and conditionals to avoid infinite loops or redundant checks.
	•	Indexing and Syntax: Improve accuracy with APIs like Math.random() and array indexing.
	•	Code Flow: Get better at following the flow of logic in loops and arrays.
	•	Debugging Skills: Focus on spotting compile-time vs. runtime errors in code.

![code](https://github.com/user-attachments/assets/367a358d-6193-42bb-bb60-a2bc6b6609d6)
