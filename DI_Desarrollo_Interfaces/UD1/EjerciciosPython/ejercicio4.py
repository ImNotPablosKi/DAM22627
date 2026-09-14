from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación")

        boton = QPushButton("Pulsa!")

        self.setFixedSize(QSize(400,300)) # Tamaño único FIJO para la ventana (No se puede cambiar)

        self.setCentralWidget(boton)

app = QApplication([])

# Usamos la clase que hemos creado
window = MainWindow()

window.show()

app.exec()