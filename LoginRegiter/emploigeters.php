<?php
    $connection = mysqli_connect("localhost","root","","equi");

    $result['seances'] = array();
    $result1['tasks'] = array();
    $select = ("SELECT * from seances" && "SELECT *from tasks");
    $response = mysqli_query($connection, $select);
    while($row = mysqli_fetch_array($response)){
        $index['seancID'] = $row['0'];
        $index['seanceGrpID']= $row['1'];
        $index['clientID']= $row['2'];
        $index['monitorID']= $row['3'];
        $index['startDate']= $row['4'];
        $index['durationMinut']= $row['5'];
        $index['isDone']= $row['6'];
        $index['paymentID']= $row['7'];
        $index['comments']= $row['8'];
    }
?>