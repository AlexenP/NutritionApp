package main.Service;

import main.Model.Food;
import main.Model.Menu;
import main.Repository.FoodRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class MenuService {

    public Menu addMenu() {
        Menu menu = new Menu();
        FoodRepository foodRepository = new FoodRepository();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Create a new menu:");
        System.out.println();

        System.out.println("Which meal?");
        System.out.println("--- 1. Breakfast");
        System.out.println("--- 2. Lunch");
        System.out.println("--- 3. Dinner");
        int meal = sc.nextInt();
        if (meal == 1 || meal == 2 || meal == 3)
            menu.setMeal(meal);
        else {
            menu.setMeal(null);
            System.out.println("Error: Data <meal> could not be applied in our database. Please try to enter the data again!");
        }

        addFoodInMenu(menu, foodRepository);
        addNutriotions(menu);
        return menu;
    }

    private void addNutriotions(Menu menu) {
        Set<Food> foods = menu.getFoods();
        for (Food foodSearch : foods) {
            int rezCalories;
            rezCalories = menu.getTotalCalories() + foodSearch.getCalories();
            menu.setTotalCalories(rezCalories);

            int rezProteins;
            rezProteins = menu.getTotalProteins() + foodSearch.getProteins();
            menu.setTotalProteins(rezProteins);

            int rezFats;
            rezFats = menu.getTotalFats() + foodSearch.getFats();
            menu.setTotalFats(rezFats);
        }
    }

    private void addFoodInMenu(Menu menu, FoodRepository foodRepository) {
        Scanner sc = new Scanner(System.in);
        Set<Food> foods = new HashSet<>();

        int option = 0;
        while (option != 9) {
            System.out.println("Here you add food in menu:");
            System.out.println("Press <1> if you want to add food or <9> if you finished to add the food.");

            option = sc.nextInt();
            if (option == 1) {
                List<Food> foodList = foodRepository.findAll();
                System.out.println(foodList);

                System.out.println();
                System.out.println("Select the id of the food: ");
                Food food = foodRepository.findById(sc.nextInt());
                foods.add(food);
            } else {
                System.out.println(option == 9 ? "" : "Unknown option!");
            }
        }

        menu.setFoods(foods);
    }

}
