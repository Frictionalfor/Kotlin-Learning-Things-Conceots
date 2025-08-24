fun main() {
    val array = mutableListOf(5, 2, 9, 1, 5, 6)
    println("Original Array: $array\n")

    println("Bubble Sort:")
    bubbleSort(array.toMutableList())

    println("\nInsertion Sort:")
    insertionSort(array.toMutableList())

    println("\nMerge Sort:")
    mergeSort(array.toMutableList())

    println("\nQuick Sort:")
    quickSort(array.toMutableList(), 0, array.size - 1)
}

fun bubbleSort(arr: MutableList<Int>) {
    for (i in 0 until arr.size - 1) {
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                arr[j] = arr[j + 1].also { arr[j + 1] = arr[j] }
            }
            println("Step ${i * arr.size + j + 1}: $arr")
        }
    }
}

fun insertionSort(arr: MutableList<Int>) {
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
        println("Step $i: $arr")
    }
}

fun mergeSort(arr: MutableList<Int>, depth: Int = 0): MutableList<Int> {
    if (arr.size <= 1) return arr
    val mid = arr.size / 2
    val left = mergeSort(arr.subList(0, mid).toMutableList(), depth + 1)
    val right = mergeSort(arr.subList(mid, arr.size).toMutableList(), depth + 1)
    val merged = merge(left, right)
    println("Merge at depth $depth: $merged")
    return merged
}

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int> {
    val result = mutableListOf<Int>()
    var i = 0; var j = 0
    while (i < left.size && j < right.size) {
        if (left[i] <= right[j]) result.add(left[i++])
        else result.add(right[j++])
    }
    while (i < left.size) result.add(left[i++])
    while (j < right.size) result.add(right[j++])
    return result
}

fun quickSort(arr: MutableList<Int>, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)
        println("Pivot at index $pi: $arr")
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: MutableList<Int>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] < pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1
}