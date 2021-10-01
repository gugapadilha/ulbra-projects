<?php

    class ClientController{

        public function listClients(){
            require_once('models/ClientModel.php');
            $clientModel = new ClientModel();
            $result = $clientModel -> listClients();

            $arrayClients = array();

            while($line = $result -> fetch_assoc()){
                array_push($arrayClients, $line);
            }

            require_once('views/templates/header.php');
            require_once('views/client/listClients.php');
            require_once('views/templates/footer.php');
        }

        public function createClient(){
            require_once('views/templates/header.php');
            require_once('views/client/createClient.php');
            require_once('views/templates/footer.php');
        }

        public function createClientAction(){
            require_once('models/ClientModel.php');
            $clientModel = new ClientModel();

            $arrayClient['name'] = $_POST['name'];
            $arrayClient['phone'] = $_POST['phone'];
            $arrayClient['email'] = $_POST['email'];
            $arrayClient['address'] = $_POST['address'];

            $clientModel -> createClient($arrayClient);

            header('Location: index.php?controller=client&action=listClients');
        }

        public function updateClient($id){
            require_once('models/ClientModel.php');
            $clientModel = new ClientModel();
            $result = $clientModel -> listClient($id);

            if($arrayClient = $result -> fetch_assoc()){
                require_once('views/templates/header.php');
                require_once('views/client/updateClient.php');
                require_once('views/templates/footer.php');
            }
        }

        public function updateClientAction($id){
            require_once('models/ClientModel.php');
            $clientModel = new ClientModel();

            $arrayClient['idClient'] = $id;
            $arrayClient['name'] = $_POST['name'];
            $arrayClient['phone'] = $_POST['phone'];
            $arrayClient['email'] = $_POST['email'];
            $arrayClient['address'] = $_POST['address'];

            $clientModel -> updateClient($arrayClient);

            header('Location: index.php?controller=client&action=listClients');
        }

        public function deleteClient($id){
            require_once('models/ClientModel.php');
            $clientModel = new ClientModel();
            $clientModel -> deleteClient($id);

            header('Location: index.php?controller=client&action=listClients');
        }

    }
?>