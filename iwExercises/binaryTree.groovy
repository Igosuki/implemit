enum Dir { LEFT, RIGHT, NONE };
public class Node<T> {
    Node<T> left, right;
    Comparable<T> value;
    Dir compare(Node<T> otherNode) {
        if(value.compareTo(otherNode.value)){
            
        }
    }
}

//Integer binary tree
def random = new Random()
def array = []
for(int i = 1; i <= 1000; i++) {
    array.add(Math.abs(random.nextInt(10*i)));
}
println array
Node<Integer> root = new Node<Integer>()

def addNode(Node<T> toBeAdded) {
    def dir = this.compare(toBeAdded)
    if( dir == LEFT) {
            
    }
}

