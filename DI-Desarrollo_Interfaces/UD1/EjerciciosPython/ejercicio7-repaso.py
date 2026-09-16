from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow):

    cont = 0

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejercicio de Repaso")

        boton = QPushButton("Pulsa!")
                
        boton.pressed.connect(self.pulsado)
        boton.released.connect(self.soltado)
        boton.clicked.connect(self.pulsadoSoltado)

        self.setFixedSize(QSize(400,300))
        self.setCentralWidget(boton)

    def pulsado(self):
        print("Botón pulsado!")

    def soltado(self):
        print("Botón soltado!")

    def pulsadoSoltado(self):
        self.cont += 1
        print("Botón pulsado y soltado!")
        print(self.cont)

app = QApplication([])

# Usamos la clase que hemos creado
window = MainWindow()

window.show()

app.exec()