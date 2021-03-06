package main.Service;

import main.Model.Client;

import java.util.Scanner;

public class ClientService {

    public Client addClient() {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Data of the client:");
        System.out.println();

        System.out.println("First Name: ");
        client.setFirstName(sc.nextLine());

        System.out.println("Last Name: ");
        client.setLastName(sc.nextLine());

        System.out.println("Sex (man or woman):");
        String sex = sc.nextLine();
        if (sex.equalsIgnoreCase("man") || sex.equalsIgnoreCase("woman"))
            client.setSex(sex);
        else {
            typeErrorMessage("sex");
            return typeErrorClient(client);
        }

        System.out.println("Height:");
        client.setHeight(sc.nextInt());

        System.out.println("Weight:");
        client.setWeight(sc.nextInt());

        System.out.println("Physical Activity Level - from 1(very active) to 5(sedentary person)");
        int paLevel = sc.nextInt();
        if (paLevel >= 1 && paLevel <= 5)
            client.setPaLevel(paLevel);
        else {
            typeErrorMessage("paLevel");
            return typeErrorClient(client);
        }

        sc.nextLine();
        System.out.println("Objective (choose 1, 2 or 3):");
        System.out.println("--- 1. Lose weight");
        System.out.println("--- 2. Weight maintenance");
        System.out.println("--- 3. Gain weight");
        int setObective = sc.nextInt();
        if (setObective == 1 || setObective == 2 || setObective == 3)
            client.setObjective(setObective);
        else {
            typeErrorMessage("setObective");
            return typeErrorClient(client);
        }

        return client;
    }

    private Client typeErrorClient(Client client) {
        client.setWeight(null);
        client.setSex(null);
        client.setHeight(null);
        client.setFirstName(null);
        client.setLastName(null);
        client.setPaLevel(null);
        client.setObjective(null);
        return client;
    }

    private void typeErrorMessage(String name) {
        System.out.println("Error: Data <" + name + "> could not be applied in our database. Please try to enter the data again!");
    }

}
