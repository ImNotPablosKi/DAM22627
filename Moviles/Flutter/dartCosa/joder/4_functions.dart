void main() {

  print(saludar());

  print(sumar(2, 3));

  print(sumarOpcional(5, 5));

  print(saludoCompleto(mensaje: "Que te den,", nombre: "Pablo"));
}

String saludar() => "Hola Pablo!";

int sumar(int a, int b) => a + b;

int sumarOpcional(int a, [int b = 0]) {

  return a + b;

}

// Parámetros con nombre
String saludoCompleto({required String nombre, String mensaje = "Hola, "}) {

  return "$mensaje $nombre!";

}