from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejercicio de Repaso")

        self.boton = QPushButton("Pulsa!")

        self.boton.clicked.connect(self.pulsadoSoltado)

        self.setCentralWidget(self.boton)

    def pulsadoSoltado(self):
        self.boton.setEnabled(False)
        self.boton.setText("Botón ya pulsado!")

app = QApplication([])

window = MainWindow()

window.show()

app.exec()