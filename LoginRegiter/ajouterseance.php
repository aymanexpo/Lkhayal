
<?php
require "DataBase.php";
$db = new DataBase();
if (isset($_POST['seanceID']) && isset($_POST['monitorID']) && isset($_POST['clientID']) && isset($_POST['startDate']) && isset($_POST['durationMinut']) &&
isset($_POST['comments'])) {
    if ($db->dbConnect()) {
        if ($db->addSeance("seances", $_POST['seanceID'],$_POST['monitorID'], $_POST['clientID'], $_POST['startDate'],  $_POST['durationMinut'],$_POST['comments'])) {
            echo "Sign Up Success";
        } else echo "Sign up Failed";
    } else echo "Error: Database connection";
} else echo "All fields are required";


?>