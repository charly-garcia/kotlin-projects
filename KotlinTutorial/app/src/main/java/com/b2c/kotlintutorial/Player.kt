package com.b2c.kotlintutorial

import android.util.Log

class Player (val name: String, var level: Int = 1, var lives: Int = 3, var score: Int = 0) {
    var weapon: Weapon = Weapon("Fist", 1)
    private val inventory = ArrayList<Loot>()

    fun show() {
        if (lives > 0) {
            Log.i("Player", "$name is alive")
        } else {
            Log.i("Player","$name is dead")
        }

    }

    override fun toString(): String {
        return """
            name: $name
            lives: $lives
            level: $level
            score: $score
            weapon: $weapon
        """.trimIndent()
        //damage: ${weapon.damageInflicted}
    }

    fun getLoot(item: Loot) {
        inventory.add(item)
    }

    fun dropLoot(item: Loot): Boolean {
        return if (inventory.contains(item)) {
            inventory.remove(item)
            true
        } else {
            false
        }
    }

    /*fun dropLoot(name: String): Boolean {
        Log.i("Player","$name will be dropped")
        return inventory.removeIf {it.name == name }
    }*/

    fun showInventory() {
        Log.i("Player","$name's Inventory")
        for (item in inventory) {
            Log.i("Player", "$item")
        }
        //Log.i("Player", "$inventory.get(0)")
        Log.i("Player","=================")
    }

}