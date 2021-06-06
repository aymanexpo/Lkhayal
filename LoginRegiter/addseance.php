<?php
$conn= mysqli_connect("localhost","root","","equi");
mysqli_query($conn,"SET NAMES 'utf8'");
		$Nom_Seance = $_POST['Nom_Seance'];
		$Description_Seance = $_POST['Description_Seance'];
		$Id_User = $_POST['Id_User'];
		$HeureDebut_Seance = $_POST['HeureDebut_Seance'];
		$HeureFin_Seance = $_POST['HeureFin_Seance'];
		$Date_Seance = $_POST['Date_Seance'];
		$Type_Seance = $_POST['Type_Seance'];

$query = 'insert into seance (Nom_Seance,Description_Seance,HeureDebut_Seance,HeureFin_Seance,Date_Seance,Type_Seance,Id_User) values ("'.$Nom_Seance.'","'.$Description_Seance.'","'.$HeureDebut_Seance .'","'.$HeureFin_Seance.'","'.$Date_Seance.'","'.$Type_Seance.'","'.$Id_User.'")';
//,,Id_User"'.$Id_User.'"
if (mysqli_query($conn , $query)){
	echo "1";
}
else 
{
	echo "0";
}
mysqli_close($conn);

?>