<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['startDate']) && isset($_POST['durationMinut']) && isset($_POST['title']) && isset($_POST['detail']) &&
isset($_POST['user_Fk'])) {
    if ($db->dbConnect()) {
        if ($db->addTache("tasks",$_POST['startDate'], $_POST['durationMinut'], $_POST['title'],  $_POST['detail'],$_POST['user_Fk'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";


?>