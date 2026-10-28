from ejercicio2 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

app = QApplication([])
# Podemos establecer estilos personalizados y colores
app.setStyle("Fusion")

with open("QtDesigner\estilos\estilo1.qss", "r") as f:
    app.setStyleSheet(f.read())

window = MainWindow()
app.exec()