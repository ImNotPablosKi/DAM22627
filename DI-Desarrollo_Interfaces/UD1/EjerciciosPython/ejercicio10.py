from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejercicio de Repaso")

        self.boton = QPushButton("Pulsa!")
        self.boton.setCheckable(True)

        self.boton.clicked.connect(self.pulsadoSoltado)

        self.setCentralWidget(self.boton)

    def pulsadoSoltado(self,pulsado): # Pulsado solo funcionará si utilizamos el setCheckable()
        self.boton.setText(["No pulsado", "Pulsado"][pulsado]) # Las listas SIEMPRE empiezan en 0, y 0 = FALSE / 1 = TRUE

app = QApplication([])

window = MainWindow()

window.show()

app.exec()