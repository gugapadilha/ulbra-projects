<?php

class ClientModel{

    var $connection;

    public function __construct(){
        require_once('db/ConnectClass.php');
        $connectClass = new ConnectClass();
        $connectClass -> openConnect();
        $this -> connection = $connectClass -> getConn();
    }

    public function listClients(){

        require_once('db/ConnectClass.php');
        $connectClass = new ConnectClass();
        $connectClass -> openConnect();
        $connection = $connectClass -> getConn();

        $sql = 'SELECT * FROM clients';

        return $connection -> query($sql);
    }

    public function createContact($arrayContact){

        $sql = "
            INSERT INTO contacts
                (name, email, message)
            VALUES(
                '{$arrayContact['name']}',
                '{$arrayContact['email']}',
                '{$arrayContact['message']}'
                )
        ";

        $this -> connection -> query($sql);
        return $this -> connection -> insert_id;
    }

}

?>