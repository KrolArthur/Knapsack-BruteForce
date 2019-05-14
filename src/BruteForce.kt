import java.io.File

class BruteForce constructor(var file: File,
                             var list: MutableList<Item> = mutableListOf(),
                             var capacity: Int = 0,
                             var combinations: MutableList<Int> = mutableListOf()) {

    fun readFromFile() {
        var maxWeight: Int = 0
        var maxValue: Int = 0
        var tmpMaxWeight: Int = 0
        var tmpMaxValue: Int = 0
        var vector: CharArray = charArrayOf()
        var additionalVectors: MutableList<CharArray> = mutableListOf()
        this.file.forEachLine {
           val splitted:List<String> = it.split(" ")
            if(splitted.size == 1)
                this.capacity=Integer.valueOf(it)
            else{
                this.list.add(Item(Integer.valueOf(splitted[0]), Integer.valueOf(splitted[1])))
            }
        }
        println(Math.pow(2.toDouble(), this.list.size.toDouble()))
        for(x in 0 until Math.pow(2.toDouble(), this.list.size.toDouble()).toInt()) {
            if(x!=0) {
                val str = convertDecimalToBinary(x).toCharArray()

                for(y in 0 until str.size){
                    //println("comparing " + str.get(y) + " and " + "1")
                    if(str[y].equals('1')) {
                        //println(this.list[y].toString())
                        tmpMaxWeight+=this.list[y].weight
                        tmpMaxValue+=this.list[y].value
                    }
                }
                if(tmpMaxWeight <= this.capacity && tmpMaxValue > maxValue ) {
                    maxValue = tmpMaxValue
                    maxWeight = tmpMaxWeight
                    vector = str
                    additionalVectors.clear()
                    additionalVectors.add(str)

                }else if (tmpMaxWeight <= this.capacity && tmpMaxValue == maxValue){
                    additionalVectors.add(str)
                }
            }
            Thread.sleep(100)
            tmpMaxValue = 0
            tmpMaxWeight = 0
        }
        println()
       additionalVectors.forEach { c: CharArray -> println(c) }
    }

    private fun convertDecimalToBinary(n: Int): String {
        var m = n
        var n = n
        var binaryNumber: String = ""
        var remainder: Int
        var i = 1

        while (n != 0) {
            remainder = n % 2
            n /= 2
            binaryNumber += remainder.toString()
            i *= 10
        }
            // println("$m in decimal = ${binaryNumber} in binary")
        return binaryNumber
    }

}
