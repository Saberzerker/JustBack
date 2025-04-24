document.addEventListener('DOMContentLoaded', async function () {
    const userId = JSON.parse(window.localStorage.getItem('user')).id;
  
    try {
      const response = await fetch(`http://localhost:8080/api/history/${userId}`);
      const history = await response.json();
  
      const historyList = document.getElementById('historyList');
      history.forEach((exercise) => {
        const listItem = document.createElement('li');
        listItem.textContent = `${exercise.type} - ${exercise.duration} mins - ${exercise.caloriesBurned} calories`;
        historyList.appendChild(listItem);
      });
    } catch (error) {
      console.error('Error fetching history:', error);
      alert('Failed to load exercise history.');
    }
  });