<h1>Lista de Clientes</h1>
    <table class='table table-striped'>

    <tr>
        <th>Id clientes</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Telefone</th>
        <th>Imagem</th>
        <th>Endereço</th>
        <th></th>
    </tr>


    <?php
        foreach($arrayClients as $client){
    ?>

        <tr>
            <td>
                <?=$client['idClient'];?>
            </td>
            <td>
                <?=$client['name'];?>
            </td>
            <td>
                <?=$client['email'];?>
            </td>
            <td>
                <?=$client['phone'];?>
            </td>
            <td>
                <?php if(is_file("assets/img/{$client['idClient']}.jpg")){
                    echo "
                        <img 
                        style='max-width:100px; max-heigth:100px'
                        src='assets/img/{$client['idClient']}.jpg'
                        >
                    ";
                }else{
                    echo "Sem imagem!";
                }
                ?>
            </td>
            <td>
                <?=$client['address'];?>
            </td>
            <td>
                <a href="?controller=client&action=updateClient&id=<?=$client['idClient'];?> " class="btn btn-warning">
                    alterar
                </a>
            </td>
            <td>
            <a href="?controller=client&action=deleteClient&id=<?=$client['idClient'];?> " class="btn btn-danger">
                    deletar
                </a>
            </td>
        </tr>


    <?php
        }
    ?>




</table>