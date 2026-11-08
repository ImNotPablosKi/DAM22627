import 'package:flutter/material.dart';

class Listview2Screen extends StatelessWidget {
   
  final games = ["Sonic", "Rocket Night Adventures", "Cool Sport", "Micromachines", "Street Fighter II", "Street of Rage 2"];

  Listview2Screen({super.key});
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("ListView Tipo 2"),),
      body: ListView.separated(
        itemBuilder: (context, index) {
          
          return ListTile(
              leading: Icon(Icons.access_alarm),
              title: Text(games[index]),
              subtitle: Text("Sega Mega Drive"),
              onTap: () => {



              },
          );
        },
        separatorBuilder: (_, _) => Divider(),
        itemCount: games.length
      )
    );
  }
}