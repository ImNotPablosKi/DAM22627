import 'package:flutter/material.dart';

class BotonScreen extends StatelessWidget {
   
  const BotonScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Botones - Buttons"),
      ),
      body: _Buttons(),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.arrow_back_ios),
        onPressed: (){

        },
      ),
    );
  }
}

class _Buttons extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        ElevatedButton(onPressed: () {}, child: Text("Elevated Button")),
        ElevatedButton(onPressed: null, child: Text("Elevated Button")),
      ],
    );
  }
}