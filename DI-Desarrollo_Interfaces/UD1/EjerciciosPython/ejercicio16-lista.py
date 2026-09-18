from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QListWidget

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        lista = QListWidget()
        lista.addItems(["Cosa", "Otra cosa", "Una más"])

        self.setCentralWidget(lista)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()