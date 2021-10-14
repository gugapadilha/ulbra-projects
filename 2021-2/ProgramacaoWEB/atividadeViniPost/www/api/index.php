<?php 

$request_method = $_SERVER['REQUEST_METHOD'];
$local = $_SERVER['SCRIPT_NAME'];
$uri = $_SERVER['PHP_SELF'];
$rout = str_replace($local, '', $uri);
$uriSegments = explode('/', $rout);


// index.php/client/123
// 0 -> em branco (não vamos utilizar)
// 1 -> recurso(ex : client)
// 2-> id (ex : 123)

if(isset($uriSegments[1])){
    switch ($uriSegments[1]) {
        case 'client':
            require_once('controllers/ClientController.php');
            $Client = new ClientController();
            switch ($request_method) {
                case 'GET':
                    $Client -> listClients();
                break;
                case 'POST':
                    $Client -> createClient();
                break;
                case 'PUT':
                    $Client -> updateClient($uriSegments[2]);
                break;
                case 'DELETE':
                    $Client -> deleteClient($uriSegments[2]);
                break;
            }
        break;
    }
}

?>
