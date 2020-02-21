class Queue (list:MutableList<Any>){

    var items:MutableList<Any> = list

    fun isEmpty():Boolean = items.isEmpty()

    fun size():Int = items.count()

    override  fun toString() = items.toString()

    fun enqueue(element:Any){
        items.add(element)
    }

    fun dequeue():Any?{
        return if (this.isEmpty()) {
            null
        } else {
            items.removeAt(0)
        }
    }

    fun peek():Any?{
        return items[0]
    }

    fun main(args: Array<String>) {
        var a = Queue(mutableListOf("karthiq",2,3,"four"))

        //add 7 to Queue
        println(a.enqueue(7))
        println(a)//prints all elements
        //remove from Queue
        println(a.dequeue())
        println(a)//prints all elements present
        // fetch what is first element
        println(a.peek())
        println(a)
        // print the number of elements
        println(a.size())
        // check whether Queue is empty
        println(a.isEmpty())
    }
}
