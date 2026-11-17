import 'package:flutter/material.dart';
import 'package:gestor_de_estados/screens/home_screen.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Gestor de estados',
      home: HomeScreen(),
      debugShowCheckedModeBanner: false,
    );
  }
}