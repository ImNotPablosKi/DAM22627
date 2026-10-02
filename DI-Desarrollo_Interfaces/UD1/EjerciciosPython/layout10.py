from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QHBoxLayout, QWidget, QVBoxLayout, QPushButton, QRadioButton, QGroupBox, QStackedLayout

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        plantilla = QStackedLayout()

        plantilla.addWidget(Color("red"))
        plantilla.addWidget(Color("green"))
        plantilla.addWidget(Color("blue"))
        plantilla.addWidget(Color("yellow"))

        plantilla.setCurrentIndex(1)

        widget = QWidget()

        widget.setLayout(plantilla)

        self.setCentralWidget(widget)
       
app = QApplication([])
window = MainWindow()
window.show()
app.exec()

