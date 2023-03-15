fun main() {
    val singNum = intArrayOf(11,9,9,55,55)
    println(singleNumber(singNum))

    val x = 50
    println(minSplit(x))

    val notInclude = intArrayOf(1,5,9,10)
    println(notContains(notInclude))

    val addBin = addBinary("1100","0011")
    println(addBin)

    val count = countVariants(50)
    println(countVariants(count))
}
//1

fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (i in nums.indices) {
        result = result xor nums[i]
    }
    return result
}

//2
fun minSplit(amount: Int): Int {
    val coins = intArrayOf(50, 20, 10, 5, 1)
    var count = 0
    var balance = amount
    for (coin in coins) {
        while (balance >= coin) {
            balance -= coin
            count++
        }
    }
    return count
}
//3

fun notContains(array: IntArray): Int {
    array.sort()
    var min = 1
    for (i in array) {
        if (i > min) {
            return min
        } else if (i == min) {
            min++
        }
    }
    return min
}

//4

fun addBinary(a: String, b: String): String {
    var carry = 0
    var i = a.length - 1
    var j = b.length - 1
    var result = ""


    while (i >= 0 || j >= 0) {

        val binA = if (i >= 0) a[i--] - '0' else 0
        val binB = if (j >= 0) b[j--] - '0' else 0
        val sum = binA + binB + carry
        val binSum = sum % 2
        carry = sum / 2
        result = binSum.toString() + result
    }
    if (carry > 0) {
        result = carry.toString() + result
    }

    return result
}
//5

fun countVariants(stepsCount: Int): Int {
    if (stepsCount <= 1) {
        return 1
    }
    var oneStep = 1
    var twoStep = 1
    for (i in 2..stepsCount) {
        val currentStep = oneStep + twoStep
        twoStep = oneStep
        oneStep = currentStep
    }
    return oneStep
}
//6



