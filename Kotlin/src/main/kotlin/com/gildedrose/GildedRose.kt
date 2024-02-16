package com.gildedrose

private const val BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert"
private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
private const val BRIE = "Aged Brie"

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.forEach { item ->
            if (item.name != SULFURAS) {
                if (item.name in listOf(BRIE, BACKSTAGE)) {
                    if (item.quality < 50) {
                        item.quality += 1

                        if (item.name == BACKSTAGE) {
                            if (item.sellIn < 11) {
                                addQuality(item, 1)
                            }

                            if (item.sellIn < 6) {
                                addQuality(item, 1)
                            }
                        }
                    }
                } else {
                    if (item.quality > 0) {
                        item.quality -= 1
                    }
                }
                item.sellIn -= 1


                if (item.sellIn < 0) {
                    if (item.name == BRIE) {
                        addQuality(item, 1)
                    } else {
                        if (item.name != BACKSTAGE) {
                            if (item.quality > 0) {
                                item.quality -= 1
                            }
                        } else {
                            item.quality -= item.quality
                        }
                    }
                }
            }
        }
    }

    private fun addQuality(item: Item, value: Int) {
        if (item.quality < 50) {
            item.quality += value
        }
    }

}

