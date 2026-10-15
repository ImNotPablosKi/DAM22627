void main() {

  final miCuadrado = Cuadrado(lado: 7);

  print("Area: ${miCuadrado.area}");

}

class Cuadrado {

  double _lado = 0;

  Cuadrado({required double lado})
    : assert( lado >= 0, "El lado DEBE ser mayor o igual a 0" ),
    assert(lado < 10, "El lado NO PUEDE ser mayor a 10"),
     _lado = lado;

  // Getters
  double get area {

    return _lado * _lado;

  }

  // Setters
  set lado(double valor) {

    print("El nuevo valor es: $valor");
    
    if (valor < 0) throw "El valor debe ser mayor a cero (0)";

    _lado = valor;

  }

}