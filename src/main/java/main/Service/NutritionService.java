package main.Service;

import main.Model.Client;
import main.Model.Nutrition;
import main.Model.Plan;
import main.Repository.PlanRepository;

import java.util.List;

public class NutritionService {

    public void clientNutritions(Client client) {
        Nutrition nutrition = new Nutrition();
        System.out.println("Client required nutrition:");
        System.out.println();


        System.out.println("Caloric Maintenance:");
        double caloricMaintein = caloricMaintenance(client);
        System.out.println(caloricMaintein + " g");


        System.out.println("Calories needed for your objective:");
        caloriesForObjective(client, caloricMaintein);
        System.out.println("Proteins:");
        proteinRequirements(client);
        System.out.println("Fats:");
        fatRequirments(client);

        System.out.println("Final result, your plan:");
        Plan plan = choosePlan(client, nutrition);
        System.out.println(plan);
    }

    private void fatRequirments(Client client) {
        Double rez = (0.8D * client.getWeight());
        System.out.println(rez + " g");
    }

    private void proteinRequirements(Client client) {
        Double rez = 1.6 * client.getWeight();
        System.out.println(rez + " g");
    }

    private void caloriesForObjective(Client client, double caloricMaintein) {
        Double rez = caloricMaintein ;
        if (client.getObjective() == 1)
            rez -= 500;
        else if (client.getObjective() == 3)
            rez += 500;

        System.out.println(rez+ " g");
    }

    private double caloricMaintenance(Client client) {
        double rez = 0.0;
        if (client.getSex().equalsIgnoreCase("woman")) {
            rez = 655.1 + (4.35 * 2.2 * client.getWeight()) + (4.7 * 0.39 * client.getHeight()) - 117.5;
        } else if (client.getSex().equalsIgnoreCase("man"))
            rez = 66 + (6.2 * 2.2 * client.getWeight()) + (12.7 * 0.39 * client.getHeight()) - 134.1;

        int option = client.getPaLevel();
        switch (option) {
            case 1: {
                rez *= 1.9;
                break;
            }
            case 2: {
                rez *= 1.725;
                break;
            }
            case 3: {
                rez *= 1.55;
                break;
            }
            case 4: {
                rez *= 1.37;
                break;
            }
            case 5: {
                rez *= 1.2;
                break;
            }
        }
        return rez;
    }


    private Plan choosePlan(Client client, Nutrition nutrition) {
        PlanRepository planRepository = new PlanRepository();
        List<Plan> planList;

        if (client.getObjective() == 1)
            planList = planRepository.findLoseWeightPlans();
        else if (client.getObjective() == 2)
            planList = planRepository.findMaintenanceWeightPlans();
        else
            planList = planRepository.findGainWeightPlans();

        Plan chosen = new Plan();
        for (Plan planIndex : planList) {
            int smallestDifference = Integer.MAX_VALUE;

            int comparable;
            comparable = Math.abs(planIndex.getTotalCalories() - nutrition.getCaloriesByObective());

            if (comparable < smallestDifference) {
                smallestDifference = comparable;
                chosen = planIndex;
            }
        }

        return chosen;
    }
}
