package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

class BackstageItem(sellIn: Int, quality: Int) : Item(BACKSTAGE, sellIn, quality)

class SulfurasItem(sellIn: Int, quality: Int) : Item(SULFURAS, sellIn, quality)

class BrieItem(sellIn: Int, quality: Int) : Item(BRIE, sellIn, quality)
