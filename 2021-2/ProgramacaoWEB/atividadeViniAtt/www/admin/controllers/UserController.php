<?php

class UserController{
    public function validateLogin(){
        $login = $_POST['login'];
        $password = $_POST['password'];

        require_once('models/UserModel.php');
        $UserModel = new UserModel();
        $result = $UserModel -> getUser($login);

        if($user = $result -> fetch_assoc()){

            if($password == $user['password']){

                $_SESSION['nome'] = $user['name'];
                $_SESSION['id'] = $user['idUser'];

                $_SESSION['login'] = $user;
                header('Location: index.php?controller=main&action=index');

            }else{
                echo('Senha inválida!!');
            }

        }else{
            echo('Usuário inválido!!');
        }

    }


}

?>