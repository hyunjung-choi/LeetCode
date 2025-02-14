/**
 * 1352. Product of the Last K Numbers
 * https://leetcode.com/problems/product-of-the-last-k-numbers
 */

class ProductOfNumbers {
    private val prefixProducts = mutableListOf(1)

    fun add(num: Int) {
        if (num == 0) {
            prefixProducts.clear()
            prefixProducts.add(1)
        } else {
            prefixProducts.add(prefixProducts.last() * num)
        }
    }

    fun getProduct(k: Int): Int {
        if (k >= prefixProducts.size) return 0
        return prefixProducts.last() / prefixProducts[prefixProducts.size - 1 - k]
    }
}

fun main() {
    val productOfNumbers = ProductOfNumbers()
    productOfNumbers.add(3)       // [3]
    productOfNumbers.add(0)       // [3, 0] -> 모든 값 무효화
    productOfNumbers.add(2)       // [2]
    productOfNumbers.add(5)       // [2, 5]
    productOfNumbers.add(4)       // [2, 5, 4]
    println(productOfNumbers.getProduct(2))  // 20 (5 * 4)
    println(productOfNumbers.getProduct(3))  // 40 (2 * 5 * 4)
    println(productOfNumbers.getProduct(4))  // 0 (0 포함됨)
    productOfNumbers.add(8)       // [2, 5, 4, 8]
    println(productOfNumbers.getProduct(2))  // 32 (4 * 8)
}