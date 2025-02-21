---
layout: base
title: Student Home 
description: Home Page
hide: true
---

# Welcome to My Journey

<div class="header-section">
  <h2>About Me</h2>
  <p>My journey starts here. I'm passionate about computer science and learning new technologies.</p>
</div>

<div class="color-picker-section">
  <h2>Customize Header Colors</h2>
  <div class="color-inputs">
    <div class="input-group">
      <label for="headerColor1">Primary Color:</label>
      <input type="text" id="headerColor1" name="headerColor1" placeholder="#2921ff">
    </div>
    <div class="input-group">
      <label for="headerColor2">Secondary Color:</label>
      <input type="text" id="headerColor2" name="headerColor2" placeholder="#00ff62">
    </div>
    <button onclick="applyColors()" class="apply-button">Apply Colors</button>
  </div>
</div>

<div class="favorite-colors">
  <h2>My Favorite Colors</h2>
  <div class="color-grid">
    <div class="color-item" style="background-color: #0000FF">Dark Blue</div>
    <div class="color-item" style="background-color: #000000; color: white">Black</div>
    <div class="color-item" style="background-color: #008000">Green</div>
    <div class="color-item" style="background-color: #FF0000">Red</div>
  </div>
</div>

<div class="game-section">
  <h2>Tic Tac Toe</h2>
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
  <h3 id="status"></h3>
  <button id="reset" class="reset-button">Reset Game</button>
</div>

<div class="plans-section">
  <h2>Plans for CSA</h2>
  <ul>
    <li>Have proper and consistent commits</li>
    <li>Get a better understanding of algorithms and code</li>
    <li>Learn how to code better in general</li>
  </ul>
</div>

<style>
.header-section, .color-picker-section, .favorite-colors, .game-section, .plans-section {
  margin: 2rem 0;
  padding: 1.5rem;
  border-radius: 8px;
  background-color: #f8f9fa;
}

.color-inputs {
  display: flex;
  gap: 1rem;
  align-items: center;
  flex-wrap: wrap;
}

.input-group {
  display: flex;
  flex-direction: column;
  gap: 0.5rem;
}

.apply-button, .reset-button {
  padding: 0.5rem 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.apply-button:hover, .reset-button:hover {
  background-color: #0056b3;
}

.color-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: 1rem;
  margin-top: 1rem;
}

.color-item {
  padding: 1rem;
  border-radius: 4px;
  text-align: center;
  font-weight: bold;
}

.board {
  display: grid;
  grid-template-columns: repeat(3, 100px);
  grid-gap: 10px;
  justify-content: center;
  margin: 2rem auto;
}

.cell {
  width: 100px;
  height: 100px;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2rem;
  border: 2px solid #333;
  cursor: pointer;
  background-color: white;
  transition: background-color 0.3s;
}

.cell:hover {
  background-color: #f0f0f0;
}

#status {
  text-align: center;
  margin: 1rem 0;
}

.plans-section ul {
  list-style-type: none;
  padding-left: 0;
}

.plans-section li {
  padding: 0.5rem 0;
  border-bottom: 1px solid #dee2e6;
}

.plans-section li:last-child {
  border-bottom: none;
}
</style>

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

