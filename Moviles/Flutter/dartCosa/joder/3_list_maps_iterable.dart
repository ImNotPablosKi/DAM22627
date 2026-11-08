void main() {

  final numbers = [1,2,3,4,5,5,5,5,5,6,7,7,8,9,10];

  print("Lista original: ${numbers}");
  print("Tamaño: ${numbers.length}");
  print("Index 0: ${numbers[0]}");
  print("First: ${numbers.first}");
  // print("Reversed: ${numbers.reversed}");

  final reversedNumbers = numbers.reversed;
  print("Iterable: ${reversedNumbers}");
  print("Lista: ${reversedNumbers.toList()}");
  print("Set: ${reversedNumbers.toSet()}");

  final numbersMasQue5 = numbers.where((int num) {
    return num > 5;
  });

  print("Numeros mayores de 5: $numbersMasQue5");

}