from PyQt6.QtWidgets import QMainWindow, QRadioButton, QMessageBox, QDateEdit, QComboBox, QHBoxLayout, QTextEdit, QWidget, QApplication, QVBoxLayout, QPushButton, QStackedLayout, QTabWidget, QLabel, QLineEdit, QCheckBox, QToolBar, QStatusBar
from PyQt6.QtGui import QAction, QIcon, QPalette, QColor
from PyQt6.QtCore import Qt, QSize, QDate

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        # <=========Cosas==========>
        layoutPrincipal = QVBoxLayout()
        self.acum = 0

        # <=========Texto==========>
        self.campo = QLabel()
        self.campo.setAlignment(Qt.AlignmentFlag.AlignRight)

        layoutPrincipal.addWidget(self.campo)

        # <=========Layouts==========>

        layoutH1 = QHBoxLayout()
        layoutH2 = QHBoxLayout()
        layoutH3 = QHBoxLayout()
        layoutH4 = QHBoxLayout()
        layoutH5 = QHBoxLayout()

        # <=========Boton +==========>

        botonSuma = QPushButton("+")

        botonSuma.pressed.connect(self.sumar)

        layoutH4.addWidget(botonSuma)

        # <=========Botones numericos==========>
        for i in range(0,10):
            boton = QPushButton(str(i))
            #print(boton.text())
            boton.pressed.connect(self.escribir)
            if i>=7:
                layoutH1.addWidget(boton)
            elif i>=4:
                layoutH2.addWidget(boton)
            elif i>=1:
                layoutH3.addWidget(boton)
            else:
                layoutH4.addWidget(boton)

        # <=========Botones CE y = ==========>

        botonIgual = QPushButton("=")

        botonIgual.pressed.connect(self.igual)

        layoutH4.addWidget(botonIgual)

        botonCE = QPushButton("CE")

        botonCE.pressed.connect(self.ce)

        layoutH5.addWidget(botonCE)
        

        # <=========Añado los layouts con los botones==========>

        layoutPrincipal.addLayout(layoutH1)
        layoutPrincipal.addLayout(layoutH2)
        layoutPrincipal.addLayout(layoutH3)
        layoutPrincipal.addLayout(layoutH4)
        layoutPrincipal.addLayout(layoutH5)

        widget = QWidget()
        widget.setLayout(layoutPrincipal)
        self.setCentralWidget(widget)

        # Para referenciarlo en el qss
        botonCE.setObjectName("ce")
        botonSuma.setObjectName("suma")
        botonIgual.setObjectName("igual")


    def escribir(self):
        self.campo.setText(self.campo.text()+self.sender().text())

    def igual(self):
        if self.campo.text() != "":
            self.campo.setText(str(int(self.campo.text())+self.acum))
            self.acum = int(self.campo.text())

    def sumar(self):
        if self.campo.text() != "":
            self.acum = int(self.campo.text())
            self.campo.clear()

    def ce(self):
        self.campo.clear()
        self.acum = 0
    


# Ejecución de la app
app = QApplication([]) # Hago un objeto QApplication

window = MainWindow() # Hago un objeto QMainWindow que es una ventana

with open("estilos/ej3_estilo.qss","r") as f:
    app.setStyleSheet(f.read())

paleta = QPalette()
paleta.setColor(QPalette.ColorRole.Window, QColor("#ACACAC"))

app.setPalette(paleta)

window.show() # Muestra la ventana, sin "app.exec()" se muestra solo un instante

app.exec() # Para que se quede la ventana ablierta
