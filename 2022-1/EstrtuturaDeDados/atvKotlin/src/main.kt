fun main () {

    //Imprimir dados do jogador
    var imprimirDados = JogadorFutebol()
    var mostrar =  imprimirDados.imprimirTodosDados()
    println(mostrar)

    //Mostrar idade
    println(mostrar.calcularIdade())

    //Mostrar ano
    println(mostrar.menor40())
}