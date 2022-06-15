package com.tjay.youthRanking.player;

import jakarta.persistence.*;

@Entity
// If the table annotation is not set with an uppercase name, then the repo will not find the table "player", very silly
@Table(name = "PLAYER")
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "ID") // Same reason like for the table. Has to be uppercase otherwise lowercase will be used
    private Long id;

    @Column(name = "NAME")
    private String name;

    public Player() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
