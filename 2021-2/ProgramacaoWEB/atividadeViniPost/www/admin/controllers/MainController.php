<?php

class MainController{
    public function index(){
        if(!isset($_SESSION['login'])){
            header('Location: index.php?controller=main&action=login');
        }else{
            require_once('views/templates/header.php');
            require_once('views/main/home.php');
            require_once('views/templates/footer.php');
        }
    }

    public function listClients(){

        require_once('models/ClientModel.php');
        $clientModel = new ClientModel();
        $result = $clientModel -> listClients();

        $arrayClients = array();

        while($line = $result -> fetch_assoc()){
            array_push($arrayClients, $line);
        }

        require_once('views/templates/header.php');
        require_once('views/main/listClients.php');
        require_once('views/templates/footer.php');
    }

    public function login(){
        require_once('views/main/login.php');
    }

    public function logout(){
        session_destroy();
        header('Location: index.php?controller=main&action=login');
    }
}

?>