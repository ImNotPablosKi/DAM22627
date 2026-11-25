import mysql.connector
from PyQt6.QtWidgets import QMainWindow, QApplication

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("App")

app = QApplication([])
ventana = MainWindow()
ventana.show() 
app.exec()        