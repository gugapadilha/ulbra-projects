fun main () {

    println("Digite quantas notas que gostaria mostrar: ")
    var nota = readLine()
    var array = nota?.let { IntArray(it.length) }

    //fazer um for

    println("Digite os valores destas notas: ")
    var sim = array?.size
    var notas = readLine()
    var result = sim?.let { notas?.let { it1 -> IntArray(it1.length) } }

    var media = (nota?.length ?: 0 ) / (result?.size ?: 0)
    println(media)
}