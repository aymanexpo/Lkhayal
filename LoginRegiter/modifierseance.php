<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
    $conn= mysqli_connect("localhost","root","")or die("Erreur de connexion au serveur");
    mysqli_select_db($conn,'equi')or die("Erreur de connexion a la base");
		$seanceID = $_POST['seanceID'];
		$clientID = $_POST['clientID'];
		$monitorID = $_POST['monitorID'];
		$startDate = $_POST['startDate'];
		$durationMinut = $_POST['durationMinut'];
		$comments = $_POST['comments'];

$query = 'update seances  set seanceID = "'.$seanceID.'",clientID = "'.$clientID.'",monitorID = "'.$monitorID.'",startDate= "'.$startDate.'" ,durationMinut = "'.$durationMinut.'" ,comments = "'.$comments.'"   where seanceID ="'.$seanceID.'"';
if (mysqli_query($conn , $query)){
	echo "1";
}
else 
{
	echo "0";
}
mysqli_close($conn);
}

?>