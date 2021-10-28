<h1>Lista de Clientes</h1>
    <table class='table table-striped'>

    <tr>
        <th>Id Contato</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Mensagem</th>
    </tr>


    <?php
        foreach($arrayContact as $contact){
    ?>

        <tr>
            <td>
                <?=$contact['idContact'];?>
            </td>
            <td>
                <?=$contact['name'];?>
            </td>
            <td>
                <?=$contact['email'];?>
            </td>
            <td>
                <?=$contact['message'];?>
            </td>
            <td>
                <a href="?controller=client&action=getContact&id=<?=$contact['idContact'];?> " class="btn btn-warning">
                    Consultar
                </a>
            </td>
        </tr>


    <?php
        }
    ?>




</table>