import com.b2c.kotlintutorial.Loot
import com.b2c.kotlintutorial.LootType
import com.b2c.kotlintutorial.Player
import com.b2c.kotlintutorial.Weapon

fun main(args: Array<String>) {
    val tim = Player("Tim")

    tim.weapon = Weapon("Spear", 14)

    val redPotion = Loot("Red Potion", LootType.POTION, 7.5)
    tim.inventory.add(redPotion)
    val chestArmor = Loot("+3 Chest Armor", LootType.ARMOR, 80.00)
    tim.inventory.add(chestArmor)

    tim.showInventory()
    println(tim)
}