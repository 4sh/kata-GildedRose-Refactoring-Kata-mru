package com.gildedrose

const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
const val SULFURAS = "Sulfuras, Hand of Ragnaros"
const val BRIE = "Aged Brie"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.forEach { item ->

            when (item.name) {
                SULFURAS -> {

                }

                else -> {
                    item.sellIn -= 1
                    item.addQuality(computeQuality(item))
                }
            }
        }
    }

    private fun computeQuality(item: Item): Int =
        when (item.name) {
            BACKSTAGE -> when {
                item.sellIn < 0 -> -item.quality
                item.sellIn < 5 -> 3
                item.sellIn < 10 -> 2
                else -> 1
            }

            BRIE -> {
                if (item.sellIn < 0) {
                    2
                } else {
                    1
                }
            }

            else -> {
                if (item.sellIn < 0) {
                    -2
                } else {
                    -1
                }
            }
        }

    private fun Item.addQuality(value: Int) {
        quality += value
        quality = quality.coerceIn(0, 50)
    }
}

