import 'package:flutter/material.dart';

class CardTipo1 extends StatelessWidget {
  const new({
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      child: Column(
        children: [
          ListTile(
            leading: Icon(Icons.photo_album_outlined),
            title: Text("Soy un Título!"),
            subtitle: Text("Deserunt ex dolor adipisicing in nostrud sit esse."),
          ),
          Padding(
            padding: const EdgeInsets.only(right: 5),
            child: Row(
              mainAxisAlignment: .end,
              children: [
              TextButton(onPressed: (){}, child: Text("Cancelar")),
              TextButton(onPressed: (){}, child: Text("OK")),
            ],),
          )
        ],
      ),
    );
  }
}