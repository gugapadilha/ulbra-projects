<?php
    class ContactsController {
        var $ContactModel;
        var $UserController;

        public function __construct() {
            require_once("models/ContactsModel.php");
            $this -> ContactModel = new ContactsModel();

            require_once("controllers/UserController.php");
            $this -> UserController = new UserController();
        }

        public function insert() {
            $contactsJson = json_decode(file_get_contents('php://input'));

            $arrayContact['name'] = $contactsJson -> name;
            $arrayContact['email'] = $contactsJson -> email;
            $arrayContact['message'] = $contactsJson -> message;

            $this -> ContactModel -> insert($arrayContact);

            header("Content-Type: application/json");
            echo('{"result": true}');
        }

        public function get() {
            if($this -> UserController -> isAdmin()) {
                $this -> ContactModel -> get();
                $result = $this -> ContactModel -> returnResult();
    
                $arrayContacts = array();
                while($row = $result -> fetch_assoc()) {
                    array_push($arrayContacts, $row);
                }
                
                header("Content-Type: application/json");
                echo json_encode($arrayContacts);
            } else {
                header("Content-Type: application/json");
                echo json_encode('{"access": "denied"}');
            }
        }

        public function getById($id) {
            if($this -> UserController -> isAdmin()) {
                $this -> ContactModel -> getById($id);
                $result = $this -> ContactModel -> returnResult();

                $arrayClients = array();
                while($linha = $result -> fetch_assoc()) {
                    array_push($arrayClients, $linha);
                }

                header("Content-Type: application/json");
                echo json_encode($arrayClients);
            } else {
                header("Content-Type: application/json");
                echo json_encode('{"access": "denied"}');
            }
        }
    }
?>