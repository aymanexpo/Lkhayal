<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['clientEmail']) && isset($_POST['passwd'])) {
    if ($db->dbConnect()) {
        if ($db->loginclient("clients", $_POST['clientEmail'], $_POST['passwd'])) {
            echo "connecter";
            //$clientLidakhel= $client;
        } else echo "Username or Password wrong";
    } else echo "Error: Database connection";
} else echo "All fields are required";
?>