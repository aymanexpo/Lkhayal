<?php
 
class DbOperation
{
    private $con;
    function __construct()
    {
        require_once dirname(__FILE__) . '/DbConnect.php';
        $db = new DbConnect();
        $this->con = $db->connect();
    }
 // Table clients CRUD : ---------------------------------------------------
 // creation :
 function createClient($sessionToken, $fName, $lName, $birthDate, $photo, $identityDoc, $identityNumber, $inscriptionDate, $ensurenceValidity, $licenceValidity, $clientEmail, $passwd, $clientPhone, $priceRate, $isActive, $notes){
 $stmt = $this->con->prepare("INSERT INTO clients (sessionToken, fName, lName, birthDate, photo, identityDoc, identityNumber, inscriptionDate, ensurenceValidity, licenceValidity, clientEmail, passwd, clientPhone, priceRate, isActive, notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
 $stmt->bind_param("ssis", $sessionToken, $fName, $lName, $birthDate, $photo, $identityDoc, $identityNumber, $inscriptionDate, $ensurenceValidity, $licenceValidity, $clientEmail, $passwd, $clientPhone, $priceRate, $isActive, $notes);
 if($stmt->execute())
 return true; 
 return false; 
 }

 // lecture :
 function getClients(){
 $stmt = $this->con->prepare("SELECT clientID, sessionToken, fName, lName, birthDate, photo, identityDoc, identityNumber, inscriptionDate, ensurenceValidity, licenceValidity, clientEmail, passwd, clientPhone, priceRate, isActive, notes FROM clients");
 $stmt->execute();
 $stmt->bind_result($clientID, $sessionToken, $fName, $lName, $birthDate, $photo, $identityDoc, $identityNumber, $inscriptionDate, $ensurenceValidity, $licenceValidity, $clientEmail, $passwd, $clientPhone, $priceRate, $isActive, $notes);
 
 $clients = array(); 
 
 while($stmt->fetch()){
 $client  = array();
 $client['clientID'] = $clientID; 
 $client['sessionToken'] = $sessionToken; 
 $client['fName'] = $fName; 
 $client['lName'] = $lName; 
 $client['birthDate'] = $birthDate;
 $client['photo'] = $photo;
 $client['identityDoc'] = $identityDoc;
 $client['identityNumber'] = $identityNumber;
 $client['inscriptionDate'] = $inscriptionDate;
 $client['ensurenceValidity'] = $ensurenceValidity;
 $client['licenceValidity'] = $licenceValidity;
 $client['clientEmail'] = $clientEmail;
 $client['passwd'] = $passwd;
 $client['clientPhone'] = $clientPhone;
 $client['priceRate'] = $priceRate;
 $client['isActive'] = $isActive;
 $client['notes'] = $notes;
 array_push($clients, $client); 
 }
 return $clients; 
 }
 
 //modifier :
 function updateClient($clientID, $sessionToken, $fName, $lName, $birthDate, $photo, $identityDoc, $identityNumber, $inscriptionDate, $ensurenceValidity, $licenceValidity, $clientEmail, $passwd, $clientPhone, $priceRate, $isActive, $notes){
 $stmt = $this->con->prepare("UPDATE clients SET clientID=?, sessionToken=?, fName=?, lName=?, birthDate=?, photo=?, identityDoc=?, identityNumber=?, inscriptionDate=?, ensurenceValidity=?, licenceValidity=?, clientEmail=?, passwd=?, clientPhone=?, priceRate=?, isActive=?, notes=? WHERE clientID = ?");
 $stmt->bind_param("ssisi", $sessionToken, $fName, $lName, $birthDate, $photo, $identityDoc, $identityNumber, $inscriptionDate, $ensurenceValidity, $licenceValidity, $clientEmail, $passwd, $clientPhone, $priceRate, $isActive, $notes, $clientID);
 if($stmt->execute())
 return true; 
 return false; 
 }
 
 
 //supprimer :
 function deleteClient($clientID){
 $stmt = $this->con->prepare("DELETE FROM clients WHERE clientID = ? ");
 $stmt->bind_param("i", $clientID);
 if($stmt->execute())
 return true; 
 return false; 
 }
 // Table clients fin ---------------------------------------------------


 // Table seances CRUD ----------------------------------------------------
  // creation :
  function createSeance($seanceGrpID, $clientID, $monitorID, $startDate, $durationMinut, $isDone, $paymentID, $comments){
    $stmt = $this->con->prepare("INSERT INTO seances (seanceGrpID, clientID, monitorID, startDate, durationMinut, isDone, paymentID, comments) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("ssis", $seanceGrpID, $clientID, $monitorID, $startDate, $durationMinut, $isDone, $paymentID, $comments);
    if($stmt->execute())
    return true; 
    return false; 
    }
   
    // lecture :
    function getSeances(){
    $stmt = $this->con->prepare("SELECT seanceID, seanceGrpID, clientID, monitorID, startDate, durationMinut, isDone, paymentID, comments FROM seances");
    $stmt->execute();
    $stmt->bind_result($seanceID, $seanceGrpID, $clientID, $monitorID, $startDate, $durationMinut, $isDone, $paymentID, $comments);
    
    $seances = array(); 
    
    while($stmt->fetch()){
    $seance  = array();
    $seance['seanceID'] = $seanceID; 
    $seance['seanceGrpID'] = $seanceGrpID; 
    $seance['clientID'] = $clientID; 
    $seance['monitorID'] = $monitorID; 
    $seance['startDate'] = $startDate;
    $seance['durationMinut'] = $durationMinut;
    $seance['isDone'] = $isDone;
    $seance['paymentID'] = $paymentID;
    $seance['comments'] = $comments;
    array_push($seances, $seance); 
    }
    return $seances; 
    }
    
    //modifier :
    function updateSeance($seanceID, $seanceGrpID, $clientID, $monitorID, $startDate, $durationMinut, $isDone, $paymentID, $comments){
    $stmt = $this->con->prepare("UPDATE seances SET seanceID=?, seanceGrpID=?, clientID=?, monitorID=?, startDate=?, durationMinut=?, isDone=?, paymentID=?, comments=? WHERE seanceID = ?");
    $stmt->bind_param("ssisi", $seanceGrpID, $clientID, $monitorID, $startDate, $durationMinut, $isDone, $paymentID, $comments, $seanceID);
    if($stmt->execute())
    return true; 
    return false; 
    }
    
    
    //supprimer :
    function deleteSeance($seanceID){
    $stmt = $this->con->prepare("DELETE FROM seances WHERE seanceID = ? ");
    $stmt->bind_param("i", $seanceID);
    if($stmt->execute())
    return true; 
    return false; 
    }
    // Table seances fin----------------------------------------------------
    
    
    // Table tasks CRUD:----------------------------------------------
      // creation :
  function createTask($startDate, $durationMinut, $title, $detail, $isDone, $user_Fk){
    $stmt = $this->con->prepare("INSERT INTO tasks (startDate, durationMinut, title, detail, isDone, user_Fk) VALUES (?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("ssis", $startDate, $durationMinut, $title, $detail, $isDone, $user_Fk);
    if($stmt->execute())
    return true; 
    return false; 
    }
   
    // lecture :
    function getTasks(){
    $stmt = $this->con->prepare("SELECT taskID, startDate, durationMinut, title, detail, isDone, user_Fk FROM tasks");
    $stmt->execute();
    $stmt->bind_result($taskID, $startDate, $durationMinut, $title, $detail, $isDone, $user_Fk);
    
    $tasks = array(); 
    
    while($stmt->fetch()){
    $task  = array();
    $task['taskID'] = $taskID; 
    $task['startDate'] = $startDate; 
    $task['durationMinut'] = $durationMinut; 
    $task['title'] = $title; 
    $task['detail'] = $detail;
    $task['isDone'] = $isDone;
    $task['user_Fk'] = $user_Fk;
    array_push($tasks, $task); 
    }
    return $tasks; 
    }
    
    //modifier :
    function updateTask($taskID, $startDate, $durationMinut, $title, $detail, $isDone, $user_Fk){
    $stmt = $this->con->prepare("UPDATE tasks SET taskID=?, startDate=?, durationMinut=?, title=?, detail=?, isDone=?, user_Fk=? WHERE taskID = ?");
    $stmt->bind_param("ssisi", $startDate, $durationMinut, $title, $detail, $isDone, $user_Fk, $taskID);
    if($stmt->execute())
    return true; 
    return false; 
    }
    
    
    //supprimer :
    function deleteTask($taskID){
    $stmt = $this->con->prepare("DELETE FROM tasks WHERE taskID = ? ");
    $stmt->bind_param("i", $taskID);
    if($stmt->execute())
    return true; 
    return false; 
    }
    // Table tasks fin----------------------------------------------
    
    
    // Table user CRUD:---------------------------------------------------
          // creation :
  function createUser($sessionToken, $userEmail, $userPasswd, $adminLevel, $lastLoginTime, $isActive, $userFName, $userLName, $description, $userType, $userphoto, $contractDate, $userPhone, $displayColor){
    $stmt = $this->con->prepare("INSERT INTO user (sessionToken, userEmail, userPasswd, adminLevel, lastLoginTime, isActive, userFName, userLName, description, userType, userphoto, contractDate, userPhone, displayColor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    $stmt->bind_param("ssis", $sessionToken, $userEmail, $userPasswd, $adminLevel, $lastLoginTime, $isActive, $userFName, $userLName, $description, $userType, $userphoto, $contractDate, $userPhone, $displayColor);
    if($stmt->execute())
    return true; 
    return false; 
    }
   
    // lecture :
    function getUsers(){
    $stmt = $this->con->prepare("SELECT userID, sessionToken, userEmail, userPasswd, adminLevel, lastLoginTime, isActive, userFName, userLName, description, userType, userphoto, contractDate, userPhone, displayColor FROM user");
    $stmt->execute();
    $stmt->bind_result($userID, $sessionToken, $userEmail, $userPasswd, $adminLevel, $lastLoginTime, $isActive, $userFName, $userLName, $description, $userType, $userphoto, $contractDate, $userPhone, $displayColor);
    
    $user = array(); 
    
    while($stmt->fetch()){
    $use  = array();
    $use['userID'] = $userID; 
    $use['sessionToken'] = $sessionToken; 
    $use['userEmail'] = $userEmail; 
    $use['userPasswd'] = $userPasswd; 
    $use['adminLevel'] = $adminLevel;
    $use['lastLoginTime'] = $lastLoginTime;
    $use['isActive'] = $isActive;
    $use['userFName'] = $userFName;
    $use['userLName'] = $userLName;
    $use['description']= $description;
    $use['userType'] = $userType;
    $use['userphoto'] = $userphoto;
    $use['contractDate'] = $contractDate;
    $use['userPhone'] = $userPhone;
    $use['displayColor'] = $displayColor;
    array_push($user, $use); 
    }
    return $user; 
    }
    
    //modifier :
    function updateUser($userID, $sessionToken, $userEmail, $userPasswd, $adminLevel, $lastLoginTime, $isActive, $userFName, $userLName, $description, $userType, $userphoto, $contractDate, $userPhone, $displayColor){
    $stmt = $this->con->prepare("UPDATE user SET userID=?, sessionToken=?, userEmail=?, userPasswd=?, adminLevel=?, lastLoginTime=?, isActive=?, userFName=?, userLName=?, description=?, userType=?, userphoto=?, contractDate=?, userPhone=?, displayColor=? WHERE userID = ?");
    $stmt->bind_param("ssisi", $sessionToken, $userEmail, $userPasswd, $adminLevel, $lastLoginTime, $isActive, $userFName, $userLName, $description, $userType, $userphoto, $contractDate, $userPhone, $displayColor, $userID);
    if($stmt->execute())
    return true; 
    return false; 
    }
    
    
    //supprimer :
    function deleteUser($userID){
    $stmt = $this->con->prepare("DELETE FROM user WHERE userID = ? ");
    $stmt->bind_param("i", $userID);
    if($stmt->execute())
    return true; 
    return false; 
    }
    // Table user fin---------------------------------------------------

}
?>