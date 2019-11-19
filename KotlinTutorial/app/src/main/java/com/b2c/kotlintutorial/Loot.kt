package com.b2c.kotlintutorial

enum class LootType {
    POTION, RING, ARMOR
}

class Loot(val name: String, val type: LootType, val value: Double) {
}