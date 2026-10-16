from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QWidget, QVBoxLayout, QLabel, QLineEdit, QMenu
from PyQt6.QtGui import QAction

class MainWindow(QMainWindow): # Creación de una clase
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre        
        self.setWindowTitle("Mi aplicación") # Nombre de la ventana

    def contextMenuEvent(self, e):
        context = QMenu(self)
        context.addAction(QAction("Accion 1", self))
        context.addAction(QAction("Accion 2", self))
        context.addAction(QAction("Accion 3", self))
        context.exec(e.globalPos())

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

