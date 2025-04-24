document.getElementById('calorieForm').addEventListener('submit', async function (e) {
    e.preventDefault();
  
    const activityType = document.getElementById('activityType').value;
    const weight = parseFloat(document.getElementById('weight').value);
    const duration = parseInt(document.getElementById('duration').value);
  
    try {
      const response = await fetch('http://localhost:8080/api/calculate-calories', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ activityType, weight, duration }),
      });
  
      if (response.ok) {
        const data = await response.json();
        document.getElementById('result').innerHTML = `Calories Burned: ${data.caloriesBurned}`;
      } else {
        document.getElementById('result').innerHTML = 'Error calculating calories. Please try again.';
      }
    } catch (error) {
      console.error('Error:', error);
      document.getElementById('result').innerHTML = 'An error occurred while calculating calories.';
    }
  });