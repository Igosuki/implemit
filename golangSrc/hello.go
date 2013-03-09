package main

import (
	"fmt"
	"math"
)

const IAMYOURMASTER = true

func main() {
	fmt.Println("Happy", math.Pi, "Day")
	fmt.Printf("Now you have %g problems\n", math.Nextafter(2,3))
	fmt.Printf("2 + 3 : %d \n", add(2,3))
	var somestring string = "abcd"
	fmt.Printf("declareted string : %s \n", somestring)
	//Declare a closure
	sum := func(a int, b int) int { return (a + b) }
	var summed int = sum(3, 4)
	fmt.Printf("summed : %d \n", summed)
	//Use chars as bytes
	var a int8 = 'a'
	fmt.Printf("The alphabet in Go : [")
	for i := a; int8(i) < a + int8(26); i++ {
		fmt.Printf("%c = %d", int8(i), i)
		if(int8(i) < a + int8(25)) {
			fmt.Printf(", ")
		}
	}
	fmt.Printf("]\n")
	//Create an array 
	b := make([]int, 2)
	b[1] = 10
	var y = b[1]
	z := b[1]
	fmt.Println(y,z)
	//var p *string
	//Declare a pointer and allocate something to that
	var p* int = new(int)
	*p = 0
	x := *p
	x += 1
	//Curious, string to int conversion only works for uint8
	//Cast a string to an array of ints
	fmt.Println([]uint8("blabla"), (*uint8)(nil))
	fmt.Println(swap("am", "I"))
	fmt.Println(split(9))
	//Declare multiple vars at once
	//var first, second, third int
	//var c, python, java bool
	//No need to specify the type if you initialize the variable
	//var cpp, erlang, haskell = true, false, "blabliblo"
	//Or, only in functions : 
	//cpp, erlang, haskell := true, false, "blabliblo"
}

//Simple function with all it needs
func add(x int, y int) int {
	return x + y
}

//Type is applied to all the previous parameters until another type is encountered
func sub(x, y int) int {
	return x - y
}

//Return a couple of results
func swap(a, b string) (string ,string) {
	return b, a
}

//You can name return parameters
func split(sum int) (x, y int) {
	x = sum *4/9
	y = sum - x
	return
}