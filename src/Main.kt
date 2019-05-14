import java.io.File

fun main(){
    val bt = BruteForce(File("6"))
    bt.readFromFile()
    bt.showList()
}