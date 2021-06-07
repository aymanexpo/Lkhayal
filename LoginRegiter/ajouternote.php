<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['clientID']) && isset($_POST['notes'])) {
    if ($db->dbConnect()) {
        if ($db->addNote("clients", $_POST['clientID'], $_POST['notes'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";


?>
