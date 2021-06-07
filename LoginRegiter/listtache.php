<?php 

	$conn= mysqli_connect("localhost","root","","equi");
	
	$result = array();
	$result['tasks'] = array();
	$select= "select * from tasks";
	$responce = mysqli_query($conn,$select);
	
	while($row = mysqli_fetch_array($responce))
		{
			$index['taskID']      = $row['taskID'];
			$index['startDate']    = $row['startDate'];
			$index['durationMinut']   = $row['durationMinut'];
			$index['detail'] = $row['detail'];
				$index['title'] = $row['title'];
			$index['user_Fk'] = $row['user_Fk'];
			array_push($result['tasks'], $index);
		}
			
			$result["success"]="1";
			echo json_encode($result);
			mysqli_close($conn);
 ?>
