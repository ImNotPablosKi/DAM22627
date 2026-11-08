from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QCheckBox, QApplication, QMainWindow, QLabel, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase

    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        etiqueta = QLabel("Hola!")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignLeft)

        barra = QToolBar("Barra de Herramientas")
        barra.setIconSize(QSize(16,16))
        self.addToolBar(barra)

        boton = QAction(QIcon("UD1/EjerciciosPython/icons/application-dock.png"), "Abrir", self)
        boton.setStatusTip("Boton para abrir")
        boton.triggered.connect(self.botonpulsado)
        barra.addAction(boton)

        barra.addSeparator()

        boton2 = QAction(QIcon("UD1/EjerciciosPython/icons/document.png"), "Nuevo", self)
        boton2.setStatusTip("Nuevo archivo")
        boton2.triggered.connect(self.botonpulsado)
        barra.addAction(boton2)

        barra.addSeparator()

        boton3 = QAction(QIcon("UD1/EjerciciosPython/icons/disk.png"), "Guardar", self)
        boton3.setStatusTip("Boton para guardar")
        boton3.triggered.connect(self.botonpulsado)
        barra.addAction(boton3)

        self.setCentralWidget(etiqueta)

        barra.addAction(boton)

        self.setStatusBar(QStatusBar(self))

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_ayuda = menu.addMenu("&Ayuda")        
         
        menu_archivo.addAction(boton)
        menu_archivo.addAction(boton2)
        menu_archivo.addAction(boton3)
        barra.addSeparator()

        labelX = QAction("X", self)
        labelInstagram = QAction("Instagram", self)
        labelX.setStatusTip("Síguenos en X")
        labelInstagram.setStatusTip("Síguenos en Instagram")

        menu_mas = menu_ayuda.addMenu("Síguenos")
        menu_mas.addAction(labelX)
        menu_mas.addAction(labelInstagram)


    def botonpulsado(self, s):
        print("pulsado", s)

app = QApplication([])
window = MainWindow()
window.show()
app.exec()