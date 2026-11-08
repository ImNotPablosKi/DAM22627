from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QWidget, QPushButton, QMainWindow, QLabel, QLineEdit, QVBoxLayout

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("Knigga GOAT")

        label = QLabel("Noah Knigga best player 2026!")
        formato = label.font()
        formato.setPointSize(30)
        formato.setFamily("Jetbrains Mono")
        formato.setBold(True)
        label.setFont(formato)
        label.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter)

        self.setCentralWidget(label)

app = QApplication([])

window = MainWindow()

window.show()

app.exec()