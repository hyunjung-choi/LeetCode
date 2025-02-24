/**
 * 482. License Key Formatting
 * https://leetcode.com/problems/license-key-formatting
 */

private fun licenseKeyFormatting(s: String, k: Int): String {
    var licenseKeyUppercase = s.uppercase().filter { it.isLetterOrDigit() }
    val firstGroup = licenseKeyUppercase.length % k
    val count = licenseKeyUppercase.length / k
    val sb = StringBuilder()

    if (firstGroup != 0) {
        sb.append(licenseKeyUppercase.substring(0, firstGroup)).append("-")
        licenseKeyUppercase = licenseKeyUppercase.removeRange(0, firstGroup)
    }

    repeat(count) {
        sb.append(licenseKeyUppercase.substring(0, k)).append("-")
        licenseKeyUppercase = licenseKeyUppercase.removeRange(0, k)
    }

    return sb.dropLast(1).toString()
}

fun main() {
    println(licenseKeyFormatting("5F3Z-2e-9-w", 4)) // "5F3Z-2E9W"
    println(licenseKeyFormatting("2-5g-3-J", 2))    // "2-5G-3J"
}