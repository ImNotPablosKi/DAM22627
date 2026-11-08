# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'form2.ui'
##
## Created by: Qt User Interface Compiler version 6.12.0
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QHBoxLayout, QLabel, QLineEdit,
    QMainWindow, QMenuBar, QRadioButton, QSizePolicy,
    QSpinBox, QStatusBar, QTextEdit, QVBoxLayout,
    QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(356, 432)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.widget = QWidget(self.centralwidget)
        self.widget.setObjectName(u"widget")
        self.widget.setGeometry(QRect(40, 20, 251, 28))
        self.horizontalLayout = QHBoxLayout(self.widget)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.horizontalLayout.setContentsMargins(0, 0, 0, 0)
        self.label = QLabel(self.widget)
        self.label.setObjectName(u"label")

        self.horizontalLayout.addWidget(self.label)

        self.lineEdit = QLineEdit(self.widget)
        self.lineEdit.setObjectName(u"lineEdit")

        self.horizontalLayout.addWidget(self.lineEdit)

        self.widget1 = QWidget(self.centralwidget)
        self.widget1.setObjectName(u"widget1")
        self.widget1.setGeometry(QRect(40, 60, 251, 28))
        self.horizontalLayout_2 = QHBoxLayout(self.widget1)
        self.horizontalLayout_2.setObjectName(u"horizontalLayout_2")
        self.horizontalLayout_2.setContentsMargins(0, 0, 0, 0)
        self.label_2 = QLabel(self.widget1)
        self.label_2.setObjectName(u"label_2")

        self.horizontalLayout_2.addWidget(self.label_2)

        self.spinBox = QSpinBox(self.widget1)
        self.spinBox.setObjectName(u"spinBox")

        self.horizontalLayout_2.addWidget(self.spinBox)

        self.widget2 = QWidget(self.centralwidget)
        self.widget2.setObjectName(u"widget2")
        self.widget2.setGeometry(QRect(40, 190, 251, 161))
        self.horizontalLayout_3 = QHBoxLayout(self.widget2)
        self.horizontalLayout_3.setObjectName(u"horizontalLayout_3")
        self.horizontalLayout_3.setContentsMargins(0, 0, 0, 0)
        self.label_4 = QLabel(self.widget2)
        self.label_4.setObjectName(u"label_4")

        self.horizontalLayout_3.addWidget(self.label_4)

        self.textEdit = QTextEdit(self.widget2)
        self.textEdit.setObjectName(u"textEdit")

        self.horizontalLayout_3.addWidget(self.textEdit)

        self.widget3 = QWidget(self.centralwidget)
        self.widget3.setObjectName(u"widget3")
        self.widget3.setGeometry(QRect(40, 110, 251, 58))
        self.horizontalLayout_4 = QHBoxLayout(self.widget3)
        self.horizontalLayout_4.setObjectName(u"horizontalLayout_4")
        self.horizontalLayout_4.setContentsMargins(0, 0, 0, 0)
        self.label_3 = QLabel(self.widget3)
        self.label_3.setObjectName(u"label_3")

        self.horizontalLayout_4.addWidget(self.label_3)

        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.radioButton = QRadioButton(self.widget3)
        self.radioButton.setObjectName(u"radioButton")

        self.verticalLayout.addWidget(self.radioButton)

        self.radioButton_2 = QRadioButton(self.widget3)
        self.radioButton_2.setObjectName(u"radioButton_2")

        self.verticalLayout.addWidget(self.radioButton_2)


        self.horizontalLayout_4.addLayout(self.verticalLayout)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 356, 33))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"MainWindow", None))
        self.label.setText(QCoreApplication.translate("MainWindow", u"Nombre:", None))
        self.label_2.setText(QCoreApplication.translate("MainWindow", u"Edad:", None))
        self.label_4.setText(QCoreApplication.translate("MainWindow", u"Comentarios:", None))
        self.label_3.setText(QCoreApplication.translate("MainWindow", u"Sexo:", None))
        self.radioButton.setText(QCoreApplication.translate("MainWindow", u"Hombre", None))
        self.radioButton_2.setText(QCoreApplication.translate("MainWindow", u"Mujer", None))
    # retranslateUi

