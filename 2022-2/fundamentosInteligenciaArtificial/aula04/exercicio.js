//grupo de exemplos para treinamento supervisionado
var x11 = 0, x12 = 0, y1 = 0 // {0,0} = 0
var x21 = 0, x22 = 1, y2 = 0 // {0,1} = 0
var x31 = 1, x32 = 0, y3 = 1 // {1,0} = 1
var x41 = 1, x42 = 1, y4 = 1 // {1,1} = 1

//pesos iniciais
var w1 = -1, w2 = -1

//outras variáveis
var sum, y, ajustes, ajustesTotais = 0, repeticoes = 0;

