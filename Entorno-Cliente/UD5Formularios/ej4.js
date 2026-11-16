const ciudadesTeruel = ["Teruel Capital", "Alcañiz", "Calamocha"]
const ciudadesZaragoza = ["Zaragoza Capital", "Calatayud", "Ejea de los Caballeros"]
const ciudadesHuesca = ["Huesca Capital", "Jaca", "Barbastro"]

const provincias = document.getElementById("provincias")
//                          Texto que se muestra    valor     defecto?  seleccionado?
const defecto = new Option("Select no seleccionado", "default", true, true)
provincias.add(defecto)

// Escuchar el select para que cuando cambie se llame a la función
provincias.addEventListener("change", cambiarContenido)

function cambiarContenido() {

    // Recoger el valor actual del select de provincias
    const provinciaActual = provincias.value
    const selectCiudades = document.getElementById("ciudades")
    // Limpiar el contenido de las ciudades por si las moscas
    selectCiudades.innerHTML = ""
    
    if (provinciaActual === "teruel") {

        ciudadesTeruel.forEach(ciudad =>{

            // Si no es alcañiz que se rellene de manera estándar
            // En caso contrario que Alcañiz sea la opción seleccionada por defecto
            if (ciudad !== "Alcañiz") {
                    
                const opcion = new Option(ciudad)
                selectCiudades.add(opcion)

            } else {

                const opcion = new Option(ciudad, "alcañiz", true, true)
                selectCiudades.add(opcion)

            }

        })

    } else if (provinciaActual === "zaragoza") {

         ciudadesZaragoza.forEach(ciudad =>{

            const opcion = new Option(ciudad)
            selectCiudades.add(opcion)

        })

    } else if (provinciaActual === "huesca") {

         ciudadesHuesca.forEach(ciudad =>{

            const opcion = new Option(ciudad)
            selectCiudades.add(opcion)

        })

    } else {

        selectCiudades.innerHTML = ""

    }

}

function enviar() {

    // Si ambos select tienen un valor seleccionado, entonces se puede enviar
    const ciudades = document.getElementById("ciudades");
    return provincias.value !== "" && ciudades.value !== "";

}