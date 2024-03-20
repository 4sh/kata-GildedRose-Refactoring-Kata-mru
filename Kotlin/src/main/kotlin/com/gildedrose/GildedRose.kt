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
                    updateQuality(item)
                }
            }
        }
    }

    private fun updateQuality(item: Item) {
        when (item.name) {
            BACKSTAGE -> {
                when {
                    item.sellIn < 0 -> {
                        item.addQuality(-item.quality)
                    }
                    item.sellIn < 5 -> {
                        item.addQuality(3)
                    }
                    item.sellIn < 10 -> {
                        item.addQuality(2)
                    }
                    else -> {
                        item.addQuality(1)
                    }
                }
            }
            BRIE -> {
                item.addQuality(1)
                if (item.sellIn < 0) {
                    item.addQuality(1)
                }
            }
            else -> {
                item.addQuality(-1)
                if (item.sellIn < 0) {
                    item.addQuality(-1)
                }
            }
        }
    }

    private fun Item.addQuality(value: Int) {
        quality += value
        quality = quality.coerceIn(0, 50)
    }
}

