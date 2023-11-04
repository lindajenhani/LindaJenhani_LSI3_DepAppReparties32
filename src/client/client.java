package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import operation.operation; // Assurez-vous que la classe 'operation' est correctement importée.

public class client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234); // Établissez une connexion avec le serveur sur le port 1234.

            Scanner scanner = new Scanner(System.in);

            System.out.print("Donner le premier opérateur : ");
            int op1 = scanner.nextInt();

            System.out.print("\nDonner l'opération (+, -, *, /) : ");
            String operation;

            do {
                operation = scanner.nextLine();
            } while (!(operation.equals("*")) && !(operation.equals("+")) && !(operation.equals("-")) && !(operation.equals("/")));

            System.out.print("\nDonner le deuxième opérateur : ");
            int op2 = scanner.nextInt();

            scanner.close();

            // Créez un objet 'operation' avec les valeurs entrées par l'utilisateur.
            operation op = new operation(op1, op2, operation.charAt(0));

            // Obtenez un flux de sortie pour envoyer l'objet au serveur.
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(op);

            // Obtenez un flux d'entrée pour recevoir la réponse du serveur.
            InputStream is = socket.getInputStream();
            ObjectInputStream oiss = new ObjectInputStream(is);

            // Lisez l'objet 'operation' retourné par le serveur.
            op = (operation) oiss.readObject();

            // Affichez le résultat de l'opération.
            System.out.println("\n" + op.getOp1() + " " + op.getOperation() + " " + op.getOp2() + " = " + op.getResult1());

            socket.close(); // Fermez la connexion avec le serveur.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

