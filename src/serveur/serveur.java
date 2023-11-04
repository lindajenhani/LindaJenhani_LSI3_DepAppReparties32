package serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import operation.operation; // Assurez-vous que la classe 'operation' est correctement importée.

public class serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234); // Créez un serveur socket pour écouter sur le port 1234.
            Socket socket = serverSocket.accept(); // Attendez qu'un client se connecte.

            System.out.println("Client connecté");

            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            // Lisez l'objet 'operation' reçu du client.
            operation op = (operation) ois.readObject();

            int result1 = op.getOp1();
            switch (op.getOperation()) {
                case '+':
                    op.setResult1(result1 + op.getOp2());
                    break;
                case '-':
                    op.setResult1(result1 - op.getOp2());
                    break;
                case '*':
                    op.setResult1(result1 * op.getOp2());
                    break;
                case '/':
                    if (op.getOp2() == 0) {
                        throw new ArithmeticException("Division par zéro");
                    }
                    op.setResult1(result1 / op.getOp2());
                    break;
                default:
                    throw new IllegalArgumentException("Opérateur non valide");
            }

            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            // Envoyez l'objet 'operation' avec le résultat au client.
            oos.writeObject(op);

            serverSocket.close(); // Fermez le serveur socket.
            socket.close(); // Fermez la connexion avec le client.

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

