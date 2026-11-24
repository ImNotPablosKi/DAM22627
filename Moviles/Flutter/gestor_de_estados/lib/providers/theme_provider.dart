import 'package:flutter/material.dart';

class ThemeProvider extends ChangeNotifier {

  // Iniciamos el provider
  ThemeMode _themeMode = ThemeMode.system;

  ThemeMode get themeMode => _themeMode;

  void cambiarTheme() {

    _themeMode = _themeMode == ThemeMode.light ? ThemeMode.dark : ThemeMode.light;
    notifyListeners(); // Avisar que se registren los cambios

  }

}