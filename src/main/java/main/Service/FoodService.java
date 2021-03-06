package main.Service;

import main.Model.Food;

import java.util.Scanner;

public class FoodService {

    public Food addFood() {
        Food food = new Food();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter food data: ");
        System.out.println();

        System.out.println("Name of food: ");
        food.setName(sc.nextLine());

        System.out.println("Calories: ");
        food.setCalories(sc.nextInt());

        System.out.println("Proteins: ");
        food.setProteins(sc.nextInt());

        System.out.println("Fats: ");
        food.setFats(sc.nextInt());

        return food;

    }
}
