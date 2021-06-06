<?php

$connection = mysqli_connect("localhost","root","","lberguiandroid");
        
        $result = array();
        $result['clients'] = array();
        $select= "SELECT * from clients";
        $response = mysqli_query($connection,$select);
        
        while($row = mysqli_fetch_array($response))
        {
        $index['clientID']= $row['clientID'];
        $index['fName']= $row['fName'];
        $index['lName']= $row['lName'];
        $index['clientEmail']= $row['clientEmail'];
        $index['passwd']= $row['passwd'];
        $index['clientPhone']= $row['clientPhone'];
        
        array_push($result['clients'], $index);
      
        }
        $result["success"]="1";

        echo json_encode($result);
        mysqli_close($connection);
        

?>