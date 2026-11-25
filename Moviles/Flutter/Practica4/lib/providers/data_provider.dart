import 'package:flutter/material.dart';

class DataProvider extends ChangeNotifier {
  
  String email = "";
  String password = "";

  String get getEmail => email;
  String get getPassword => password;

  void setEmail(String email){
    this.email = email;
  }

  void setPassword(String password){
    this.password = password;
  }

}