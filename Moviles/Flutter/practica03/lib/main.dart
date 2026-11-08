import 'package:flutter/material.dart';
import 'pantalla1.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Practica 03',
      // La aplicacion empieza en la pantalla 1
      home: Pantalla1(),
    );
  }
}
