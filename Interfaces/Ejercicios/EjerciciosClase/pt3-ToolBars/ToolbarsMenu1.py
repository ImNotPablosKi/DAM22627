from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtWidgets import QApplication, QMainWindow, QCalendarWidget, QWidget, QVBoxLayout, QLabel, QLineEdit, QHBoxLayout, QRadioButton, QCheckBox, QPushButton, QComboBox, QDateEdit, QTextEdit, QMessageBox, QStatusBar, QToolBar
from PyQt6.QtGui import QPixmap, QAction, QIcon

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")
        
        etiqueta = QLabel("Etiqueta")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignCenter)
        
        barra = QToolBar("Barrade herramientas")
        barra.setIconSize(QSize(16,16))
        self.addToolBar(barra)
        
        boton = QAction(QIcon("Ejercicios/icons/bug.png"),"Mi botón",self)
        boton.triggered.connect(self.botonPulsado)
        
        barra.addAction(boton)
        
        boton.setStatusTip("Este es mi botón")
        self.setStatusBar(QStatusBar(self))
        
        barra.addSeparator()
        
        boton2 = QAction(QIcon("Ejercicios/icons/cake.png"),"Mi botón 2",self)
        boton2.triggered.connect(self.botonPulsado)
        boton2.setStatusTip("Este es mi botón 2")
        
        barra.addAction(boton2)
        
        barra.addSeparator()
        
        barra.addWidget(QLabel("Texto"))
        barra.addWidget(QCheckBox("Check"))
        
        self.setCentralWidget(etiqueta)

    def botonPulsado(self):
        print("Botón pulsado")
app = QApplication([])
window = MainWindow()
window.show()
app.exec()

