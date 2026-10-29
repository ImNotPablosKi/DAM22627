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
          Card(
            child: Column(
              children: [
                ListTile(
                  leading: Icon(Icons.photo_album_outlined),
                  title: Text("Soy un Título!"),
                  subtitle: Text("Deserunt ex dolor adipisicing in nostrud sit esse."),
                )
              ],
            ),
          )
        ],
      )
    );
  }
}