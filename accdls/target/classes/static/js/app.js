function register() {
    const username = document.getElementById("regUser").value;
    const password = document.getElementById("regPass").value;
    const email = document.getElementById("regEmail").value;

    fetch("http://localhost:8080/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username,
            password: password,
            email: email
        })
    })
        .then(res => res.text())
        .then(data => alert(data));
}


function login() {
    const username = document.getElementById("loginUser").value;
    const password = document.getElementById("loginPass").value;

    fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
        .then(res => res.text())
        .then(data => alert(data));
}


/* Toggle UI */
function showRegister() {
    document.getElementById("loginForm").classList.add("hidden");
    document.getElementById("registerForm").classList.remove("hidden");
}

function showLogin() {
    document.getElementById("registerForm").classList.add("hidden");
    document.getElementById("loginForm").classList.remove("hidden");
}