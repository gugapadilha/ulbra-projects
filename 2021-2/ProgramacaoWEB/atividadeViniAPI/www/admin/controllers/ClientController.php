<?php

    class ClientController{

        public function listaClientesAdmin(){
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

    }
?>