document.addEventListener('DOMContentLoaded', () => {
    const navbar = document.createElement('nav');
    navbar.innerHTML = `
        <ul>
            <li><a href="home.html">Home</a></li>
            <li><a href="profile.html">Profile</a></li>
            <li><a href="calculator.html">BMI & Calorie Calculator</a></li>
            <li><a href="history.html">History</a></li>
            <li><a href="#" id="logExerciseBtn">Log Exercise</a></li>
        </ul>
    `;
    document.body.prepend(navbar);

    // Log Exercise Modal
    const logExerciseBtn = document.getElementById('logExerciseBtn');
    logExerciseBtn.addEventListener('click', () => {
        alert('Log Exercise Modal Coming Soon!');
    });
});