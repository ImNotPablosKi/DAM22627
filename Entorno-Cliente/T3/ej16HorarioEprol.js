let dias = ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes"]

let horario = [
    ["IPPE", "PROY", "IPPE", "AD", "SGE"],
    ["DI", "SGE", "AD", "AD", "SGE"],
    ["DI", "SGE", "AD", "AD", "SASP"],
    ["RECREO", "RECREO", "RECREO", "RECREO", "RECREO"],
    ["DWC", "PMDM", "PMDM", "PROY", "DI"],
    ["RECREO", "RECREO", "RECREO", "RECREO", "RECREO"],
    ["DWC", "PMDM", "PMDM", "PSP", "DI"]
];

// ["DWC", "PMDM", "PMDM", "PSP", "DI"]

// Minutos de cada cosa
const mClase = 50
const mRecreo = 15
const mDescanso = 5

const contenedor = document.getElementById("contenedor")


const tabla = document.createElement("table")

let num = 0;

const hora = new Date()

hora.setHours(15)
hora.setMinutes(45)

for (let i = 0; i < 8; i++) {

    const linea = document.createElement("tr")
    for (let j = 0; j < 6; j++) {

        const celda = document.createElement("td")

        if (i == 0) {

            if (j == 0) {

                celda.innerText = " "

            } else {

                celda.innerText = dias[j - 1]

            }

        } else {

            if (j != 0 && i != 0) {

                celda.innerText = horario[i - 1][j - 1]

            }

        }

        if (j == 0 && i != 0) {

            if (horario[i - 1][j] === "RECREO") {

                hora.setMinutes(hora.getMinutes() - mDescanso)

                celda.innerText = `${hora.getHours()}:${hora.getMinutes()}-`

                hora.setMinutes(hora.getMinutes() + mRecreo)

                celda.innerText += `${hora.getHours()}:${hora.getMinutes()}`

            } else {

                celda.innerText = `${hora.getHours()}:${hora.getMinutes()}-`

                hora.setMinutes(hora.getMinutes() + mClase)

                celda.innerText += `${hora.getHours()}:${hora.getMinutes()}`

                hora.setMinutes(hora.getMinutes() + mDescanso)

            }

        }

        linea.appendChild(celda)

        num++

    }

    tabla.appendChild(linea)

}
contenedor.appendChild(tabla)