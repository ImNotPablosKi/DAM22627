import 'package:flutter/material.dart';

class ContadorProvider extends ChangeNotifier {

  // Cuando tenemos una clase con provider debemos de poder hacer DOS cosas:
  // 1 - Poder leer el valor de ese estado
  // 2 - Poder modificar ese estado

  int _contador = 0;

  int get contador => _contador;

  void incrementar() {

    _contador++;
    notifyListeners();

  }

    void decrementar() {

    _contador--;
    notifyListeners();

  }

}