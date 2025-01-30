private fun solution(emails: Array<String>): Int {
    return emails.mapNotNull { email ->
        email.split("@").takeIf { it.size == 2 && it[1].endsWith(".com") }?.let { (local, domain) ->
            local.filter { it != '.' }.takeWhile { it != '+' } + "@$domain"
        }
    }.distinct().count()
}

fun main() {
    val emails1 = arrayOf(
        "test.email+james@coding.com",
        "test.e.mail+toto.jane@cod.ing.com",
        "testemail+tom@cod.ing.com"
    )

    val emails2 = arrayOf(
        "a@coding.com",
        "b@coding.com",
        "c@coding.com"
    )

    println(solution(emails1)) // 2
    println(solution(emails2)) // 3
}