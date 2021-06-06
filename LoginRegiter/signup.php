<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['userFName']) && isset($_POST['userLName']) && isset($_POST['userEmail']) && isset($_POST['userPasswd']) &&
isset($_POST['userPhone'])) {
    if ($db->dbConnect()) {
        if ($db->signUp("user", $_POST['userFName'],$_POST['userLName'], $_POST['userEmail'], $_POST['userPasswd'], $_POST['userPhone'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";


?>
