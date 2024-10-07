---
layout: base
title: Student Home 
description: Home Page
hide: true
---



My journey starts here.

<style>
.page-header 
  color: $header-heading-color;
  text-align: center;
  background-color: $header-bg-color;
  background-image: conic-gradient(from 215deg, $header-bg-color, $header-bg-color-secondary) !important;
</style>
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
            transition: background 0.4s ease; /* Smooth transition for color change */
        }
    </style>
</head>
<body>

    <div id="header">
        <h1>Change my color ! </h1>
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

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tic Tac Toe</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }

        .board {
            display: grid;
            grid-template-columns: repeat(3, 100px);
            grid-gap: 10px;
            justify-content: center;
        }

        .cell {
            width: 100px;
            height: 100px;
            display: flex;
            justify-content: center;
            align-items: center;
            font-size: 2rem;
            border: 2px solid black;
            cursor: pointer;
        }

        #status {
            margin-top: 20px;
        }

        button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 1rem;
        }
    </style>
</head>
<body>
    <h1>Tic Tac Toe</h1>
    <div class="board" id="board">
        <div class="cell" data-index="0"></div>
        <div class="cell" data-index="1"></div>
        <div class="cell" data-index="2"></div>
        <div class="cell" data-index="3"></div>
        <div class="cell" data-index="4"></div>
        <div class="cell" data-index="5"></div>
        <div class="cell" data-index="6"></div>
        <div class="cell" data-index="7"></div>
        <div class="cell" data-index="8"></div>
    </div>
    <h2 id="status"></h2>
    <button id="reset">Reset Game</button>

    <script>
        const cells = document.querySelectorAll(".cell");
        const statusText = document.getElementById("status");
        const resetButton = document.getElementById("reset");
        let currentPlayer = "X";
        let gameBoard = ["", "", "", "", "", "", "", "", ""];
        let gameActive = true;

        const winConditions = [
            [0, 1, 2],
            [3, 4, 5],
            [6, 7, 8],
            [0, 3, 6],
            [1, 4, 7],
            [2, 5, 8],
            [0, 4, 8],
            [2, 4, 6]
        ];

        function handleCellClick(e) {
            const cell = e.target;
            const index = cell.getAttribute("data-index");

            if (gameBoard[index] !== "" || !gameActive) return;

            gameBoard[index] = currentPlayer;
            cell.textContent = currentPlayer;

            checkWinner();
            switchPlayer();
        }

        function checkWinner() {
            let roundWon = false;

            for (let i = 0; i < winConditions.length; i++) {
                const condition = winConditions[i];
                const a = gameBoard[condition[0]];
                const b = gameBoard[condition[1]];
                const c = gameBoard[condition[2]];

                if (a === "" || b === "" || c === "") continue;
                if (a === b && b === c) {
                    roundWon = true;
                    break;
                }
            }

            if (roundWon) {
                statusText.textContent = `${currentPlayer} Wins!`;
                gameActive = false;
                return;
            }

            if (!gameBoard.includes("")) {
                statusText.textContent = "Draw!";
                gameActive = false;
                return;
            }
        }

        function switchPlayer() {
            currentPlayer = currentPlayer === "X" ? "O" : "X";
            statusText.textContent = `It's ${currentPlayer}'s turn`;
        }

        function resetGame() {
            currentPlayer = "X";
            gameBoard = ["", "", "", "", "", "", "", "", ""];
            statusText.textContent = `It's ${currentPlayer}'s turn`;
            cells.forEach(cell => cell.textContent = "");
            gameActive = true;
        }

        cells.forEach(cell => cell.addEventListener("click", handleCellClick));
        resetButton.addEventListener("click", resetGame);

        statusText.textContent = `It's ${currentPlayer}'s turn`;
    </script>
</body>
</html>







## Plans for CSA

  - Have proper and consistent commits
  - Get a better understanding of algorithms and code
  - Learn how to code better in general 

