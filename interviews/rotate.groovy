

def arrazy = [2,4,8,10,12]

def rotate = { array, r ->
    r %= array.size()
    println   "Rotation is ${r}"
    println   "Array size is ${array.size()}"
    println   "Array size - rot is ${array.size() - r}"    
    def tmp
    for(int i  = array.size() - r; i < array.size(); i++) {
        tmp =  array[r - (array.size() - i)]
        println "Swapping at pos ${i} ${array[r-i]} with ${array[i]}" 
        array[r - (array.size() - i)] = array[i] 
        array[i] = tmp
    }
    array
}

println rotate(arrazy, 2)