import 'package:componentes/presentation/widgets.dart';
import 'package:flutter/material.dart';

class CardScreen extends StatelessWidget {
   
  const CardScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Tarjetas - Cards"),
      ),
      body: ListView(
        padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        children: [
          CardTipo1(),
          CardTipo2(),
          
        ],
      )
    );
  }
}
