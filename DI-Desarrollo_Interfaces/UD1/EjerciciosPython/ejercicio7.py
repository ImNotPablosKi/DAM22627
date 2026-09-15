from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow): # Crear la clase

    cont = 0

    def __init__(self): # Crear la función
        super().__init__() # Llamada al constructor padre

        self.botonPulsado = True

        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Pulsa!")
        boton.setCheckable(True)
        boton.clicked.connect(self.botonactivado)
        boton.setChecked(self.botonPulsado) # Esto determina si el estado del boton está checked o no
        
        self.setFixedSize(QSize(400,300)) # Tamaño único FIJO para la ventana (No se puede cambiar)

        self.setCentralWidget(boton)

    def botonactivado(self,checked):
        self.botonPulsado=checked
        print(self.botonPulsado)

app = QApplication([])

# Usamos la clase que hemos creado
window = MainWindow()

window.show()

app.exec()