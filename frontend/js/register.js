document.getElementById('registerForm').addEventListener('submit', async function (e) {
    e.preventDefault();
  
    const userData = {
      username: document.getElementById('username').value,
      email: document.getElementById('email').value,
      password: document.getElementById('password').value,
      age: parseInt(document.getElementById('age').value),
      weight: parseFloat(document.getElementById('weight').value),
      height: parseFloat(document.getElementById('height').value),
    };
  
    try {
      const response = await fetch('http://localhost:8080/api/auth/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(userData),
      });
  
      if (response.ok) {
        alert('Registration successful!');
        window.location.href = 'login.html';
      } else {
        alert('Registration failed! Please try again.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('An error occurred during registration.');
    }
  });