from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QHBoxLayout, QWidget, QVBoxLayout, QPushButton, QRadioButton, QGroupBox, QStackedLayout

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        padre = QVBoxLayout()
        horizontal = QHBoxLayout()
        stacked = QStackedLayout()

        boton1 = QPushButton("red")
        boton2 = QPushButton("green")
        boton3 = QPushButton("yellow")

        boton1.clicked.connect(lambda: stacked.setCurrentIndex(0))
        
        boton2.clicked.connect(lambda: stacked.setCurrentIndex(1))
        boton3.clicked.connect(lambda: stacked.setCurrentIndex(2))

        horizontal.addWidget(boton1)
        horizontal.addWidget(boton2)
        horizontal.addWidget(boton3)

        stacked.addWidget(Color("red"))
        stacked.addWidget(Color("green"))
        stacked.addWidget(Color("yellow"))

        padre.addLayout(horizontal)
        padre.addLayout(stacked)

        widget = QWidget()

        widget.setLayout(padre)

        self.setCentralWidget(widget)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

