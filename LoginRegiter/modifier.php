<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
    $conn= mysqli_connect("localhost","root","")or die("Erreur de connexion au serveur");
    mysqli_select_db($conn,'equi')or die("Erreur de connexion a la base");
		$Id_User = $_POST['clientID'];
		$Nom_User = $_POST['fName'];
		$Prenom_User = $_POST['lName'];
		$Password_User = $_POST['passwd'];
		$Login_User = $_POST['clientEmail'];
		$tele_User = $_POST['clientPhone'];

$query = 'update  clients  set fName = "'.$Nom_User.'",lName = "'.$Prenom_User.'",passwd = "'.$Password_User.'",clientEmail = "'.$Login_User.'" ,clientPhone = "'.$tele_User.'"  where clientID ="'.$Id_User.'"';
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