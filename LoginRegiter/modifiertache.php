<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
    $conn= mysqli_connect("localhost","root","")or die("Erreur de connexion au serveur");
    mysqli_select_db($conn,'equi')or die("Erreur de connexion a la base");
		$taskID= $_POST['taskID'];
		$startDate = $_POST['startDate'];
		$durationMinut = $_POST['durationMinut'];
		$title = $_POST['title'];
		$detail = $_POST['detail'];
		$user_Fk = $_POST['user_Fk'];

$query = 'update  tasks  set taskID = "'.$taskID.'",startDate = "'.$startDate.'", durationMinut = "'.$durationMinut.'",title = "'.$title.'" ,detail = "'.$detail.'",user_Fk = "'.$user_Fk.'" where taskID ="'.$taskID.'"';
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