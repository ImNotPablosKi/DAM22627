import 'package:flutter/material.dart';

class Pagina2 extends StatefulWidget {
  const new({super.key});

  @override
  State<Pagina2> createState() => _Pagina2State();
}

class _Pagina2State extends State<Pagina2> {

  int _contador = 0;

  @override
  Widget build(BuildContext context) {
    return Container(
      color: const Color.fromARGB(255, 137, 0, 0),
      child: Center(
        child: Column(
          children: [
            Text("Esto es un Stateful"),
            Text(_contador.toString(), style: TextStyle(color: Colors.white, fontSize: 120)),
            ElevatedButton(
              onPressed: () {

                setState(() {
                  _contador++;
                });

              },
              child: Text("Incrementar")
            ),
          ],
        ),
      ),
    );
  }
}
