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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_food",
            joinColumns = {@JoinColumn(name = "menuId")},
            inverseJoinColumns = {@JoinColumn(name = "foodId")}
    )
    private Set<Food> foods = new HashSet<>();


    @OneToMany(mappedBy = "breakfast", fetch = FetchType.EAGER)
    private Set<Plan> breakfastPlans;

    @OneToMany(mappedBy = "lunch", fetch = FetchType.EAGER)
    private Set<Plan> lunchPlans;

    @OneToMany(mappedBy = "dinner", fetch = FetchType.EAGER)
    private Set<Plan> dinnerPlans;

    private int totalCalories = 0;
    private int totalProteins = 0;
    private int totalFats = 0;

    public Menu() {
    }

    public Menu(int menuId, Integer meal, Set<Food> foods, int totalCalories, int totalProteins, int totalFats) {
        this.menuId = menuId;
        this.meal = meal;
        this.foods = foods;
        this.totalCalories = totalCalories;
        this.totalProteins = totalProteins;
        this.totalFats = totalFats;
    }

    public Set<Plan> getBreakfastPlans() {
        return breakfastPlans;
    }

    public void setBreakfastPlans(Set<Plan> breakfastPlans) {
        this.breakfastPlans = breakfastPlans;
    }

    public Set<Plan> getLunchPlans() {
        return lunchPlans;
    }

    public void setLunchPlans(Set<Plan> lunchPlans) {
        this.lunchPlans = lunchPlans;
    }

    public Set<Plan> getDinnerPlans() {
        return dinnerPlans;
    }

    public void setDinnerPlans(Set<Plan> dinnerPlans) {
        this.dinnerPlans = dinnerPlans;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId + '\n' +
                ", meal=" + meal +
                ", foods=" + foods +
                ", breakfastPlans=" + breakfastPlans +
                ", lunchPlans=" + lunchPlans +
                ", dinnerPlans=" + dinnerPlans +
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

    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
}
