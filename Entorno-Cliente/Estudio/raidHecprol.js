const raid = document.getElementById("raid")
const discos = document.getElementById("discos")
const size = document.getElementById("size")
const resultado = document.getElementById("resultado")

let minDiscos = 0
let maxDiscos = 0

const nada = document.createElement("option")
nada.innerText = "---"

raid.addEventListener("change", function () {

    discos.innerHTML = ""

    const numRaid = Number(raid.value)

    switch (numRaid) {

        case 0:
            minDiscos = 2
            maxDiscos = 2
            break
        case 1:
            minDiscos = 2
            maxDiscos = 2
            break
        case 5:
            minDiscos = 3
            maxDiscos = 10
            break
        default:
            discos.appendChild(nada)
            minDiscos = 0
            maxDiscos = 0
            return

    }

    for (let i = minDiscos; i < maxDiscos + 1; i++) {

        const opt = document.createElement("option")
        opt.value = i
        opt.innerText = i
        discos.appendChild(opt)

    }

})

for (let i = 1; i < 10; i++) {

    const opt = document.createElement("option")
    opt.innerText = i
    opt.value = i
    size.appendChild(opt)

}

const calcular = () => {

    let tam = Number(discos.value) * Number(size.value)

    const numRaid = Number(raid.value)

    switch (numRaid) {

        case 1:
            tam = tam / 2
            break
        case 5:
            tam = tam - Number(size.value)
            break
    }

    resultado.innerText = tam
}
