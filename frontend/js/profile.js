document.addEventListener('DOMContentLoaded', async function () {
    const userId = JSON.parse(window.localStorage.getItem('user')).id;
  
    try {
      const response = await fetch(`http://localhost:8080/api/profile/${userId}`);
      const data = await response.json();
  
      document.getElementById('username').value = data.username;
      document.getElementById('email').value = data.email;
      document.getElementById('age').value = data.age;
      document.getElementById('weight').value = data.weight;
      document.getElementById('height').value = data.height;
    } catch (error) {
      console.error('Error fetching profile:', error);
      alert('Failed to load profile.');
    }
  
    document.getElementById('profileForm').addEventListener('submit', async function (e) {
      e.preventDefault();
  
      const updatedProfile = {
        email: document.getElementById('email').value,
        age: parseInt(document.getElementById('age').value),
        weight: parseFloat(document.getElementById('weight').value),
        height: parseFloat(document.getElementById('height').value),
      };
  
      try {
        const response = await fetch(`http://localhost:8080/api/profile/${userId}`, {
          method: 'PUT',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify(updatedProfile),
        });
  
        if (response.ok) {
          alert('Profile updated successfully!');
        } else {
          alert('Failed to update profile.');
        }
      } catch (error) {
        console.error('Error updating profile:', error);
        alert('An error occurred while updating your profile.');
      }
    });
});