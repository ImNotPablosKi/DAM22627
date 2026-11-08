from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow, QLabel, QLineEdit, QVBoxLayout

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Ejercicio de Repaso")

        self.boton = QPushButton("Pulsa!")

        label = QLabel("HOLA")
        input = QLineEdit()

        input.textChanged.connect(label.setText)

        layout = QVBoxLayout()
        layout.addWidget(label)
        layout.addWidget(input)

        contenedor = QWidget()
        contenedor.setLayout(layout)

        self.setCentralWidget(contenedor)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()