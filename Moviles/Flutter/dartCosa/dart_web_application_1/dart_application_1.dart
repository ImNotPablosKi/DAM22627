void main() {

    // Variables dinamicas, son nuillables
  dynamic cosa = 2;

  // Los maps son pares de valores
  final pokemon = {

    'nombre': "Ditto",
    "hp": 100,
    "isAlive": true,
    "sprites": {

      1: "ditto/front.jpg",
      2: "ditto/back.jpg"

    }

  };

  print(pokemon);
  print("Nombre: ${pokemon["nombre"]}");

}