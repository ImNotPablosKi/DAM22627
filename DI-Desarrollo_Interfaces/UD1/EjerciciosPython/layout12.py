from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QTabWidget, QWidget, QVBoxLayout, QPushButton, QRadioButton, QGroupBox, QStackedLayout

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")

        tabs = QTabWidget()
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True)

        tabs.addTab(Color("red"), "rojo")
        tabs.addTab(Color("green"), "verde")
        tabs.addTab(Color("blue"), "azul")
        tabs.addTab(Color("yellow"), "amarillo")

        self.setCentralWidget(tabs)


app = QApplication([])
window = MainWindow()
window.show()
app.exec()

