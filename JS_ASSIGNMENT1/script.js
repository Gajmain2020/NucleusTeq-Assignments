document.addEventListener("DOMContentLoaded", function () {
  let currentPlayer = 1;
  let scores = { 1: 0, 2: 0 };
  let currentScores = { 1: 0, 2: 0 };

  const turnIndicator = document.getElementById("turn-indicator");
  const diceImg = document.getElementById("dice");
  const rollBtn = document.getElementById("roll-btn");
  const saveBtn = document.getElementById("save-btn");
  const resetBtn = document.getElementById("reset-btn");
  const winnerMessage = document.getElementById("winner-message");

  function switchPlayer() {
    document.querySelector(".player.active")?.classList.remove("active");
    currentScores[currentPlayer] = 0;
    document.getElementById(`player${currentPlayer}-current`).textContent = "0";
    currentPlayer = currentPlayer === 1 ? 2 : 1;
    document
      .querySelectorAll(".player")
      [currentPlayer - 1].classList.add("active");
  }

  rollBtn.addEventListener("click", function () {
    diceImg.classList.add("roll"); // Start animation

    setTimeout(() => {
      const roll = Math.floor(Math.random() * 6) + 1;
      diceImg.src = `images/dice${roll}.png`; // Update dice image

      setTimeout(() => {
        diceImg.classList.remove("roll"); // Remove animation class AFTER animation finishes
      }, 800); // Adjust this timeout to match the CSS animation duration

      if (roll === 1) {
        switchPlayer();
        turnIndicator.innerHTML = `Player ${currentPlayer}'s Turn`;
      } else {
        currentScores[currentPlayer] += roll;
        document.getElementById(`player${currentPlayer}-current`).textContent =
          currentScores[currentPlayer];
      }
    }, 800); // Wait for the animation before updating the dice face
  });

  saveBtn.addEventListener("click", function () {
    scores[currentPlayer] += currentScores[currentPlayer];
    document.getElementById(`player${currentPlayer}-score`).textContent =
      scores[currentPlayer];

    if (scores[currentPlayer] >= 100) {
      winnerMessage.textContent = `${
        document.getElementById(`player${currentPlayer}-name`).value
      } Wins! 🎉`;
      rollBtn.disabled = true;
      saveBtn.disabled = true;
    } else {
      switchPlayer();
    }
  });

  resetBtn.addEventListener("click", function () {
    scores = { 1: 0, 2: 0 };
    currentScores = { 1: 0, 2: 0 };
    document.getElementById("player1-score").textContent = "0";
    document.getElementById("player2-score").textContent = "0";
    document.getElementById("player1-current").textContent = "0";
    document.getElementById("player2-current").textContent = "0";
    diceImg.src = "images/landing.png"; // Reset dice
    winnerMessage.textContent = "";
    rollBtn.disabled = false;
    saveBtn.disabled = false;
    currentPlayer = 1;
  });
});
