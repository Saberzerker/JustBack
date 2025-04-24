document.getElementById("loginForm")?.addEventListener("submit", async (e) => {
    e.preventDefault();
    console.log("Login form submitted");

    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    console.log("Email:", email, "Password:", password);

    try {
        const response = await fetch("http://localhost:8080/api/auth/login", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password }),
        });

        console.log("Response:", response);

        if (response.ok) {
            const data = await response.json();
            console.log("Login successful:", data);
            alert("Login successful!");
            window.location.href = "calculator.html";
        } else {
            console.error("Login failed:", await response.text());
            alert("Login failed! Please check your credentials.");
        }
    } catch (error) {
        console.error("Error during login:", error);
        alert("An unexpected error occurred during login.");
    }
}); 