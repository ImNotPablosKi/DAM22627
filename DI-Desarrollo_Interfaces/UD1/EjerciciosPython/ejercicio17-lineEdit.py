from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QLineEdit

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        texto = QLineEdit()
        texto.setMaxLength(10)
        texto.setPlaceholderText("Texto de placeholder...")

        texto.textChanged.connect(self.textoCambiado)
        texto.returnPressed.connect(self.introPulsado)

        self.setCentralWidget(texto)

    def textoCambiado(self, nombre):
        print(nombre)

    def introPulsado(self):
        print("Intro Pulsado")



app = QApplication([])

window = MainWindow()

window.show()

app.exec()