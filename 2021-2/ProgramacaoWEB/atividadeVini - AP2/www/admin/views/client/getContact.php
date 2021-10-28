<h1>Lista de Clientes</h1>
    <table class='table table-striped'>

    <tr>
        <th>Nome</th>
        <th>Email</th>
        <th>Mensagem</th>
    </tr>


    <?php
            foreach($arrayContact as $contact){
    ?>
        <tr>
            <td>
            <?=$contact['name'];?>
            </td>
            <td>
            <?=$contact['email'];?>
            </td>
            <td>
            <?=$contact['message'];?>
            </td>
        </tr>

    <?php
            }
    ?>




</table>