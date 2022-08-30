//grupos de exemplos
//grupo A -> 0 (SAIDA É 0)
var x11 = 0, x12 = 0, y1 = 0
var x21 = 0, x22 = 1, y2 = 0

//grupo B -> 1 (SAIDA É 1)
var x31 = 1, x32 = 0, y3 = 1
var x41 = 1, x42 = 1, y4 = 1

//pesos iniciais

var w1 = -1, w2 = -1

var ajustes, y
do {
    ajustes = 0

    //var x11 = 0, x21 = 0, y1 = 0
    y = transferencia(soma(x11, x12))
    if(y != y1){
        ajuste(x11, x12, y1, y)
        ajustes++
    }

    //var x21 = 0, x22 = 1, y2 = 0
    y = transferencia(soma(x21, x22))
    if(y != y2){
        ajuste(x21, x22, y2, y)
        ajustes++
    }

    //var x31 = 1, x32 = 0, y3 = 1
    y = transferencia(soma(x31, x32))
    if(y != y3){
        ajuste(x31, x32, y3, y)
        ajustes++
    }

    //var x41 = 1, x42 = 1, y4 = 1
    y = transferencia(soma(x41, x42))
    if(y != y4){
        ajuste(x41, x42, y4, y)
        ajustes++
    }

}while (ajustes != 0)

console.log("Os pesos finais são: w1 = " + w1 + "e w2 = " + w2)

function soma(_x1, _x2){
    return(_x1 * w1) + (_x2 * w2)
}

function transferencia(_soma){
    if(_soma <= 0){
        return 0
    }else{
        return 1
    }
}

function ajuste(_x1, _x2, _yd, _yo){
    w1 = w1 + 1 * (_yd - _yo) * _x1
    w2 = w2 + 1 * (_yd - _yo) * _x2
}