<form action="?controller=site&action=newContato" method=POST enctype='multipart/form-data'>
    <div class="form-group">
        <label for="nome">Nome:</label>
        <input type="text" class="form-control" name="name">
    </div>

    <div class="form-group">
        <label for="email">Email address:</label>
        <input type="email" class="form-control" name="email">
    </div>

    <div class="form-group">
        <label for="message">Comment:</label>
        <textarea class="form-control" rows="5" name="message"></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Enviar</button>
</form>