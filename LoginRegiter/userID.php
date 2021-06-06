<?php
require_once "conn.php";
$sql = "select * from  user where userType like 'MONITOR' ";
if(!$conn->query($sql)){
echo "Error in connecting to database";
}

else{
$result = $conn->query($sql);
if($result->num_rows > 0){

   $return_arr['user'] = array();
   while($row =$result->fetch_array()){
   array_push($return_arr['user'],array(
   'userID'=>$row['userID'],
'userFName'=>$row['userFName']
   
   ));
   }
    echo json_encode($return_arr);
}
}
?>