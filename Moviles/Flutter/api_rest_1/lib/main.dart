import 'package:api_rest_1/screens/posts_sreen.dart';
import 'package:api_rest_1/screens/users_screen.dart';
import 'package:flutter/material.dart';

void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'API REST App',
      home: UsersScreen()
    );
  }
}