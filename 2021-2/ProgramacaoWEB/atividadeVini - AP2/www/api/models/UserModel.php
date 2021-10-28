<?php

class UserModel{

    var $conn;

    public function __construct(){
        require_once('db/ConnectClass.php');
        $Oconn = new ConnectClass();
        $Oconn -> openConnect();
        $this -> conn = $Oconn -> getConn();
    }

    public function getUser($user){
        $sql = " SELECT * FROM users WHERE user = '{$user}'";

        return $this -> conn-> query($sql);

    }

}

?>