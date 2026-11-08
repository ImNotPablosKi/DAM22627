from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton, QDialog, QDialogButtonBox, QVBoxLayout, QLabel

class CustomDialog(QDialog): # Creación de una clase
    
    def __init__(self, parent=None): # Creación de una función
        super().__init__(parent) # LLamo al constructor del padre
        
        self.setWindowTitle("Cuadro de diálogo")

        # Puedes poner varios tipos de botones a la misma variable siempre que separes con tuberías
        QBtn = QDialogButtonBox.StandardButton.Ok | QDialogButtonBox.StandardButton.Cancel

        self.dialogBox = QDialogButtonBox(QBtn)
        self.dialogBox.accepted.connect(self.accept) # Rol para aceptar
        self.dialogBox.rejected.connect(self.reject) # Rol para rechazar

        self.plantilla = QVBoxLayout()
        mensaje = QLabel("Algo ha sucedido, ¿Todo Ok?")
        self.plantilla.addWidget(mensaje)
        self.plantilla.addWidget(self.dialogBox)
        self.setLayout(self.plantilla)

