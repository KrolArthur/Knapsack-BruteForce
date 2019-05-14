import java.io.File

class BruteForce constructor(var file: File, var list: MutableList<Item> = mutableListOf(), var capacity: Int = 0) {

    fun readFromFile() {
        var list = mutableListOf<Item>()
        this.file.forEachLine {
           val splitted:List<String> = it.split(" ")
            if(splitted.size == 1)
                this.capacity=Integer.valueOf(it)
            else{
                list.add(Item(Integer.valueOf(splitted[0]), Integer.valueOf(splitted[1])))
            }
        }
        this.list = list
    }

    fun showList(){this.list.forEach { item: Item -> println(item.toString()) }}

    fun doJob(){
        var combinations = mutableListOf<>()
    }
}
