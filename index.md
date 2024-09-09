---
layout: base
title: Student Home 
description: Home Page
hide: true
---

My journey starts here.

<style>
.page-header {
  color: $header-heading-color;
  text-align: center;
  background-color: $header-bg-color;
  background-image: conic-gradient(from 215deg, $header-bg-color, $header-bg-color-secondary) !important;
</style>
## About Me
- <p> Name: Arnav Nadar</p> 
- <p> Period 1 - Photography 1
- <p> Period 2 - AP Physics C: Mechanics
- <p> Period 3 - AP CSA
- <p> Period 4 - AP Statistics 
- <p> Period 5 - US History 1
- <p>I am a Junior so Class of 2026</p>



<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Header Color</title>
    <style>
        #header {
            padding: 20px;
            text-align: center;
            color: white;
            background: #2921ff; /* Default header color */
            transition: background 0.3s ease; /* Smooth transition for color change */
        }
    </style>
</head>
<body>

    <div id="header">
        <h1>Page Header</h1>
    </div>

    <p>Enter your preferred color codes for the Color Block:</p>
    
    <label for="headerColor1">Color 1:</label>
    <input type="text" id="headerColor1" name="headerColor1" placeholder="#2921ff">

    <label for="headerColor2">Color 2:</label>
    <input type="text" id="headerColor2" name="headerColor2" placeholder="#00ff62">

    <button onclick="applyColors()">Apply Colors</button>

    <script>
        function applyColors() {
            // Get the color codes from the input fields
            var color1 = document.getElementById('headerColor1').value;
            var color2 = document.getElementById('headerColor2').value;
            
            // Validate color codes (basic check for hex format)
            var hexPattern = /^#[0-9A-Fa-f]{6}$/;
            if (hexPattern.test(color1) && hexPattern.test(color2)) {
                // Apply the colors to the header background
                document.getElementById('header').style.background = `linear-gradient(${color1}, ${color2})`;
            } else {
                alert('Please enter valid hex color codes (e.g., #ff0000).');
            }
        }
    </script>

- My favorite colors: 
    -> Dark Blue #0000FF
    -> Black: #000000
    -> Green: #008000
    -> Red: #FF0000
</body>
</html>



## Plans for CSA

  - Have proper and consistent commits
  - Get a better understanding of algorithms and code
  - Learn how to code better in general 

