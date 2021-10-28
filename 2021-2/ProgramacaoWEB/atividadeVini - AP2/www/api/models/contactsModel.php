<?php
    class ContactsModel {
        var $result;
        var $connection;

        public function __construct(){
            require_once('db/ConnectClass.php');
            $connectClass = new ConnectClass();
            $connectClass -> openConnect();
            $this -> connection = $connectClass -> getConn();
        }

        public function insert($arrayContact) {
            $name = $arrayContact['name'];
            $email = $arrayContact['email'];
            $message = $arrayContact['message'];
            
            $sql = "INSERT INTO contacts (name, email, message)
                VALUES('$name', '$email', '$message')";

            $this -> result = $this -> connection -> query($sql);
            $this -> result = $this -> connection -> insert_id;
        }

        public function get() {
            $sql = "SELECT * FROM contacts";

            $this -> result = $this -> connection -> query($sql);
        }

        public function getById($id) {
            $sql="SELECT * FROM contacts
                WHERE idContact = '$id'";

            $this -> result = $this -> connection -> query($sql);
        }

        public function returnResult() {
            return $this -> result;
        }
    }
?>