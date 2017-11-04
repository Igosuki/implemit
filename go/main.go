package main

import (
	"fmt"
	"gody/trees"
	"math"
	"math/rand"
	"testing"
)

func BenchmarkFunction(b *testing.B) {
	//for i := int64(1); i < u; i++ {
	//	traceStr, tm := trace("test")
	var u int64 = int64(math.Pow(2, 31))
	log2 := math.Log2(float64(u))
	fmt.Printf("log %v\n", math.Ceil(log2))
	var v *trees.VanEmdeBoasTree
	v = trees.NewVanEmdeBoasTree(math.Ceil(log2))
	b.ResetTimer()

	for j := int64(1); j < int64(b.N); j++ {
		v.Insert(float64(rand.Int63n(u)))
	}
}

func BenchmarkLookup(b *testing.B) {
	//for i := int64(1); i < u; i++ {
	//	traceStr, tm := trace("test")
	var u int64 = int64(math.Pow(2, 31))
	log2 := math.Log2(float64(u))
	fmt.Printf("log %v\n", math.Ceil(log2))
	var v *trees.VanEmdeBoasTree
	v = trees.NewVanEmdeBoasTree(math.Ceil(log2))

	for j := int64(1); j < int64(b.N); j++ {
		v.Insert(float64(rand.Int63n(u)))
	}

	b.ResetTimer()
	for j := int64(1); j < int64(b.N); j++ {
		v.Lookup(float64(rand.Int63n(u)))
	}
}

func main() {
	br := testing.Benchmark(BenchmarkFunction)
	fmt.Println(br)
	lookup := testing.Benchmark(BenchmarkLookup)
	fmt.Println(lookup)
}
