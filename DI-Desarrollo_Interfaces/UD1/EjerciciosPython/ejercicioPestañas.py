from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QTabWidget, QWidget, QLabel, QLineEdit, QVBoxLayout, QCheckBox, QHBoxLayout, QPushButton

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        tabs = QTabWidget()
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True)

        widget1 = QWidget()
        horizontal = QHBoxLayout()

        widget1.setLayout(horizontal)
        horizontal.addWidget(QLabel("Hola"))
        horizontal.addWidget(QLineEdit())

        widget2 = QWidget()
        vertical = QVBoxLayout()

        widget2.setLayout(vertical)
        vertical.addWidget(QCheckBox("Seleccion"))
        vertical.addWidget(QPushButton("Pulsa"))

        tabs.addTab(widget1, "pestaña1")
        tabs.addTab(widget2, "pestaña2")
        self.setCentralWidget(tabs)


app = QApplication([])
window = MainWindow()
window.show()
app.exec()

