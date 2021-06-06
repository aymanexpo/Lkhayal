<?php
    $connection = mysqli_connect("localhost","root","","equi");

    $result = array();
        $result['seances'] = array();
        $select= "SELECT * from seances where startDate >= getdate() 
        AND startDate <= dateadd(day, 90, getdate())";
        $response = mysqli_query($connection,$select);

        while($row = mysqli_fetch_array($response))
        {   
            //list seance rows :
            $index['seanceID']= $row['0'];
            $index['seanceGrpID']= $row['1'];
            $index['clientID']= $row['2'];
            $index['monitorID']= $row['3'];
            $index['startDate']= $row['4'];
            $index['durationMinut']= $row['5'];
            $index['isDone']= $row['6'];
            $index['paymentID']= $row['7'];
            $index['comments']= $row['8'];
            // pushing :
            array_push($result['seances'], $index);
        }
        $result["success"]="1";

        echo json_encode($result);
        mysqli_close($connection);
?>