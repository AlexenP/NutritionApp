package main.Service;

import main.Model.Food;
import main.Model.Menu;
import main.Model.Plan;
import main.Repository.FoodRepository;
import main.Repository.MenuRepository;
import main.Repository.PlanRepository;

import java.util.Scanner;

public class AdminService {

    FoodService foodService = new FoodService();
    MenuService menuService = new MenuService();
    PlanService planService = new PlanService();

    public void adminMenu(FoodRepository foodRepository, MenuRepository menuRepository, PlanRepository planRepository) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        while (option != 9) {
            printMenuAdmin();
            option = sc.nextInt();
            switch (option) {
                case 1: {
                    Food food = foodService.addFood();
                    foodRepository.create(food);
                    break;
                }
                case 2: {
                    Menu menu = menuService.addMenu();
                    menuRepository.create(menu);
                    break;
                }
                case 3: {

                    Plan plan = planService.addPlan();
                    planRepository.create(plan);
                    break;
                }
                default:
                    System.out.println(option == 9 ? "" : "Unknown option!");
            }
        }
    }

    private void printMenuAdmin() {
        System.out.println();
        System.out.println("Welcome, Admin! What's in your mind to edit?");
        System.out.println();
        System.out.println("1. Add Food");
        System.out.println("2. Add Menu");
        System.out.println("3. Add Plan");
        System.out.println("9. Exit");
    }
}
