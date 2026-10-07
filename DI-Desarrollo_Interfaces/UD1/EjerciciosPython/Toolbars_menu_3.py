from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QCheckBox, QApplication, QMainWindow, QLabel, QToolBar, QStatusBar
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
        barra.setIconSize(QSize(16,16))
        self.addToolBar(barra)

        boton = QAction(QIcon("UD1/EjerciciosPython/icons/bug.png"), "Mi Botón", self)
        boton.setStatusTip("Este es mi otro botón")
        boton.triggered.connect(self.botonpulsado)
        barra.addAction(boton)

        barra.addSeparator()

        boton2 = QAction(QIcon("UD1/EjerciciosPython/icons/cake.png"), "Mi Botón", self)
        boton2.setStatusTip("Este es mi botón")
        boton2.triggered.connect(self.botonpulsado)
        barra.addAction(boton2)

        barra.addSeparator()

        barra.addWidget(QLabel("Texto"))
        barra.addWidget(QCheckBox("Selección"))

        self.setCentralWidget(etiqueta)

        barra.addAction(boton)

        self.setStatusBar(QStatusBar(self))

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_editar = menu.addMenu("&Editar")        
        menu_insertar = menu.addMenu("&Insertar")        
        menu_archivo.addAction(boton)
        menu_archivo.addAction(boton2)
        barra.addSeparator()
        menu_mas = menu_archivo.addMenu("Más")
        menu_mas.addAction(boton)
        menu_mas.addAction(boton2)


    def botonpulsado(self, s):
        print("pulsado", s)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

