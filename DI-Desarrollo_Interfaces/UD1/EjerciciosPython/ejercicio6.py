from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow): # Crear la clase

    cont = 0

    def __init__(self): # Crear la función
        super().__init__() # Llamada al constructor padre

        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Pulsa!")
        boton.setCheckable(True)
        boton.clicked.connect(self.botonpulsado)
        boton.clicked.connect(self.saberEstado)

        self.setFixedSize(QSize(400,300)) # Tamaño único FIJO para la ventana (No se puede cambiar)

        self.setCentralWidget(boton)

    def botonpulsado(self):
        print(f"Boton Pulsado {self.cont}")
        self.cont = self.cont + 1

    def saberEstado(self,checked):
        print("¿Botón Pulsado?", checked)

app = QApplication([])

# Usamos la clase que hemos creado
window = MainWindow()

window.show()

app.exec()