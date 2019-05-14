data class Item constructor(val value:Int, val weight: Int){
    override fun toString():String {
        return "Value " + value + " Weight " + this.weight
    }
}