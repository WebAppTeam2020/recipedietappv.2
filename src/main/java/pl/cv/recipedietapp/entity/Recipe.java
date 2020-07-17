package pl.cv.recipedietapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private String ingredients;
    @Column(nullable = false, length = 1000)
    private String description;
    private LocalDateTime created;
    private LocalDateTime updated;
    private int preparationTime;
    @Column(nullable = false, length = 10000)
    private String preparation;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> userId = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    public Recipe() {
    }

    public long getId() {
        return id;
    }

    public Recipe setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public String getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Recipe setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Recipe setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public Recipe setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public Recipe setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
        return this;
    }

    public String getPreparation() {
        return preparation;
    }

    public Recipe setPreparation(String preparation) {
        this.preparation = preparation;
        return this;
    }

    public List<User> getUserId() {
        return userId;
    }

    public Recipe setUserId(List<User> userId) {
        this.userId = userId;
        return this;
    }
}
