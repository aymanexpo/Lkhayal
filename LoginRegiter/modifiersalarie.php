<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
    $conn= mysqli_connect("localhost","root","")or die("Erreur de connexion au serveur");
    mysqli_select_db($conn,'equi')or die("Erreur de connexion a la base");
		$userID = $_POST['userID'];
		$userEmail = $_POST['userEmail'];
		$userPasswd = $_POST['userPasswd'];
		$userFName = $_POST['userFName'];
		$userLName= $_POST['userLName'];
		$userPhone = $_POST['userPhone'];

$query = 'update user set userID = "'.$userID.'",userEmail = "'.$userEmail.'",userPasswd = "'.$userPasswd.'",userFName= "'.$userFName.'" ,userLName = "'.$userLName.'" ,userPhone = "'.$userPhone.'"   where userID ="'.$userID.'"';
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