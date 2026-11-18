from formulario import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtGui import QPalette, QColor

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()
        self.setupUi(self)
        self.show()

        self.pushButton.pressed.connect(self.escribir)
        self.pushButton_2.pressed.connect(lambda: self.textEdit.append(""))
        self.pushButton_3.pressed.connect(self.borrar)
        self.comboBox.currentIndexChanged.connect(self.cambiarEstilo)

    def escribir(self):
        self.textEdit.append(self.lineEdit.text())
        self.textEdit.setStyleSheet("")

    def borrar(self):
        self.textEdit.setText("")
        self.textEdit.setStyleSheet("border: 2px solid red")


    def cambiarEstilo(self):
        print(self.comboBox.currentIndex())
        app.setStyle(['windows11', 'windowsvista', 'Windows', 'Fusion'][self.comboBox.currentIndex()])


app = QApplication([]) 

with open("estilo.qss","r") as f:
    app.setStyleSheet(f.read())

window = MainWindow() # Hago un objeto QMainWindow que es una ventana
app.exec() # Para que se quede la ventana ablierta