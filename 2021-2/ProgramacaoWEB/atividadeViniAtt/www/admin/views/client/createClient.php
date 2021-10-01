<h1>Insere cliente</h1>
<form action="?controller=client&action=createClientAction" method=POST enctype='multipart/form-data'>
    <div class="form-group">
        <div>
            <label for="name">Nome:</label>
            <input type="text" class="form-control" name="name">
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="mail" class="form-control" name="email">
        </div>
        <div>
            <label for="tel">Telefone:</label>
            <input type="text" class="form-control" name="phone" >
        </div>
        <div>
            <label for="end">Endereço:</label>
            <input type="text" class="form-control" name="address">
        </div>
        <br>
        <br>
        <button type="submit" class="btn btn-success">Salvar</button>
    </div>
</form>