from formulario3 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor
from PyQt6.QtCore import Qt


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

app = QApplication([]) # Hago un objeto QApplication
app.setStyle("Fusion") # Cambia el estilo de la interfaz en clase hemos visto "Fusion", "Windows", "Windows vista" y "MacOs"

# Para cambiar los colores de los elementos a la app se usan paletas
paleta = QPalette()
paleta.setColor(QPalette.ColorRole.Window, Qt.GlobalColor.red)
paleta.setColor(QPalette.ColorRole.WindowText, QColor(0,255,0))
paleta.setColor(QPalette.ColorRole.Button, QColor("#030303"))
paleta.setColor(QPalette.ColorRole.Highlight, Qt.GlobalColor.yellow)
app.setPalette(paleta)

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

app.exec() # Para que se quede la ventana ablierta