from ejercicio7 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor
from PyQt6.QtCore import Qt

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()
        self.comboBox.currentIndexChanged.connect(self.cambiar)

    def cambiar(self, x):
        with open(f"QtDesigner\estilos\{["estilosEj7", "estilosEj7-2", "estilosEj7-3"][x]}.qss", "r") as f:
            app.setStyleSheet(f.read())
        print(x)

app = QApplication([])

with open("QtDesigner\estilos\estilos7.qss", "r") as f:
    app.setStyleSheet(f.read())

window = MainWindow()
app.exec()