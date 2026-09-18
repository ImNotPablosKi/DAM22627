from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow, QLabel, QLineEdit, QVBoxLayout
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Knigga GOAT")

        label = QLabel()
        label.setPixmap(QPixmap("UD1\EjerciciosPython\img\luisSueno.png"))
        label.setScaledContents(True) # Para que se autoajuste a la ventana
        
        self.setCentralWidget(label)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()