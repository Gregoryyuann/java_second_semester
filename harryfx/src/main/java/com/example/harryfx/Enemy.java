package com.example.harryfx;

public class Enemy {
    private String name;
    private int health;
    private int attack;
    private int defense;
    private int maxHealth;
    private int attackPower;
    private double dodgeChance;

    public Enemy(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return this.name;
    }

    public int attack() {
        return this.attack;
    }

    public int getHealth() {
        return this.health;
    }
    public void  setHealth(int health){
        this.health=health;
    }

    public int getDefense() {
        return this.defense;
    }




    public int getMaxHealth() {
        return this.maxHealth;
    }

    public void takeDamage(int spellDamage) {
        health -= spellDamage;
        if (health < 0) {
            health = 0;
        }
    }




    }
