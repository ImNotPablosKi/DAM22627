import 'package:flutter/material.dart';

class CustomInputField extends StatelessWidget {

  final String? hintText;
  final String? labelText;
  final String? helperText;
  final IconData? icon;
  final IconData? suffixIcon;

  final TextInputType? keyboardType;
  final bool obscureText;

  const new({
    super.key,
    this.hintText,
    this.labelText,
    this.helperText,
    this.icon,
    this.suffixIcon,
    this.keyboardType,
    this.obscureText = false
  });

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      // autofocus: true,
      initialValue: "",
      textCapitalization: .words,
      keyboardType: keyboardType,
      obscureText: obscureText,
      onChanged: (value) {
        print(value);
      },
      validator: (value) {
        if (value == null) return "Este campo es requerido!";
        return value.length < 3 ? "Mínimo de 3 Carácteres" : null;
      },
      autovalidateMode: .onUserInteraction,
      decoration: InputDecoration(
        hintText: hintText,
        labelText: labelText,
        helperText: helperText,
        suffixIcon: suffixIcon == null ? null : Icon(suffixIcon),
        //prefixIcon: Icon(Icons.group_add_rounded)
        icon: icon == null ? null : Icon(icon),
        border: OutlineInputBorder(
          borderRadius: .only(
            bottomLeft: Radius.circular(10),
            topRight: Radius.circular(10)
    
          )
        ),
        focusedBorder: OutlineInputBorder(
          borderSide: BorderSide(
            color: Colors.pinkAccent
          )
        )
        // counterText: "Contador"
      ),
    );
  }
}