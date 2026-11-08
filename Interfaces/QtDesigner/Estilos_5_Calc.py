from calc import MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow, MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

app = QApplication([])

with open("QtDesigner\estilos\estilo5Calc.qss", "r") as f:
    app.setStyleSheet(f.read())

window = MainWindow()
app.exec()