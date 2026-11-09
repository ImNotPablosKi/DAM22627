const tipoRaid = document.getElementById("tiporaid")
const numdiscos = document.getElementById("numdisc")
const tamañoDiscos = document.getElementById("teras")
var boton = document.getElementById("asd")
boton.addEventListener("click", calcular)

var ri1 = 0
var ri2 = 0

tipoRaid.addEventListener("change", tipoRaidCambiado)
numdiscos.addEventListener("change", numdiscCambiado)
tamañoDiscos.addEventListener("change", tamañoCambiado)




function tipoRaidCambiado(t) {
    numdiscos.innerText=""
    tamañoDiscos.innerText=""


    if (tipoRaid.value == 0) {
         numdiscos.value = 2
         tamañoDiscos.value = 1
         for (let i = 2; i <= 10; i++) {
            var opcion = document.createElement("option")
            opcion.value = i
            opcion.text = i
            numdiscos.appendChild(opcion)
         }

        
         for (let i = 1; i <= 10; i++) {
            var opcion = document.createElement("option")
            opcion.value = i
            opcion.text = i
            tamañoDiscos.appendChild(opcion)
         }
    }

    if (tipoRaid.value == 1) {
         numdiscos.value = 2
         tamañoDiscos.value = 1
         for (let i = 2; i <= 10; i++) {
            var opcion = document.createElement("option")
            opcion.value = i
            opcion.text = i
            numdiscos.appendChild(opcion)
         }

         for (let i = 1; i <= 10; i++) {
            var opcion = document.createElement("option")
            opcion.value = i
            opcion.text = i
            tamañoDiscos.appendChild(opcion)
         }
    }

    if (tipoRaid.value == 5) {
         numdiscos.value = 3
         tamañoDiscos.value = 1
         for (let i = 3; i <= 10; i++) {
            var opcion = document.createElement("option")
            opcion.value = i
            opcion.text = i
            numdiscos.appendChild(opcion)
         }

         for (let i = 1; i <= 10; i++) {
            var opcion = document.createElement("option")
            opcion.value = i
            opcion.text = i
            tamañoDiscos.appendChild(opcion)
         }
    }

    ri1 = parseInt(numdiscos.value)
    ri2 = parseInt(tamañoDiscos.value)

}


function numdiscCambiado() {
    console.log(numdiscos.value);
    ri1 = parseInt(this.value)

}

function tamañoCambiado() {
    console.log(this.value);
    ri2= parseInt(this.value)
}

var p = document.createElement("p")
var resultado = 0
function calcular(params) {
     
     resultado = 0
     if (parseInt(tipoRaid.value) === 0) {
        resultado = ri1 * ri2;        
    } else if (parseInt(tipoRaid.value) === 1) {
        resultado = ri2;               
    } else if (parseInt(tipoRaid.value) === 5) {
        resultado = (ri1 - 1) * ri2;   
    }

    p.innerText=resultado

    if (ri1 != 0 && ri2 != 0) {
         document.body.appendChild(p)
    }
   
}

