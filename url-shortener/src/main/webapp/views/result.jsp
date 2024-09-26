<html>
<head>
    <title>Shortened URL</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS for glowing button and animations -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
        }
        .glow-btn {
            background-color: #28a745;
            border: none;
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 50px;
            text-decoration: none;
            transition: background-color 0.3s ease, box-shadow 0.3s ease;
            animation: glowing 1.5s infinite;
        }
        .glow-btn:hover {
            background-color: #218838;
        }
        @keyframes glowing {
            0% { box-shadow: 0 0 5px #28a745; }
            50% { box-shadow: 0 0 20px #28a745; }
            100% { box-shadow: 0 0 5px #28a745; }
        }
        .hidden-message {
            display: none;
            font-size: 24px;
            margin-top: 20px;
            color: #17a2b8;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card text-center">
            <div class="card-header bg-success text-white">
                <h2 class="text-center">Shortened URL</h2>
            </div>
            <div class="card-body">
                <p class="lead">Your shortened URL:</p>
                <h3 class="text-success mb-4">${shortUrl}</h3>
                <button id="goButton" class="glow-btn">Click to Open</button>
                <p id="hiddenMessage" class="hidden-message">HERE WE GO...</p>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- JavaScript to handle button click animation -->
    <script>
        document.getElementById("goButton").addEventListener("click", function() {
            document.getElementById("hiddenMessage").style.display = "block";
            setTimeout(function() {
                window.location.href = "${shortUrl}";
            }, 2000); // 2-second delay before redirect
        });
    </script>
</body>
</html>
