package main.Service;

import main.Model.Client;
import main.Repository.ClientRepository;
import main.Repository.FoodRepository;
import main.Repository.MenuRepository;
import main.Repository.PlanRepository;

import java.util.Scanner;

public class OptionMenu {
    ClientService clientService = new ClientService();
    AdminService adminService = new AdminService();

    public void printMenuOne() {
        System.out.println("This is Nutrition App!");
        System.out.println("Types of log in:");
        System.out.println("1. Client");
        System.out.println("2. Admin");
        System.out.println("9. Exit!");
        System.out.println();
        System.out.println("Please enter your choice: ");
    }

    public void runConsole(ClientRepository clientRepository, FoodRepository foodRepository, MenuRepository menuRepository,
                           PlanRepository planRepository) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 9) {
            printMenuOne();
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    Client client = clientService.addClient();
                    clientRepository.create(client);

                    NutritionService nutritionService = new NutritionService();
                    nutritionService.clientNutritions(client);
                    // TODO: afisare plan alimentar si chestia aia cu nutritiile

                    break;
                }
                case 2: {
                    adminService.adminMenu(foodRepository, menuRepository, planRepository);
                    break;
                }
                default:
                    System.out.println(option == 9 ? "" : "Unknown option!");
            }
        }
    }

}
