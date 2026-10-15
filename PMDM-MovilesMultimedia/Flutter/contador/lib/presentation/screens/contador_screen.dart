import 'package:contador/presentation/widgets/botonPersonalizado.dart';
import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {


  const new({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {

  int contador = 0;

  @override
  Widget build(BuildContext context) {
    
    return Scaffold(
      appBar: AppBar(
        title: Text("Contador App"),
        centerTitle: true,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: .center,
          children: [
            Text("$contador", style: TextStyle(
              fontSize: 160,
              fontWeight: .w100
            ),),
            Text("Clicks", style: TextStyle(
              fontSize: 25,
            ),),
          ],
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: .end,
        spacing: 10,
        children: [
          BotonPersonalizado(icono: Icons.refresh_rounded,),
          BotonPersonalizado(icono: Icons.plus_one,),
          BotonPersonalizado(icono: Icons.exposure_minus_1,),
        ],
      )
    );

  }
}

