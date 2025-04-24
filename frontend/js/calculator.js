document.getElementById('bmiCalorieForm').addEventListener('submit', function (e) {
    e.preventDefault();

    // Input values
    const height = parseFloat(document.getElementById('height').value) / 100; // Convert cm to meters
    const weight = parseFloat(document.getElementById('weight').value);
    const age = parseInt(document.getElementById('age').value);
    const activityLevel = document.getElementById('activityLevel').value;

    // BMI Calculation
    const bmi = (weight / (height * height)).toFixed(2);

    // Calorie Calculation (Mifflin-St Jeor Equation)
    // Assuming gender is male for simplicity (can be modified later)
    const bmr = 10 * weight + 6.25 * (height * 100) - 5 * age + 5; // Basal Metabolic Rate (BMR)
    let calorieNeeds;

    switch (activityLevel) {
        case 'sedentary':
            calorieNeeds = bmr * 1.2;
            break;
        case 'light':
            calorieNeeds = bmr * 1.375;
            break;
        case 'moderate':
            calorieNeeds = bmr * 1.55;
            break;
        case 'active':
            calorieNeeds = bmr * 1.725;
            break;
        default:
            calorieNeeds = bmr;
    }

    // Display results
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = `
        <h3>Results</h3>
        <p><strong>BMI:</strong> ${bmi} (${getBmiCategory(bmi)})</p>
        <p><strong>Daily Calorie Needs:</strong> ${calorieNeeds.toFixed(2)} kcal</p>
    `;
    resultDiv.classList.add('result-box'); // Add styling class
});

// Helper function to get BMI category
function getBmiCategory(bmi) {
    if (bmi < 18.5) return 'Underweight';
    if (bmi >= 18.5 && bmi < 24.9) return 'Normal weight';
    if (bmi >= 25 && bmi < 29.9) return 'Overweight';
    return 'Obesity';
}