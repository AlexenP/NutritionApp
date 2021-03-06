package main.App;

import main.Repository.ClientRepository;
import main.Repository.FoodRepository;
import main.Repository.MenuRepository;
import main.Repository.PlanRepository;
import main.Service.OptionMenu;

public class NutritionApp {
    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        FoodRepository foodRepository = new FoodRepository();
        MenuRepository menuRepository = new MenuRepository();
        PlanRepository planRepository = new PlanRepository();
        OptionMenu optionMenu = new OptionMenu();


        System.out.println("->main");

        optionMenu.runConsole(clientRepository, foodRepository, menuRepository, planRepository);

        System.out.println("<-main");
    }
}
