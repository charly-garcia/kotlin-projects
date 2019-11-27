package com.b2c.kotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val enemy = Enemy

        val uglyTroll = Troll("Ugly Troll", 27, 1)
        println(uglyTroll)
        uglyTroll.takeDamage(8)
        println(uglyTroll)

        val vlad = Vampyre("Vlad")
        println(vlad)
        vlad.takeDamage(8)
        println(vlad)

        /*val tim = Player("Tim")

        tim.weapon = Weapon("Spear", 14)

        val redPotion = Loot("Red Potion", LootType.POTION, 7.5)
        //tim.inventory.add(redPotion)
        tim.getLoot(redPotion)
        val chestArmor = Loot("+3 Chest Armor", LootType.ARMOR, 80.00)
        //tim.inventory.add(chestArmor)
        tim.getLoot(chestArmor)
        tim.getLoot(Loot("Ring of Protection +2", LootType.RING, 40.25))
        tim.getLoot(Loot("Invisibility Potion", LootType.POTION, 35.95))
        tim.showInventory()

        if (tim.dropLoot(redPotion)) {
            tim.showInventory()
        }

        Log.i("MainActivity", "$tim")*/


    }
}
