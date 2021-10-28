<?php
$header = [
   'alg' => 'HS256',
   'typ' => 'JWT'
];
$header = json_encode($header);
$header = base64_encode($header);
$header = str_replace(['+', '/', '='], ['-', '_', ''], $header); //base64url

$payload = [
   'iss' => 'localhost',
   'name' => 'xxxx',
   'user' => 'xxx',
   'adm' => true
];
$payload = json_encode($payload);
$payload = base64_encode($payload);
$payload = str_replace(['+', '/', '='], ['-', '_', ''], $payload); //base64url

$signature = hash_hmac('sha256',"$header.$payload",'minha-senha',true);
$signature = base64_encode($signature);
$signature = str_replace(['+', '/', '='], ['-', '_', ''], $signature); //base64url


$token = $header . "." . $payload . "." . $signature;

header('Content-Type: application/json');	
echo ('{"acess":"true","token":"'.$token.'"}');

