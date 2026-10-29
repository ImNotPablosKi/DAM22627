from builtins import super

from PyQt6.QtCore import Qt, QSize, QDate
from PyQt6.QtWidgets import QApplication, QMainWindow, QCalendarWidget, QWidget, QVBoxLayout, QLabel, QLineEdit, QHBoxLayout, QRadioButton, QCheckBox, QPushButton, QComboBox, QDateEdit, QTextEdit, QMessageBox

class MainWindow(QMainWindow):
    
    itemsTierra = ["Bocata Jamón Serrano", "Cocido de Ternera", "Tentempié"]
    itemsMar = ["Yogur Marinado Griego", "Ensaladilla"]

    def __init__(self):
        super().__init__()
        
        self.setWindowTitle("Repaso general de Interfaces")
        self.setFixedWidth(500)

        # Declarar el layout vertical principal
        vLayout = QVBoxLayout()
        
        # Cada fila tiene un layout horizontal para alinear los objetos dentro, y un widget que lo contenga
        # Fila 1
        hLayout1 = QHBoxLayout()
        widget1 = QWidget()
        widget1.setLayout(hLayout1)
        nombre = QLabel("Nombre: ")
        self.inputNombre = QLineEdit()
        
        hLayout1.addWidget(nombre)
        hLayout1.addWidget(self.inputNombre)
        
        # Añadirlo al layout vertical principal para que se muestre
        vLayout.addWidget(widget1)
        
        #Fila 2
        hLayout2 = QHBoxLayout()
        widget2 = QWidget()
        widget2.setLayout(hLayout2)
        apellidos = QLabel("Apellidos: ")
        self.inputApellidos = QLineEdit()
                
        hLayout2.addWidget(apellidos)
        hLayout2.addWidget(self.inputApellidos)
        vLayout.addWidget(widget2)
        
        # Fila 3
        hLayout3 = QHBoxLayout()
        widget3 = QWidget()
        
        # Layout vertical auxiliar para que salgan los radiobuttons uno encima de otro
        vLayout3Aux = QVBoxLayout()
        widget3Aux = QWidget()
        
        labelMenus = QLabel("Menús Disponibles: ")
        self.radioMenuMar = QRadioButton("Mar")
        self.radioMenuTierra = QRadioButton("Tierra")
        self.radioMenuTierra.clicked.connect(self.mostrarMenus)
        self.radioMenuMar.clicked.connect(self.mostrarMenus)
        
        hLayout3.addWidget(labelMenus)
        vLayout3Aux.addWidget(self.radioMenuMar)
        vLayout3Aux.addWidget(self.radioMenuTierra)
        
        hLayout3.addWidget(widget3Aux)
        
        widget3Aux.setLayout(vLayout3Aux)
        
        widget3.setLayout(hLayout3)
        vLayout.addWidget(widget3)
        
        # Fila 4
        self.comboMenus = QComboBox()
        self.comboMenus.setPlaceholderText("Seleccione su menú...")
        vLayout.addWidget(self.comboMenus)
        
        # Fila 5
        hLayout5 = QHBoxLayout()
        widget5 = QWidget()
        
        labelReserva = QLabel("Fecha para la reserva:")
        self.inputReserva = QDateEdit()
        self.inputReserva.setCalendarPopup(True) # Para que aparezca el calendaio al pulsar y deje seleccionar una fecha
        self.inputReserva.setMinimumDate(QDate(2006,1,1)) # Establecer fecha mínima a usar
        
        hLayout5.addWidget(labelReserva)
        hLayout5.addWidget(self.inputReserva)
        
        widget5.setLayout(hLayout5)
        vLayout.addWidget(widget5)
        
        
        # Fila 6
        hLayout6 = QHBoxLayout()
        widget6 = QWidget()
        
        labelResumen = QLabel("Resumen de su reserva:")
        self.inputResumen = QTextEdit()
        
        hLayout6.addWidget(labelResumen)
        
        widget6Aux = QWidget()
        vLayout6Aux = QVBoxLayout()
        widget6Aux.setLayout(vLayout6Aux)
        
        botonConfirmar = QPushButton("Confirmar")
        botonGuardar = QPushButton("Guardar")
        botonReset = QPushButton("Reset")
        
        vLayout6Aux.addWidget(self.inputResumen)
        
        widget6AuxExtra = QWidget()
        hLayout6AuxExtra = QHBoxLayout()
        widget6AuxExtra.setLayout(hLayout6AuxExtra)
        
        hLayout6AuxExtra.addWidget(botonConfirmar)
        hLayout6AuxExtra.addWidget(botonGuardar)
        hLayout6AuxExtra.addWidget(botonReset)
        
        botonGuardar.clicked.connect(self.guardarResumen)
        botonReset.clicked.connect(self.reset)
        botonConfirmar.clicked.connect(self.confirmarReserva)
        
        vLayout6Aux.addWidget(widget6AuxExtra)
        
        hLayout6.addWidget(widget6Aux)
        
        widget6.setLayout(hLayout6)
        vLayout.addWidget(widget6)
        
        # Declarar los elementos principales del programa, el widget que lo contenga todo y su layout vertical
        widgetPrincipal = QWidget()
        widgetPrincipal.setLayout(vLayout)

        # Mostrar el widget como principal    
        self.setCentralWidget(widgetPrincipal)

    def mostrarMenus(self):
        
        # Para que se limpie el combo y no se almacene todo el rato cada lista de menús
        self.comboMenus.clear()
        
        if self.radioMenuTierra.isChecked():
            self.comboMenus.addItems(self.itemsTierra)
        else:
            self.comboMenus.addItems(self.itemsMar)   
            
        # Para que se muestre el placeholder
        self.comboMenus.setCurrentIndex(-1)
    
    def guardarResumen(self):
        self.inputResumen.setText("Nombre: " + self.inputNombre.text())
        self.inputResumen.append("Apellidos: " + self.inputApellidos.text())
        self.inputResumen.append("Menú Seleccionado: " + self.comboMenus.currentText())
        self.inputResumen.append("Fecha de reserva: " + self.inputReserva.text())

    def reset(self):
        self.inputResumen.setText("")   
        self.inputNombre.clear()
        self.inputApellidos.clear()
        self.comboMenus.setCurrentIndex(-1)
        self.inputReserva.setDate(QDate(2006,1,1))
    
    def confirmarReserva(self):
        respuesta = QMessageBox.question(
            self,
            "Confirmar reserva",
            "¿Desea confirmar la reserva?",
            QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No
        )

        if respuesta == QMessageBox.StandardButton.Yes:
            # Si pulsa no, no hace falta hacer nada y el diálogo se cierra
            QMessageBox.information(self, "Reserva", "Reserva confirmada")
        

app = QApplication([])

window = MainWindow()

window.show()

app.exec()