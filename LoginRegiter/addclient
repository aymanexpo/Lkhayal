<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['fName']) && isset($_POST['lName']) && isset($_POST['clientEmail']) && isset($_POST['Passwd']) &&
isset($_POST['clientPhone'])) {
    if ($db->dbConnect()) {
        if ($db->addClient("clients", $_POST['fName'],$_POST['lName'], $_POST['clientEmail'], $_POST['Passwd'], $_POST['clientPhone'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";


?>
