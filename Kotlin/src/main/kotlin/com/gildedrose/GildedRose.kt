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
                    updateQualityBeforeSellIn(item)

                    item.sellIn -= 1

                    updateQualityAfterSellIn(item)
                }
            }
        }
    }

    private fun updateQualityBeforeSellIn(item: Item) {
        when (item.name) {
            BACKSTAGE -> {
                if (item.sellIn < 6) {
                    item.addQuality(3)
                } else if (item.sellIn < 11) {
                    item.addQuality(2)
                } else {
                    item.addQuality(1)
                }
            }
            BRIE -> item.addQuality(1)
            else -> item.addQuality(-1)
        }
    }

    private fun updateQualityAfterSellIn(item: Item) {
        if (item.sellIn < 0) {
            if (item.name == BRIE) {
                item.addQuality(1)
            } else {
                if (item.name != BACKSTAGE) {
                    item.addQuality(-1)
                } else {
                    item.addQuality(-item.quality)
                }
            }
        }
    }

    private fun Item.addQuality(value: Int) {
        quality += value
        quality = quality.coerceIn(0, 50)
    }
}

