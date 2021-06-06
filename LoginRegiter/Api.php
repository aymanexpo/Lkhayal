<?php 
 
 require_once '../includes/DbOperation.php';
  
 function isTheseParametersAvailable($params){

 $available = true; 
 $missingparams = ""; 
 
 foreach($params as $param){
 if(!isset($_POST[$param]) || strlen($_POST[$param])<=0){
 $available = false; 
 $missingparams = $missingparams . ", " . $param; 
 }
 }
 
 if(!$available){
 $response = array(); 
 $response['error'] = true; 
 $response['message'] = 'Parameters ' . substr($missingparams, 1, strlen($missingparams)) . ' missing';
 
 echo json_encode($response);
 
 die();
 }
 }
 
 $response = array();
 
 if(isset($_GET['apicall'])){
 
 switch($_GET['apicall']){
 
 case 'createClient':
 isTheseParametersAvailable(array('sessionToken', 'fName', 'lName', 'birthDate', 'photo', 'identityDoc', 'identityNumber', 'inscriptionDate', 'ensurenceValidity', 'licenceValidity', 'clientEmail', 'passwd', 'clientPhone', 'priceRate', 'isActive', 'notes'));
 
 $db = new DbOperation();
 
 $result = $db->createClient(
 $_POST['name'],
 $_POST['sessionToken'],
 $_POST['fName'],
 $_POST['lName'],
 $_POST['birthDate'],
 $_POST['photo'],
 $_POST['identityDoc'],
 $_POST['identityNumber'],
 $_POST['inscriptionDate'],
 $_POST['ensurenceValidity'],
 $_POST['licenceValidity'],
 $_POST['clientEmail'],
 $_POST['passwd'],
 $_POST['clientPhone'],
 $_POST['priceRate'],
 $_POST['isActive'],
 $_POST['notes']
 );
 
 
 if($result){
 $response['error'] = false; 
 
 $response['message'] = 'Client addedd successfully';
 
 $response['clients'] = $db->getClients();
 }else{
 
 $response['error'] = true; 
 
 $response['message'] = 'Some error occurred please try again';
 }
 
 break; 
 
 case 'getClients':
 $db = new DbOperation();
 $response['error'] = false; 
 $response['message'] = 'Request successfully completed';
 $response['clients'] = $db->getClients();
 break; 
 

 //the UPDATE operation
 case 'updateClient':
 isTheseParametersAvailable(array('clientID', 'sessionToken', 'fName', 'lName', 'birthDate', 'photo', 'identityDoc', 'identityNumber', 'inscriptionDate', 'ensurenceValidity', 'licenceValidity', 'clientEmail', 'passwd', 'clientPhone', 'priceRate', 'isActive', 'notes'));
 $db = new DbOperation();
 $result = $db->updateClient(
    $_POST['clientID'],
    $_POST['name'],
    $_POST['sessionToken'],
    $_POST['fName'],
    $_POST['lName'],
    $_POST['birthDate'],
    $_POST['photo'],
    $_POST['identityDoc'],
    $_POST['identityNumber'],
    $_POST['inscriptionDate'],
    $_POST['ensurenceValidity'],
    $_POST['licenceValidity'],
    $_POST['clientEmail'],
    $_POST['passwd'],
    $_POST['clientPhone'],
    $_POST['priceRate'],
    $_POST['isActive'],
    $_POST['notes']
 );
 
 if($result){
 $response['error'] = false; 
 $response['message'] = 'Client updated successfully';
 $response['clients'] = $db->getClients();
 }else{
 $response['error'] = true; 
 $response['message'] = 'Some error occurred please try again';
 }
 break; 

 //the delete operation
 case 'deleteClient':
 
 if(isset($_GET['clientID'])){
 $db = new DbOperation();
 if($db->deleteClient($_GET['clientID'])){
 $response['error'] = false; 
 $response['message'] = 'Client deleted successfully';
 $response['clients'] = $db->getClients();
 }else{
 $response['error'] = true; 
 $response['message'] = 'Some error occurred please try again';
 }
 }else{
 $response['error'] = true; 
 $response['message'] = 'Nothing to delete, provide an id please';
 }
 break; 

     case 'createSeance':
        isTheseParametersAvailable(array('seanceGrpID', 'clientID', 'monitorID', 'startDate', 'durationMinut', 'isDone', 'paymentID', 'comments'));
        
        $db = new DbOperation();
        
        $result = $db->createSeance(
        $_POST['seanceGrpID'],
        $_POST['clientID'],
        $_POST['monitorID'],
        $_POST['startDate'],
        $_POST['durationMinut'],
        $_POST['isDone'],
        $_POST['paymentID'],
        $_POST['comments']
        );
        
        
        if($result){
        $response['error'] = false; 
        
        $response['message'] = 'Seance addedd successfully';
        
        $response['seances'] = $db->getSeances();
        }else{
        
        $response['error'] = true; 
        
        $response['message'] = 'Some error occurred please try again';
        }
        
        break; 
        
        case 'getSeances':
        $db = new DbOperation();
        $response['error'] = false; 
        $response['message'] = 'Request successfully completed';
        $response['seances'] = $db->getSeances();
        break; 
        
        //the UPDATE operation
        case 'updateSeance':
        isTheseParametersAvailable(array('seanceID', 'seanceGrpID', 'clientID', 'monitorID', 'startDate', 'durationMinut', 'isDone', 'paymentID', 'comments'));
        $db = new DbOperation();
        $result = $db->updateSeance(
            $_POST['seanceID'],
            $_POST['seanceGrpID'],
            $_POST['clientID'],
            $_POST['monitorID'],
            $_POST['startDate'],
            $_POST['durationMinut'],
            $_POST['isDone'],
            $_POST['paymentID'],
            $_POST['comments']
        );
        
        if($result){
        $response['error'] = false; 
        $response['message'] = 'Seance updated successfully';
        $response['seances'] = $db->getSeances();
        }else{
        $response['error'] = true; 
        $response['message'] = 'Some error occurred please try again';
        }
        break; 
        //the delete operation
        case 'deleteSeance':
        
        if(isset($_GET['seanceID'])){
        $db = new DbOperation();
        if($db->deleteSeance($_GET['seanceID'])){
        $response['error'] = false; 
        $response['message'] = 'Seance deleted successfully';
        $response['seances'] = $db->getSeances();
        }else{
        $response['error'] = true; 
        $response['message'] = 'Some error occurred please try again';
        }
        }else{
        $response['error'] = true; 
        $response['message'] = 'Nothing to delete, provide an id please';
        }
        break;       

        case 'createTask':
            isTheseParametersAvailable(array('startDate', 'durationMinut', 'title', 'detail', 'isDone', 'user_Fk'));
            
            $db = new DbOperation();
            
            $result = $db->createTask(
            $_POST['startDate'],
            $_POST['durationMinut'],
            $_POST['title'],
            $_POST['detail'],
            $_POST['isDone'],
            $_POST['user_Fk']
            );
            
            
            if($result){
            $response['error'] = false; 
            
            $response['message'] = 'Task addedd successfully';
            
            $response['tasks'] = $db->getTasks();
            }else{
            
            $response['error'] = true; 
            
            $response['message'] = 'Some error occurred please try again';
            }
            
            break; 

            case 'getTasks':
            $db = new DbOperation();
            $response['error'] = false; 
            $response['message'] = 'Request successfully completed';
            $response['tasks'] = $db->getTasks();
            break; 

            //the UPDATE operation
            case 'updateTask':
            isTheseParametersAvailable(array('taskID', 'startDate', 'durationMinut', 'title', 'detail', 'isDone', 'user_Fk'));
            $db = new DbOperation();
            $result = $db->updateTask(
                $_POST['taskID'],
                $_POST['startDate'],
            $_POST['durationMinut'],
            $_POST['title'],
            $_POST['detail'],
            $_POST['isDone'],
            $_POST['user_Fk']
            );
            
            if($result){
            $response['error'] = false; 
            $response['message'] = 'Task updated successfully';
            $response['tasks'] = $db->getTasks();
            }else{
            $response['error'] = true; 
            $response['message'] = 'Some error occurred please try again';
            }
            break; 
            //the delete operation
            case 'deleteTask':
            
            if(isset($_GET['taskID'])){
            $db = new DbOperation();
            if($db->deleteTask($_GET['taskID'])){
            $response['error'] = false; 
            $response['message'] = 'Task deleted successfully';
            $response['tasks'] = $db->getTasks();
            }else{
            $response['error'] = true; 
            $response['message'] = 'Some error occurred please try again';
            }
            }else{
            $response['error'] = true; 
            $response['message'] = 'Nothing to delete, provide an id please';
            }
            break;
            case 'createUser':
                isTheseParametersAvailable(array('sessionToken', 'userEmail', 'userPasswd', 'adminLevel', 'lastLoginTime', 'isActive', 'userFName', 'userLName', 'description', 'userType', 'userphoto', 'contractDate', 'userPhone', 'displayColor'));
                
                $db = new DbOperation();
                
                $result = $db->createUser(
                    $_POST['sessionToken'],
                    $_POST['userEmail'],
                    $_POST['userPasswd'],
                    $_POST['adminLevel'],
                    $_POST['lastLoginTime'],
                    $_POST['isActive'],
                    $_POST['userFName'],
                    $_POST['userLName'],
                    $_POST['description'],
                $_POST['userType'],
                $_POST['userphoto'],
                $_POST['contractDate'],
                $_POST['userPhone'],
                $_POST['displayColor']
                );
                
                
                if($result){
                $response['error'] = false; 
                
                $response['message'] = 'User addedd successfully';
                
                $response['user'] = $db->getUsers();
                }else{
                
                $response['error'] = true; 
                
                $response['message'] = 'Some error occurred please try again';
                }
                
                break; 
//
                case 'getUsers':
                $db = new DbOperation();
                $response['error'] = false; 
                $response['message'] = 'Request successfully completed';
                $response['user'] = $db->getUsers();
                break; 
                //
                //the UPDATE operation
                case 'updateUser':
                isTheseParametersAvailable(array('userID', 'sessionToken', 'userEmail', 'userPasswd', 'adminLevel', 'lastLoginTime', 'isActive', 'userFName', 'userLName', 'description', 'userType', 'userphoto', 'contractDate', 'userPhone', 'displayColor'));
                $db = new DbOperation();
                $result = $db->updateUser(
                $_POST['userID'],
                $_POST['sessionToken'],
                $_POST['userEmail'],
                $_POST['userPasswd'],
                $_POST['adminLevel'],
                $_POST['lastLoginTime'],
                $_POST['isActive'],
                $_POST['userFName'],
                $_POST['userLName'],
                $_POST['description'],
                $_POST['userType'],
                $_POST['userphoto'],
                $_POST['contractDate'],
                $_POST['userPhone'],
                $_POST['displayColor']
                );
                
                if($result){
                $response['error'] = false; 
                $response['message'] = 'User updated successfully';
                $response['user'] = $db->getUsers();
                }else{
                $response['error'] = true; 
                $response['message'] = 'Some error occurred please try again';
                }
                break; 
                //the delete operation
                case 'deleteUser':
                
                if(isset($_GET['userID'])){
                $db = new DbOperation();
                if($db->deleteUser($_GET['userID'])){
                $response['error'] = false; 
                $response['message'] = 'User deleted successfully';
                $response['user'] = $db->getUsers();
                }else{
                $response['error'] = true; 
                $response['message'] = 'Some error occurred please try again';
                }
                }else{
                $response['error'] = true; 
                $response['message'] = 'Nothing to delete, provide an id please';
                }
                break;
 }
 
 }else{
 
 $response['error'] = true; 
 $response['message'] = 'Invalid API Call';
 }
 

 //displaying the response in json structure 
 echo json_encode($response);
?>