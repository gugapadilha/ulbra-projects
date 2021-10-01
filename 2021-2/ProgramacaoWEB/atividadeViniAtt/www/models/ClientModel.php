<?php

class ClientModel{

    public function listClients(){

        require_once('db/ConnectClass.php');
        $connectClass = new ConnectClass();
        $connectClass -> openConnect();
        $connection = $connectClass -> getConn();

        $sql = 'SELECT * FROM clients';

        return $connection -> query($sql);
    }

}

?>