from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        etiqueta = QLabel("Hola")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignCenter)

        barra = QToolBar("Barra de Herramientas")
        self.addToolBar(barra)

        boton = QAction("Mi Botón", self)
        boton.setStatusTip("Este es mi botón")
        boton.triggered.connect(self.botonpulsado)

        self.setCentralWidget(etiqueta)

        barra.addAction(boton)

        self.setStatusBar(QStatusBar(self))

    def botonpulsado(self, s):
        print("pulsado", s)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

