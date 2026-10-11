import os
import time
import keyboard

# Nombre del archivo de guardado
ARCHIVO_DATOS = "pasc.txt"

# Mapeo de frases y sus teclas asignadas (del 1 al 9)
FRASES_CONFIG = {
    "1": "Estos son los buenos",
    "2": "Ahora viene cuando la matan",
    "3": "Me segis el razonamiento",
    "4": "Esto hay que madurarlo",
    "5": "Me seguis el concepto",
    "6": "Como va el tostón",
    "7": "Me he quedado solo?",
    "8": "vale",
    "9": "me explico",
}

# Diccionario interno para llevar la cuenta numérica
contadores = {frase: 0 for frase in FRASES_CONFIG.values()}


def cargar_datos():
    """Carga los contadores desde el archivo txt si existe."""
    if os.path.exists(ARCHIVO_DATOS):
        try:
            with open(ARCHIVO_DATOS, "r", encoding="utf-8") as f:
                for linea in f:
                    linea = linea.strip()
                    if ":" in linea:
                        # Separamos la frase del número asignado
                        frase, valor = linea.rsplit(":", 1)
                        frase = frase.strip()
                        if frase in contadores:
                            contadores[frase] = int(valor.strip())
            print("💾 Datos anteriores cargados con éxito.")
        except Exception as e:
            print(f"⚠️ Error al cargar el archivo (se iniciará de cero): {e}")
    else:
        print("📝 No se encontró archivo previo. Creando una lista nueva.")
        guardar_datos()


def guardar_datos():
    """Guarda el estado actual de los contadores en el archivo txt."""
    try:
        with open(ARCHIVO_DATOS, "w", encoding="utf-8") as f:
            for frase, valor in contadores.items():
                f.write(f"{frase}: {valor}\n")
    except Exception as e:
        print(f"❌ Error al guardar en el archivo: {e}")


def mostrar_consola():
    """Limpia la pantalla de la consola y muestra los valores actuales."""
    # Limpia la consola según el sistema operativo
    os.system("cls" if os.name == "nt" else "clear")
    print("=== CONTADOR DE FRASES EN TIEMPO REAL ===")
    print("Pulsa las teclas del 1 al 9 para sumar. Pulsa 'esc' para salir.\n")
    for tecla, frase in FRASES_CONFIG.items():
        print(f"[{tecla}] {frase}: {contadores[frase]}")
    print("=========================================")


def al_pulsar_tecla(evento):
    """Función que se ejecuta cada vez que se presiona una tecla válida."""
    tecla = evento.name
    if tecla in FRASES_CONFIG:
        frase_asociada = FRASES_CONFIG[tecla]
        contadores[frase_asociada] += 1
        guardar_datos()  # Actualización en tiempo real
        mostrar_consola()


def main():
    cargar_datos()
    mostrar_consola()

    # Escucha el evento de soltar la tecla (para evitar que sume infinitamente si se mantiene pulsada)
    for tecla in FRASES_CONFIG.keys():
        keyboard.on_release_key(tecla, al_pulsar_tecla)

    print("\nPrograma en ejecución. Esperando pulsaciones...")
    # Mantiene el programa activo hasta que se presione la tecla ESC
    keyboard.wait("esc")
    print("\nPrograma cerrado correctamente. ¡Datos a salvo!")


if __name__ == "__main__":
    main()
