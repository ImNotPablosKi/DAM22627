from PyQt6.QtCore import Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QCalendarWidget

class MainWindow(QMainWindow):

    def __init__(self):
        super().__init__()

        self.setWindowTitle("yes")

        self.calendar = QCalendarWidget()
        self.calendar.selectionChanged.connect(self.mostrarFecha)


        self.setCentralWidget(self.calendar)

    def mostrarFecha(self):

        # Necesario para poder mostrar la fecha en un formato específico
        print(self.calendar.selectedDate().toString("dd/MM/yyyy"))

    def introPulsado(self):
        print("Intro Pulsado")



app = QApplication([])

window = MainWindow()

window.show()

app.exec()