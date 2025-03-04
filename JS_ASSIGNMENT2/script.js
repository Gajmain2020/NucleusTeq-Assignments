const startScreen = document.getElementById("start-screen");
const quizScreen = document.getElementById("quiz-screen");
const resultScreen = document.getElementById("result-screen");
const startBtn = document.getElementById("start-btn");
const playAgainBtn = document.getElementById("play-again-btn");
const questionText = document.getElementById("question-text");
const optionsContainer = document.getElementById("options-container");
const timerText = document.getElementById("time-left");
const finalScore = document.getElementById("final-score");

let currentQuestionIndex = 0;
let questions = [];
let score = 0;
let timer;
let timeLeft = 15;

// Event listener for start button click
startBtn.addEventListener("click", async () => {
  const category = document.getElementById("category").value;
  const difficulty = document.getElementById("difficulty").value;

  // Disable the button to preevent multiple API calls
  startBtn.innerText = "Fetching Questions...";
  startBtn.style.backgroundColor = "#808080";
  startBtn.disabled = true;

  await fetchQuestions(category, difficulty);
});

// Event listener for play again button
playAgainBtn.addEventListener("click", () => {
  // Hide result screen and show start screen
  resultScreen.classList.add("hidden");
  startScreen.classList.remove("hidden");

  // Reset scoore and question index
  score = 0;
  currentQuestionIndex = 0;

  // Reset the start button state
  startBtn.innerText = "Start Quiz";
  startBtn.style.backgroundColor = ""; // Reset to default
  startBtn.disabled = false;
});

// Function to fetch questions from API
async function fetchQuestions(category, difficulty) {
  const url = `https://opentdb.com/api.php?amount=5&category=${category}&difficulty=${difficulty}&type=multiple`;
  const response = await fetch(url);
  const data = await response.json();

  // Map the API response to the format needed for the quiz
  questions = data.results.map((q) => ({
    question: q.question,
    options: [...q.incorrect_answers, q.correct_answer].sort(
      () => Math.random() - 0.5
    ), // Shuffle options randomly
    correctAnswer: q.correct_answer,
  }));

  startQuiz();
}

// Function to start the quiz
function startQuiz() {
  startScreen.classList.add("hidden");
  quizScreen.classList.remove("hidden");
  loadQuestion();
}

// Function to load a new question
function loadQuestion() {
  if (currentQuestionIndex >= questions.length) {
    endGame(); // End game if all questions are completed
    return;
  }

  const currentQuestion = questions[currentQuestionIndex];
  questionText.innerHTML = currentQuestion.question;
  optionsContainer.innerHTML = ""; // Clear previous options

  // Create buttons for each option
  currentQuestion.options.forEach((option) => {
    const button = document.createElement("button");
    button.classList.add("option");
    button.innerHTML = option;
    button.onclick = () => checkAnswer(option, currentQuestion.correctAnswer);
    optionsContainer.appendChild(button);
  });

  timeLeft = 15; // Reset time for new question
  timerText.textContent = timeLeft;
  startTimer(); // Start countdown timer
}

// Function to start the timer
function startTimer() {
  clearInterval(timer);
  timer = setInterval(() => {
    timeLeft--;
    timerText.textContent = timeLeft;
    if (timeLeft === 0) {
      clearInterval(timer);
      showCorrectAnswer(); // Show correct answerr when time runs out
      setTimeout(() => {
        currentQuestionIndex++;
        loadQuestion();
      }, 2000);
    }
  }, 1000);
}

// Function to check if selected answer is correct
function checkAnswer(selected, correct) {
  clearInterval(timer); // Stop timer when user selects an answer
  const buttons = document.querySelectorAll(".option");

  buttons.forEach((button) => {
    if (button.innerHTML === correct) {
      button.classList.add("correct"); // Highlight correct answer
    }
    if (button.innerHTML === selected && selected !== correct) {
      button.classList.add("wrong"); // Highlight wrong answer
    }
    button.disabled = true; // Disable all options after selection
  });

  if (selected === correct) {
    score++; // Increase score for correct answer
  }

  // Move to next question after a delay
  setTimeout(() => {
    currentQuestionIndex++;
    loadQuestion();
  }, 2000);
}

// Function to show the correct answer if time runs out
function showCorrectAnswer() {
  document.querySelectorAll(".option").forEach((button) => {
    if (button.innerHTML === questions[currentQuestionIndex].correctAnswer) {
      button.classList.add("correct");
    }
    button.disabled = true; // Disable options after revealing correct answer
  });
}

// Function to end the game and show results
function endGame() {
  quizScreen.classList.add("hidden");
  resultScreen.classList.remove("hidden");
  finalScore.textContent = `${score} / ${questions.length}`; // Show final scoore
}
