class Node<T>(val value: T, var next: Node<T>? = null)

class Queue<T> {
    private var front: Node<T>? = null
    private var rear: Node<T>? = null
    private var size = 0

    fun enqueue(value: T) {

        val newNode = Node(value)
        if (rear != null) {
        rear?.next = newNode
        }
        rear = newNode
        if (front == null) {
        front = rear
        }
        size++
    }
        
    fun dequeue(): T? {
        if (isEmpty()) {
        println("Queue is empty.")
        return null
        }
        val dequeuedValue = front?.value
        front = front?.next
        if (front == null) {
        rear = null
        }
        size--
        return dequeuedValue
    }

    fun peek(): T? {
        return front?.value
    }

    fun isEmpty(): Boolean {
        return front == null
    }
    
    fun size(): Int {
        return size
    }
    
    override fun toString(): String {
        if (isEmpty()) return "[]"
        val result = StringBuilder("[")
        var current = front
        while (current != null) {
        result.append(current.value)
        if (current.next != null) {
        result.append(", ")
        }
        current = current.next
        }
        result.append("]")
        return result.toString()
    }
}

//ejerccio 1
//simulacion de sistema de turnos en un barco
fun main(){
val bancoQueue = Queue<int>()

for(i in 1..10){
bancoQueue.enqueue(i)
}

println("turnos del cliente inicial: $bancoQueue")

for (i in 1..8){
    println("atendiendo al cliente: $(bancoQueue.dequeue())")
}

println("clientes restantes a atender: $(bancoQueue.size())")

println("\n\n :: ejercicio 2 ::.")

val tareasQueue = Queue<String>()

tareasQueue.enqueue("limpiar")
tareasQueue.enqueue("cocinar")
tareasQueue.enqueue("estudiar")
tareasQueue.enqueue("jugar")
tareasQueue.enqueue("leer")
println("tareas pendientes:tareasQueue")

while (tareasQueue.isEmpty()){
println("se esta realizando la tarea de: $(tareasQueue())")
}
}

