<?php

class ClientModel{

    var $connection;

    public function __construct(){
        require_once('db/ConnectClass.php');
        $connectClass = new ConnectClass();
        $connectClass -> openConnect();
        $this -> connection = $connectClass -> getConn();
    }

    public function listClient($id){

        $sql = "
            SELECT * FROM 
                clients
            WHERE
                idClient = {$id}
        ";

        return $this -> connection -> query($sql);
    }

    public function listClients(){

        $sql = 'SELECT * FROM clients';

        return $this -> connection -> query($sql);
    }

    public function createClient($arrayClient){

        $sql = "
            INSERT INTO clients
                (name, email, phone, address)
            VALUES(
                '{$arrayClient['name']}',
                '{$arrayClient['email']}',
                '{$arrayClient['phone']}',
                '{$arrayClient['address']}'
                )
        ";

        $this -> connection -> query($sql);
        return $this -> connection -> insert_id;
    }

    public function updateClient($arrayClient){

        $sql = "
            UPDATE clients
                set
                    name='{$arrayClient['name']}',
                    phone='{$arrayClient['phone']}',
                    email='{$arrayClient['email']}',
                    address='{$arrayClient['address']}'
                where
                    idClient = {$arrayClient['idClient']}
        ";

        return $this -> connection -> query($sql);
    }

    public function deleteClient($id){

        $sql = "
            DELETE FROM 
                clients
            WHERE
                idClient = {$id}
        ";

        return $this -> connection -> query($sql);
    }

    public function getContact($id){

        $sql = "
            SELECT * FROM 
                contacts
            WHERE
                idContact = {$id}
        ";

        return $this -> connection -> query($sql);
    }

}

?>