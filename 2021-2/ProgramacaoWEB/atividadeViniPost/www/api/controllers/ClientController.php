<?php

    class ClientController{

        var $ClientModel;
        public function __construct(){
            require_once('models/ClientModel.php');
            $this -> ClientModel = new ClientModel();
        }

        public function listClients(){
            $result = $this -> ClientModel -> listClients();

            $arrayClients = array();
            while($line = $result -> fetch_assoc()){
                array_push($arrayClients, $line);
            }
            
            header('Content-Type:application/json');
            echo json_encode($arrayClients);
        }

        public function createClient(){

            $client = json_decode(file_get_contents('php://input'));

            $arrayClient['name'] = $client -> name;
            $arrayClient['phone'] = $client -> phone;
            $arrayClient['email'] = $client -> email;
            $arrayClient['address'] = $client -> address;

            $this -> ClientModel -> createClient($arrayClient);

        }

        public function updateClient($id){
            $client = json_decode(file_get_contents('php://input'));

            $arrayClient['idClient'] = $id;
            $arrayClient['name'] = $client -> name;
            $arrayClient['phone'] = $client -> phone;
            $arrayClient['email'] = $client -> email;
            $arrayClient['address'] = $client -> address;

            $this -> ClientModel -> updateClient($arrayClient);

        }

        public function deleteClient($id){

            $this -> ClientModel -> deleteClient($id);

        }

    }
?>