document.getElementById('loginForm').addEventListener('submit', async function (e) {
    e.preventDefault();
  
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
  
    try {
      const response = await fetch('http://localhost:8080/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, password }),
      });
  
      if (response.ok) {
        const data = await response.json();
        alert('Login successful!');
        console.log(data);
        // Redirect to another page or store the token if needed
        window.localStorage.setItem('user', JSON.stringify(data.user));
        window.location.href = 'calculator.html';
      } else {
        alert('Login failed! Please check your credentials.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('An error occurred while logging in.');
    }
  });