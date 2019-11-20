package com.b2c.kotlintutorial

class Weapon(val name: String, val damageInflicted: Int = 1) {

    override fun toString(): String {
        return "$name inflicts $damageInflicted points of damage"
    }
}