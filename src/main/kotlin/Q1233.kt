/**
 * 1233. Remove Sub-Folders from the Filesystem
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 */

private fun removeSubfolders(folder: Array<String>): List<String> {
    val sortedFolders = folder.sorted()

    val result = mutableListOf<String>()

    for (currentFolder in sortedFolders) {
        if (result.isEmpty() || !isSubfolder(currentFolder, result.last())) {
            result.add(currentFolder)
        }
    }

    return result
}

private fun isSubfolder(child: String, parent: String): Boolean {
    return child.startsWith("${parent}/")
}

fun main() {
    println(removeSubfolders(arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")))  // ["/a","/c/d","/c/f"]
    println(removeSubfolders(arrayOf("/a", "/a/b/c", "/a/b/d")))                // ["/a"]
    println(removeSubfolders(arrayOf("/a/b/c", "/a/b/ca", "/a/b/d")))           // ["/a/b/c","/a/b/ca","/a/b/d"]
}
