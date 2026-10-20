import 'package:flutter/material.dart';

class ListviewScreen extends StatelessWidget {
   
  const ListviewScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("ListView Tipo 1"),),
      body: ListView(
         children: [
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
          Text("Hola a DAM 2"),
         ],
      ),
    );
  }
}