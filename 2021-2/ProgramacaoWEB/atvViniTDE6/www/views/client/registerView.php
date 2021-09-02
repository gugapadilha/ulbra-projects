<h1>Registro de Cliente - Visualização</h1>

<table class="table table-striped">

    <tr>
        <th>nome:</th>
        <td>
            <?=$arrayClient['name']?>  
        </td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>
            <?=$arrayClient['email']?>  
        </td>
    </tr>
    <tr>
        <th>Telefone:</th>
        <td>
            <?=$arrayClient['phone']?>  
        </td>
    </tr>
    <tr>
        <th>Genero:</th>
        <td>
            <?=$arrayClient['gender']?>  
        </td>
    </tr>
    <tr>
        <th>Termo:</th>
        <td>
            <?php 
            if($arrayClient['accept']){
                echo('aceito');
            }else{
                echo('nao aceitou');
            }
            ?>
        </td>
    </tr>

</table>