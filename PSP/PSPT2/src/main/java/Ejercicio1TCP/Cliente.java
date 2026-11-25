package Ejercicio1TCP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (
            Socket servidor = new Socket("127.0.0.1", 5324);
            PrintWriter out = new PrintWriter(servidor.getOutputStream(), true);
            Scanner in = new Scanner(servidor.getInputStream());
        ){
            while (true) {
                String resp;
                while (!(resp = in.nextLine()).equals("0")) {
                    System.out.println(resp);
                }

                String op;
                System.out.print("> ");
                out.println(op = sc.nextLine());

                if (op.equals("0")) break;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
