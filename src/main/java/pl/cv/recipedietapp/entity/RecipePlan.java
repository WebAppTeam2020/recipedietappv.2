package pl.cv.recipedietapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecipePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Recipe> recipeId = new ArrayList<>();
    @Column(nullable = false, length = 100)
    private String mealName;
    @OneToMany
    @JoinColumn(name = "display_order")
    private List<DayName> displayOrder = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "dayName_id")
    private List<DayName> dayNameId = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "plan_id")
    private List<Plan> planId = new ArrayList<>();

    public RecipePlan() {
    }

    public long getId() {
        return id;
    }

    public RecipePlan setId(long id) {
        this.id = id;
        return this;
    }

    public List<Recipe> getRecipeId() {
        return recipeId;
    }

    public RecipePlan setRecipeId(List<Recipe> recipeId) {
        this.recipeId = recipeId;
        return this;
    }

    public String getMealName() {
        return mealName;
    }

    public RecipePlan setMealName(String mealName) {
        this.mealName = mealName;
        return this;
    }

    public List<DayName> getDisplayOrder() {
        return displayOrder;
    }

    public RecipePlan setDisplayOrder(List<DayName> displayOrder) {
        this.displayOrder = displayOrder;
        return this;
    }

    public List<DayName> getDayNameId() {
        return dayNameId;
    }

    public RecipePlan setDayNameId(List<DayName> dayNameId) {
        this.dayNameId = dayNameId;
        return this;
    }

    public List<Plan> getPlanId() {
        return planId;
    }

    public RecipePlan setPlanId(List<Plan> planId) {
        this.planId = planId;
        return this;
    }
}
