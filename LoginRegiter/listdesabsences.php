<?php

$connection = mysqli_connect("localhost","root","","equi");
        
        $result = array();
        $result['tasks'] = array();
        $select= "SELECT * from tasks where isDone = 'absent'";
        $response = mysqli_query($connection,$select);
        
        while($row = mysqli_fetch_array($response))
        {
        $index['taskID']      = $row['taskID'];
			$index['startDate']  = $row['startDate'];
            $index['title'] = $row['title'];
			$index['user_Fk'] = $row['user_Fk'];
		    $index['isDone'] = $row['isDone'];
        
        array_push($result['tasks'], $index);
      
        }
        $result["success"]="1";

        echo json_encode($result);
        mysqli_close($connection);
        

?>