from PyQt6.QtCore import QSize, Qt, QDate
from PyQt6.QtWidgets import QComboBox, QDateEdit, QCalendarWidget, QStatusBar, QApplication, QMainWindow, QHBoxLayout, QWidget, QVBoxLayout, QPushButton, QRadioButton, QGroupBox, QGridLayout, QStackedLayout, QTabWidget, QLabel, QLineEdit, QTextEdit, QCheckBox, QToolBar, QDialog
from PyQt6.QtGui import QPixmap

from cuadrado import Color

class MainWindow(QMainWindow): # Creación de una clase
    
    cont = 0
    
    def __init__(self): # Creación de una función
        super().__init__() # LLamo al constructor del padre
        
        self.setWindowTitle("Mi aplicación")
        
        vLayout = QVBoxLayout()

        # Row 1
        hLayout1 = QHBoxLayout()
        widget1 = QWidget()
        widget1.setLayout(hLayout1)
        lNombre = QLabel("Nombre: ")
        self.inputNombre = QLineEdit()
        
        hLayout1.addWidget(lNombre)
        hLayout1.addWidget(self.inputNombre)
        
        vLayout.addWidget(widget1)
        
        # Row 2
        hLayout2 = QHBoxLayout()
        widget2 = QWidget()
        widget2.setLayout(hLayout2)
        lApellidos = QLabel("Apellidos: ")
        self.inputApellidos = QLineEdit()
                
        hLayout2.addWidget(lApellidos)
        hLayout2.addWidget(self.inputApellidos)
                
        vLayout.addWidget(widget2)
        
        # Row 3
        hLayout3 = QHBoxLayout()
        widget3 = QWidget()
        widget3.setLayout(hLayout3)
        lFecha = QLabel("Fecha de alta: ")
        self.inputFecha = QDateEdit()
        self.inputFecha.setCalendarPopup(True)
        self.inputFecha.setMinimumDate(QDate(2006,1,1))
                        
        hLayout3.addWidget(lFecha)
        hLayout3.addWidget(self.inputFecha)
                        
        vLayout.addWidget(widget3)
        
        # Row 4
        hLayout4 = QHBoxLayout()
        widget4 = QWidget()
        widget4.setLayout(hLayout4)
        lDepartamento = QLabel("Departamento: ")
        self.inputDep = QComboBox()
        self.inputDep.addItems(["Contabilidad","Administración","Producción","Cero"])

        # Row 5
        hLayout5 = QHBoxLayout()
        hLayout5.setAlignment(Qt.AlignmentFlag.AlignRight)
        widget5 = QWidget()
        widget5.setLayout(hLayout5)

        btnEnviar = QPushButton("Enviar")
        btnReset = QPushButton("Reset")
        hLayout5.addWidget(btnEnviar)
        hLayout5.addWidget(btnReset)

        vLayout.addWidget(hLayout5)

        hLayout4.addWidget(lDepartamento)
        hLayout4.addWidget(self.inputDep)

        vLayout.addWidget(widget4)
        
        widget51 = QWidget()
        vLayout51 = QVBoxLayout()
        widget51.setLayout(vLayout51)
        
        hLayout52 = QHBoxLayout()
        widget52 = QWidget()
        widget52.setLayout(hLayout52)

        vLayout51.addWidget(widget52)
        
        widget = QWidget()
        widget.setLayout(vLayout)
        
        vLayout.setContentsMargins(0,0,0,0) # Padding 
        vLayout.setSpacing(0) # Gap
        
        self.setCentralWidget(widget)
    
    def grabar(self):
        self.inputDesc.setText(self.inputNombre.text())
        self.inputDesc.append(self.inputApellidos.text())
        self.inputDesc.append(self.inputFecha.text())
        self.inputDesc.append(self.inputDep.currentText())
    
    def reset(self):
        self.inputDesc.setText("")   
        self.inputNombre.clear()
        self.inputApellidos.clear()
        self.inputFecha.setDate(QDate(2006,1,1))
        self.inputDep.setCurrentIndex(0)

    def botonpulsado(self):
            dialog = QMessageBox(self)
            dialog.setWindowTitle("Cuadro de mensaje")
            dialog.setText("Este es el mensaje de mi cuadro de mensaje!")
            dialog.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
    
            # También podemos poner un Icono, podemos cambiar su "severidad" o tipo
            dialog.setIcon(QMessageBox.Icon.Information)
    
            if dialog.exec() == QMessageBox.StandardButton.Yes:
                print("El usuario ha aceptado")
            else:
                print("El usuario ha rechazado")    

app = QApplication([])
window = MainWindow()
window.show()
app.exec()

