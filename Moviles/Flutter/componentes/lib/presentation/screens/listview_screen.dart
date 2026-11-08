import 'package:flutter/material.dart';

class ListviewScreen extends StatelessWidget {
   
  final games = ["Sonic", "Rocket Night Adventures", "Cool Sport", "Micromachines", "Street Fighter II", "Street of Rage 2"];

  ListviewScreen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("ListView Tipo 1"),),
      body: ListView(
         children: [

          // Recorrer la lista, usando llaves siempre DEBES poner return
          ...games.map((juego) => ListTile(
              leading: Icon(Icons.access_alarm),
              title: Text(juego),
              subtitle: Text("Sega Mega Drive"),
              onTap: () => {



              },
          ),),
          Divider()
          
          /*ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            subtitle: Text("Esto es un subtítulo"),
            onTap: () => {



            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),
          ListTile(
            leading: Icon(Icons.access_alarm),
            title: Text("Hola Mundo"),
            onTap: () => {

              

            },
          ),*/
         ],
      ),
    );
  }
}