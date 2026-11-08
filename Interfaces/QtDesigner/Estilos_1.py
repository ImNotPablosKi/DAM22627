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
paleta = QPalette()
paleta.setColor(QPalette.ColorRole.Window, QColor("#DF8B8B"))
paleta.setColor(QPalette.ColorRole.WindowText, QColor("#FBFBFB"))
paleta.setColor(QPalette.ColorRole.Button, QColor(0,255,0))
app.setPalette(paleta)

window = MainWindow()
app.exec()