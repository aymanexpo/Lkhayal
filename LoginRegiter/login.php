<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['userEmail']) && isset($_POST['userPasswd'])) {
    if ($db->dbConnect()) {
        if ($db->logIn("user", $_POST['userEmail'], $_POST['userPasswd'])) {
            echo "connecter";
        } else echo "Username or Password wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>
