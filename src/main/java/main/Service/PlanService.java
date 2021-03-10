package main.Service;

import main.Model.Menu;
import main.Model.Plan;
import main.Repository.MenuRepository;

import java.util.*;

public class PlanService {

    public Plan addPlan() {
        Plan plan = new Plan();
        MenuRepository menuRepository = new MenuRepository();
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Create a new plan:");
        System.out.println();

        System.out.println("Which plan type?");
        System.out.println("--- 1. Weight loss");
        System.out.println("--- 2. Weight maintenance");
        System.out.println("--- 3. Weight gain");
        int planType = sc.nextInt();
        if (planType == 1 || planType == 2 || planType == 3)
            plan.setPlanType(planType);
        else {
            plan.setPlanType(null);
            System.out.println("Error: Data <meal> could not be applied in our database. Please try to enter the data again!");
        }

        //plan.setMenus(addMenuInPlan(menuRepository));

        addMenuInPlan(plan, menuRepository);
        addNutritions(plan);

        return plan;
    }

    private void addNutritions(Plan plan) {
        List<Menu> menus = new ArrayList<>();

        menus.add(plan.getBreakfast());
        menus.add(plan.getLunch());
        menus.add(plan.getDinner());

        for (Menu menuSearch : menus) {
            int rezCalories;
            //if (menuSearch.getTotalCalories() == 0)
            //    plan.setTotalCalories(plan.getTotalCalories());
            //else
                rezCalories = plan.getTotalCalories() + menuSearch.getTotalCalories();
            plan.setTotalCalories(rezCalories);

            int rezProteins;
            //if (menuSearch.getTotalProteins() == 0)
            //    plan.setTotalProteins(plan.getTotalProteins());
            //else
                rezProteins = plan.getTotalProteins() + menuSearch.getTotalProteins();
            plan.setTotalProteins(rezProteins);

            int rezFats;
            //if (menuSearch.getTotalFats() == 0)
            //    plan.setTotalFats(plan.getTotalFats());
            //else
                rezFats = plan.getTotalFats() + menuSearch.getTotalFats();
            plan.setTotalFats(rezFats);
        }
    }

    private void addMenuInPlan(Plan plan, MenuRepository menuRepository) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Breakfast: ");
        System.out.println();
        List<Menu> menusListBreakfast = menuRepository.findBreakfastAll();
        System.out.println(menusListBreakfast);
        System.out.println();
        System.out.println();

        System.out.println("Choose the breakfast: ");
        try {
            Menu menu = menuRepository.findById(sc.nextInt());
            plan.setBreakfast(menu);
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("Lunch: ");
        System.out.println();
        List<Menu> menusListLunch = menuRepository.findLunchAll();
        System.out.println(menusListLunch);
        System.out.println();
        System.out.println();
        System.out.println("Choose the lunch: ");
        try {
            Menu menu = menuRepository.findById(sc.nextInt());
            plan.setLunch(menu);
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("Dinner: ");
        System.out.println();
        List<Menu> menusListDinner = menuRepository.findDinnerAll();
        System.out.println(menusListDinner);
        System.out.println();
        System.out.println();
        System.out.println("Choose the dinner: ");
        try {
            Menu menu = menuRepository.findById(sc.nextInt());
            plan.setDinner(menu);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
