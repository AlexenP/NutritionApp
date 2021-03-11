package main.Model;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Client client;

    @Column(name = "planType")
    private Integer planType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breakfastId", nullable = false)
    private Menu breakfast;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lunchId", nullable = false)
    private Menu lunch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dinnerId", nullable = false)
    private Menu dinner;

    private int totalCalories = 0;
    private int totalProteins = 0;
    private int totalFats = 0;

    public Plan() {
    }

    public Plan(int planId, Integer planType, Menu breakfast, Menu lunch, Menu dinner, int totalCalories, int totalProteins, int totalFats) {
        this.planId = planId;
        this.planType = planType;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.totalCalories = totalCalories;
        this.totalProteins = totalProteins;
        this.totalFats = totalFats;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "planId=" + planId +
                ", planType=" + planType +
                ", breakfast=" + breakfast +
                ", lunch=" + lunch +
                ", dinner=" + dinner +
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

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    public Menu getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Menu breakfast) {
        this.breakfast = breakfast;
    }

    public Menu getLunch() {
        return lunch;
    }

    public void setLunch(Menu lunch) {
        this.lunch = lunch;
    }

    public Menu getDinner() {
        return dinner;
    }

    public void setDinner(Menu dinner) {
        this.dinner = dinner;
    }
}
