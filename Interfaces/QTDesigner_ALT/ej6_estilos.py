from ej6_formulario_ui import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        self.pushButton.clicked.connect(lambda: self.label_4.setStyleSheet("background-color: red;"))
        self.pushButton_2.clicked.connect(lambda: self.label_4.setStyleSheet("background-color: green;"))
        self.pushButton_3.clicked.connect(lambda: self.label_4.setStyleSheet("background-color: blue;"))

        self.pushButton_4.clicked.connect(lambda: self.label_4.setStyleSheet("font-family: Verdana;"))
        self.pushButton_5.clicked.connect(lambda: self.label_4.setStyleSheet("font-family: Arial;"))
        self.pushButton_6.clicked.connect(lambda: self.label_4.setStyleSheet("font-family: Tahoma;"))

        self.pushButton_8.clicked.connect(lambda: self.label_4.setStyleSheet("font-size: 10px;"))
        self.pushButton_7.clicked.connect(lambda: self.label_4.setStyleSheet("font-size: 12px;"))
        self.pushButton_9.clicked.connect(lambda: self.label_4.setStyleSheet("font-size: 14px;"))

app = QApplication([]) # Hago un objeto QApplication

with open("estilos/ej6_estilo.qss","r") as f:
    app.setStyleSheet(f.read())

window = MainWindow() # Hago un objeto QMainWindow que es una ventana
app.exec() # Para que se quede la ventana ablierta