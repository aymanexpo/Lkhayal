<?php
require "DataBaseConfig.php";

class DataBase
{
    public $connect;
    public $data;
    private $sql;
    protected $servername;
    protected $username;
    protected $password;
    protected $databasename;

    public function __construct()
    {
        $this->connect = null;
        $this->data = null;
        $this->sql = null;
        $dbc = new DataBaseConfig();
        $this->servername = $dbc->servername;
        $this->username = $dbc->username;
        $this->password = $dbc->password;
        $this->databasename = $dbc->databasename;
    }

    function dbConnect()
    {
        $this->connect = mysqli_connect($this->servername, $this->username, $this->password, $this->databasename);
        return $this->connect;
    }

    function prepareData($data)
    {
        return mysqli_real_escape_string($this->connect, stripslashes(htmlspecialchars($data)));
    }

    function logIn($table, $userEmail, $userPasswd)
    {
        $userEmail = $this->prepareData($userEmail);
        $userPasswd = $this->prepareData($userPasswd);
        $this->sql = "select * from " . $table . " where userEmail = '" . $userEmail . "' and userPasswd = '" . $userPasswd ."' and userType = 'ADMIN' ";
        $result = mysqli_query($this->connect, $this->sql);
        $row = mysqli_fetch_assoc($result);
        if (mysqli_num_rows($result) != 0) {
            
                $login = true;
          
        
                
            
        } else $login = false;

        return $login;
    }

    function signUp($table, $userFName, $userLName, $userEmail, $userPasswd, $userPhone )
    {
        $userFName = $this->prepareData($userFName);
        $userLName = $this->prepareData($userLName);
        $userEmail = $this->prepareData($userEmail);
        $userPasswd= $this->prepareData($userPasswd);
        $userPasswd = password_hash($userPasswd, PASSWORD_DEFAULT);
        $userPhone = $this->prepareData($userPhone);
        $this->sql =
            "INSERT INTO " . $table . " (userFName, userLName, userEmail, userPasswd, userPhone) VALUES ('" . $userFName . "','" . $userLName . "','" . $userEmail . "','" . $userPasswd . "','" . $userPhone . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    
    function addClient($table, $fName, $lName, $clientEmail, $Passwd, $clientPhone )
    {
        $fName = $this->prepareData($fName);
        $lName = $this->prepareData($lName);
        $clientEmail = $this->prepareData($clientEmail);
        $Passwd= $this->prepareData($Passwd);
        $Passwd = password_hash($Passwd, PASSWORD_DEFAULT);
        $clientPhone = $this->prepareData($clientPhone);
        $this->sql =
            "INSERT INTO " . $table . " (fName, lName, clientEmail, Passwd, clientPhone) VALUES ('" . $fName . "','" . $lName . "','" . $clientEmail . "','" . $Passwd . "','" . $clientPhone . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    
    
    function addSeance($table, $seanceID, $monitorID, $clientID, $startDate, $durationMinut, $comments )
    {
        $seanceID = $this->prepareData($seanceID);
        $monitorID = $this->prepareData($monitorID);
        $clientID = $this->prepareData($clientID);
        $startDate= $this->prepareData($startDate);
        $durationMinut=$this->prepareData($durationMinut);
        $comments = $this->prepareData($comments);
        
        $this->sql =
            "INSERT INTO " . $table . " (seanceID, monitorID, clientID, startDate,durationMinut, comments) VALUES ('" . $seanceID . "','" . $monitorID . "','" . $clientID . "','" . $startDate . "','" . $durationMinut . "','" . $comments . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }
    
    function addTache($table, $startDate, $durationMinut, $title, $detail, $user_Fk )
    {
       
        $startDate= $this->prepareData($startDate);
        $durationMinut=$this->prepareData($durationMinut);
        $title = $this->prepareData($title);
        $detail = $this->prepareData($detail);
        $user_Fk = $this->prepareData($user_Fk);
        $this->sql =
            "INSERT INTO " . $table . " (startDate, durationMinut, title,detail, user_Fk) VALUES ('" . $startDate . "','" . $durationMinut. "','" . $title . "','" . $detail . "','" . $user_Fk  . "')";
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

    
    function addNote($table, $clientID, $notes )
    {
       
        
        $clientID = $this->prepareData($clientID);
        $notes = $this->prepareData($notes);
        $this->sql =
            "INSERT INTO " . $table . " (clientID, notes) VALUES ('" . $clientID . "','" . $notes. "') WHERE clientID = clientID" ;
        if (mysqli_query($this->connect, $this->sql)) {
            return true;
        } else return false;
    }

}

?>
