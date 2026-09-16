from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow):

    cont = 0

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejercicio de Repaso")

        self.boton = QPushButton("Pulsa!")

        self.boton.setCheckable(True)
        self.boton.pressed.connect(self.pulsado)
        self.boton.released.connect(self.soltado)
        self.boton.clicked.connect(self.pulsadoSoltado)

        self.setFixedSize(QSize(400,300))
        self.setCentralWidget(self.boton)

    def pulsado(self):
        print("Botón pulsado!")

    def soltado(self):
        print("Botón soltado!")

    def pulsadoSoltado(self):
        self.cont += 1
        print("Botón pulsado y soltado!")
        print(self.cont)
        print(self.boton.isChecked())

app = QApplication([])

window = MainWindow()

window.show()

app.exec()