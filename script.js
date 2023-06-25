var randomId = "random_id_" + Math.floor(Math.random() * Math.floor(10));
var alertEl = document.getElementById("alertEmpty");
alertEl.id = randomId;

function login(e) {
  e.preventDefault();

  var username = document.getElementById("username").value;
  var password = document.getElementById("password").value;

  if (username === "" && password === "") {
    document.getElementById(randomId).style.display = "block";
    document.getElementById("alertEmpty").style.display = "none";
    document.getElementById(randomId).className = "alert alert-warning";
    document.getElementById(randomId).innerText = "Both Username and Password must be present";
    return;
  }

  if (username === "" && password !== "") {
    document.getElementById(randomId).style.display = "block";
    document.getElementById("alertEmpty").style.display = "none";
    document.getElementById(randomId).className = "alert alert-warning";
    document.getElementById(randomId).innerText = "Username must be present";
    return;
  }

  if (username !== "" && password === "") {
    document.getElementById(randomId).style.display = "block";
    document.getElementById("alertEmpty").style.display = "none";
    document.getElementById(randomId).className = "alert alert-warning";
    document.getElementById(randomId).innerText = "Password must be present";
    return;
  }

  // Update id after every submission
  var newAlertEl = document.getElementById(randomId);
  randomId = "random_id_" + Math.floor(Math.random() * Math.floor(10));
  newAlertEl.id = randomId;

  var urlParams = new URLSearchParams(window.location.search);
  if (urlParams.get("showAd") === "true") {
    window.location = "/assignment/home.html?showAd=true";
  } else {
    window.location = "/assignment/home.html";
  }
}

document.getElementById('log-in').onclick = login;

    