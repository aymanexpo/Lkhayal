<?php 

	$conn= mysqli_connect("localhost","root","","equi");
	
	$result = array();
	$result['user'] = array();
	$select= "select * from user where userType = 'MONITOR'";
	$responce = mysqli_query($conn,$select);
	
	while($row = mysqli_fetch_array($responce))
		{
			$index['userID']      = $row['userID'];
			$index['userEmail']    = $row['userEmail'];
			$index['userPasswd']   = $row['userPasswd'];
			$index['userFName'] = $row['userFName'];
			$index['userLName'] = $row['userLName'];
			$index['userPhone'] = $row['userPhone'];
			
			array_push($result['user'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conn);
 ?>