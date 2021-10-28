<?php

class SiteController{

    var $ClientModel;
    public function __construct(){
        require_once('models/ClientModel.php');
        $this -> ClientModel = new ClientModel();
    }

    public function home(){
        require_once('views/templates/header.php');
        require_once('views/pages/home.php');
        require_once('views/templates/footer.php');
    }

    public function produtos(){
        require_once('views/templates/header.php');
        require_once('views/pages/produtos.php');
        require_once('views/templates/footer.php');
    }

    public function contato(){
        require_once('views/templates/header.php');
        require_once('views/pages/contato.php');
        require_once('views/templates/footer.php');
    }

    public function createContactAction(){

        $arrayContact['name'] = $_POST['name'];
        $arrayContact['message'] = $_POST['message'];
        $arrayContact['email'] = $_POST['email'];

        $this -> ClientModel -> createContact($arrayContact);

        header('Location: index.php?controller=site&action=contato');
    }
}

?>