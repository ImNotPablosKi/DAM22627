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
        backgroundColor: Colors.purple.shade900,
        centerTitle: true,
        leading: IconButton(
            onPressed: () {
              contador = 0;
              setState(() {
          
              });
            }, 
            icon: Icon(Icons.refresh_rounded)
          ),
          actions: [
          IconButton(
            onPressed: () {
              contador = 0;
              setState(() {});
            },
            icon: Icon(Icons.refresh_rounded),
          ),
          IconButton(
            onPressed: () {
              contador = 0;
              setState(() {});
            },
            icon: Icon(Icons.refresh_rounded),
          ),
        ],
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: .center,
          children: [
            Text("$contador", style: TextStyle(
              fontSize: 160,
              fontWeight: .w100
            ),),
          
            Text(contador == 1 ? "Click" : "Clicks", style: TextStyle(
              fontSize: 25,
            ),),
          ],
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: .end,
        spacing: 10,
        children: [
          FloatingActionButton(
            shape: StadiumBorder(),
            child: Icon(Icons.add),
            onPressed: () {
              contador++;
              setState(() {
          
              });
            },
          ),
          FloatingActionButton(
            shape: StadiumBorder(),
            child: Icon(Icons.exposure_minus_1),
            onPressed: () {
              contador != 0 ? contador-- : contador = 0;
              setState(() {
          
              });
            },
          ),
          FloatingActionButton(
            shape: StadiumBorder(),
            child: Icon(Icons.refresh_outlined),
            onPressed: () {
              contador = 0;
              setState(() {
          
              });
            },
          ),
        ],
      )
    );

  }
}

