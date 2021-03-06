package main.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuId;

    @Column(name = "meal")
    private Integer meal;

    @ManyToMany(mappedBy = "menus")
    private Set<Plan> plans = new HashSet<Plan>();

    @ManyToMany
    @JoinTable(
            name = "menu_food",
            joinColumns = {@JoinColumn(name = "menuId")},
            inverseJoinColumns = {@JoinColumn(name = "foodId")}
    )
    private Set<Food> foods = new HashSet<Food>();

    private int totalCalories = 0;
    private int totalProteins = 0;
    private int totalFats = 0;

    public Menu() {
    }

    public Menu(int menuId, Integer meal, Set<Plan> plans, Set<Food> foods, int totalCalories, int totalProteins, int totalFats) {
        this.menuId = menuId;
        this.meal = meal;
        this.plans = plans;
        this.foods = foods;
        this.totalCalories = totalCalories;
        this.totalProteins = totalProteins;
        this.totalFats = totalFats;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", meal=" + meal +
                ", plans=" + plans +
                ", foods=" + foods +
                ", totalCalories=" + totalCalories +
                ", totalProteins=" + totalProteins +
                ", totalFats=" + totalFats +
                '}' + '\n';
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getTotalProteins() {
        return totalProteins;
    }

    public void setTotalProteins(int totalProteins) {
        this.totalProteins = totalProteins;
    }

    public int getTotalFats() {
        return totalFats;
    }

    public void setTotalFats(int totalFats) {
        this.totalFats = totalFats;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getMeal() {
        return meal;
    }

    public void setMeal(Integer meal) {
        this.meal = meal;
    }

    public Set<Plan> getPlans() {
        return plans;
    }

    public void setPlans(Set<Plan> plans) {
        this.plans = plans;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}
