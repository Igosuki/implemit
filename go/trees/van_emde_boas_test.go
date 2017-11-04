package trees

import (
	"fmt"
	"log"
	"math"
	"math/rand"
	"reflect"
	"strconv"
	"testing"
	"time"
)

func timeTrack(start time.Time, name string) {
	elapsed := time.Since(start)
	log.Printf("%s took %s", name, elapsed)
}

func TestVanEmdeBoasTree_Insert(t *testing.T) {
	type args struct {
		k float64
	}
	type testArgs struct {
		name string
		args args
	}
	tests := make([]testArgs, 0, 0)
	var u int64 = int64(math.Pow(2, 10))
	var maxVal float64
	for i := int64(1); i < u; i++ {
		theRand := float64(rand.Int63n(u))
		if theRand > maxVal {
			maxVal = theRand
		}
		tests = append(tests, testArgs{name: "thetest" + strconv.Itoa(int(i)), args: args{theRand}})
	}
	defer timeTrack(time.Now(), "hugetree")
	log2 := math.Log2(float64(u))
	fmt.Printf("log %v\n", math.Ceil(log2))
	v := NewVanEmdeBoasTree(math.Ceil(log2))
	t.Run("test", func(t *testing.T) {
		for _, tt := range tests {
			v.Insert(tt.args.k)
		}
	})
	fmt.Println(v.Min, v.Max)
	if v.Max != maxVal {
		t.Fatal(maxVal, v.Max)
	}
}

func TestVanEmdeBoasTree_Delete(t *testing.T) {
	type args struct {
		k float64
	}
	tests := []struct {
		name string
		v    *VanEmdeBoasTree
		args args
	}{
	// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			v := NewVanEmdeBoasTree(8)
			v.Delete(tt.args.k)
		})
	}
}

func TestVanEmdeBoasTree_Lookup(t *testing.T) {
	type args struct {
		k float64
	}
	type testArgs struct {
		name string
		args args
	}
	tests := make([]testArgs, 0, 0)
	var u int64 = 256
	for i := int64(1); i < 4; i++ {
		tests = append(tests, testArgs{name: "thetest" + strconv.Itoa(int(i)), args: args{float64(i)}})
	}
	log2 := math.Log2(float64(u))
	fmt.Printf("log %v\n", math.Ceil(log2))
	v := NewVanEmdeBoasTree(math.Ceil(log2))
	for _, tt := range tests {
		v.Insert(tt.args.k)
	}
	if v.Lookup(5) {
		t.Fatal("5 should be absent")
	}
	for i := int64(1); i < 4; i++ {
		if !v.Lookup(float64(i)) {
			t.Fatal(strconv.Itoa(int(i)) + " should be present")
		}
	}
}

func TestVanEmdeBoasTree_FindNext(t *testing.T) {
	type args struct {
		k float64
	}
	tests := []struct {
		name string
		v    *VanEmdeBoasTree
		args args
	}{
	// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			v := NewVanEmdeBoasTree(8)
			v.FindNext(tt.args.k)
		})
	}
}

func TestVanEmdeBoasTree_FindPrevious(t *testing.T) {
	type args struct {
		k float64
	}
	tests := []struct {
		name string
		v    *VanEmdeBoasTree
		args args
	}{
	// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			v := NewVanEmdeBoasTree(8)
			v.FindPrevious(tt.args.k)
		})
	}
}

func TestNewVanEmdeBoasTree(t *testing.T) {
	tests := []struct {
		name string
		want *VanEmdeBoasTree
	}{
	// TODO: Add test cases.
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := NewVanEmdeBoasTree(8); !reflect.DeepEqual(got, tt.want) {
				t.Errorf("NewVanEmdeBoasTree() = %v, want %v", got, tt.want)
			}
		})
	}
}
