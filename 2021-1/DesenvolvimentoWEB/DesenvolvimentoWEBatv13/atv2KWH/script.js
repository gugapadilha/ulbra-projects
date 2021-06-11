
var res = 0;
function calcularKWH() {
  var qntd = document.getElementById('qntd').value;
  var untd = document.getElementById('untd').value;
  
    if(qntd >= 100 && qntd < 200){
       res = qntd * (untd * 1.25)
    }else if (qntd >= 200){
      res = qntd * (untd * 1.50)
    }else{
       res = qntd * untd
    }   
    document.getElementById("res").value = res; //usei .value pois setei o valor em um INPUT
                                                //se fosse em outra TAG seria o INNERHTML
  
  }



