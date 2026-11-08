import 'package:flutter/material.dart';

// He escogido el Dismissible como el widget que presentaré
// Permite eliminar o completar un elemento deslizandolo a un lado 

class Practica8 extends StatefulWidget {
  const Practica8({super.key});

  @override
  State<Practica8> createState() => _Practica8State();
}

class _Practica8State extends State<Practica8> {
  List<String> tareas = [
    'Terminar la práctica de Alberto',
    'Estudiar PSP',
    'Estudiar PSP otra vez',
    'Seguir estudiando PSP',
    'Adivina',
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Práctica 8'),
        backgroundColor: Colors.teal,
        foregroundColor: Colors.white,
      ),
      body: ListView.builder(
        itemCount: tareas.length,
        itemBuilder: (context, index) {
          final tarea = tareas[index];
          return Dismissible(
            // La key tiene que ser unica
            key: Key(tarea),
            // Fondo que se ve al deslizar
            background: Container(
              color: Colors.red,
              alignment: Alignment.centerLeft,
              padding: const EdgeInsets.only(left: 20),
              child: const Icon(Icons.delete, color: Colors.white),
            ),
            // Fondo que se ve al deslizar hacia el otro lado
            secondaryBackground: Container(
              color: Colors.green,
              alignment: Alignment.centerRight,
              padding: const EdgeInsets.only(right: 20),
              child: const Icon(Icons.check, color: Colors.white),
            ),
            onDismissed: (direction) {
              setState(() {
                tareas.removeAt(index);
              });
              // direction pone hacia que lado se ha deslizado
              if (direction == DismissDirection.startToEnd) {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('$tarea eliminada')),
                );
              } else {
                ScaffoldMessenger.of(context).showSnackBar(
                  SnackBar(content: Text('$tarea completada')),
                );
              }
            },
            child: ListTile(
              leading: const Icon(Icons.check_circle_outline),
              title: Text(tarea),
            ),
          );
        },
      ),
    );
  }
}