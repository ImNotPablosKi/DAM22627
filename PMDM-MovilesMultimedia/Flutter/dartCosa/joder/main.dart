void main() {

  // Variables dinamicas, son nuillables
  dynamic cosa = 2;

  // Los maps son pares de valores
  final Map<String, dynamic> pokemon = {

    'nombre': "Ditto",
    "hp": 100,
    "isAlive": true,
    "sprites": {

        1: "ditto/front.jpg", 
        2: "ditto/back.jpg"

    },

  };

  print(pokemon);
  print("Nombre: ${pokemon["nombre"]}");
  print("Nombre: ${pokemon["sprites"]}");

  print("Back: ${pokemon["sprites"][2]}");
  print("Front: ${pokemon["sprites"][1]}");

}
