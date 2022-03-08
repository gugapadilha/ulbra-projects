data class JogadorFutebol(
    var name: String = "", var posicao: String = "", var dataNascimento: Int = 0,
    var nacionalidade: String = "", var altura: Double = 0.0, var peso: Double = 0.0,

) {

    fun imprimirTodosDados(): JogadorFutebol {
        return JogadorFutebol("augustinho", "ataque", 1989,
            "Brazilian", 1.84, 84.0)
    }

    fun menor40() {
        var idadeRestantes = 2022 - dataNascimento

        if (imprimirTodosDados().posicao == "defesa" && idadeRestantes <= 40){
            var tempoFalta40 = 40 - idadeRestantes
            println("a idade restante para se aposentar nessa posição é $tempoFalta40")
        }else if(imprimirTodosDados().posicao == "meio-campo" && idadeRestantes <= 38) {
            var tempofalta38 = 38 - idadeRestantes
            println("a idade restante para se aposentar nessa posição é $tempofalta38")
        }else if (imprimirTodosDados().posicao == "ataque" && idadeRestantes <= 35 ){
            var tempoFalta35 = 35 - idadeRestantes
            println("a idade restante para se aposentar nessa possição é $tempoFalta35")
        }else {
            println("você ja está aposentado! ")
        }
    }

}
    //extension function
    fun JogadorFutebol.calcularIdade() {
        var idadeRestante =  2022 - dataNascimento
        return println("A idade do jogador é de: $idadeRestante ")
    }

