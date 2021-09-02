<?php

    class ClientController{

        public function register(){
            require_once('views/templates/header.php');
            require_once('views/client/register.php');
            require_once('views/templates/footer.php');
        }
    

        public function registerView(){
            if(!isset($_POST['accept'])){
                $accept = true;
            }else{
                $accept = false;
            }

            $arrayClient = array(
                'name' => $_POST['name'],
                'email' => $_POST['email'],
                'phone' => $_POST['phone'],
                'gender' => $_POST['gender'],
                'accept' => $accept,
            );

            require_once('views/templates/header.php');
            require_once('views/client/registerView.php');
            require_once('views/templates/footer.php');
        }
    }
?>