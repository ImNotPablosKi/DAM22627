void main() {

  final wolverine = Heroe(nombre: "Logan", poder: "Regeneracion");

  print(wolverine);
  print(wolverine.nombre);
  print(wolverine.poder);
}

class Heroe {

  String nombre;
  String poder;

  Heroe({

    required this.nombre,
    this.poder = "ninguno"

  });

  @override
  String toString() {
    return "$nombre - $poder";
  }

}