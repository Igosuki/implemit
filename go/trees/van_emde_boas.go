package trees

import (
	"fmt"
	"math"
)

/**
 	VDB Tree implementation
	Space	O(M)
	Search	O(log log M)
	Insert	O(log log M)
	Delete	O(log log M)
*/

type Tree interface {
	Insert(k float64)
	Delete(k float64)
	Lookup(k float64)
	FindNext(k float64)
	FindPrevious(k float64)
	IsEmpty() bool
}

type VanEmdeBoasTree struct {
	u        float64
	lowerU   float64
	children []*VanEmdeBoasTree
	Max      float64
	Min      float64
	summary  *VanEmdeBoasTree
}

func (v *VanEmdeBoasTree) high(k float64) int64 {
	return int64(math.Floor(k / v.lowerU))
}

func (v *VanEmdeBoasTree) low(k float64) float64 {
	return math.Mod(k, v.lowerU)
}

func (v *VanEmdeBoasTree) Insert(k float64) {
	if v.Min > v.Max {
		v.Min = k
		v.Max = k
		return
	}
	if k < v.Min {
		k, v.Min = v.Min, k
	}
	if v.u > 2 {
		nextIdx := v.high(k)
		rest := v.low(k)

		defer func() {
			if r := recover(); r != nil {
				fmt.Printf("%v %v %v %v\n", k, v.u, nextIdx, len(v.children))
			}
		}()
		if v.children[nextIdx] == nil {
			v.children[nextIdx] = recursiveTreeInit(v.u)
			v.children[nextIdx].Insert(rest)
			v.summary.Insert(rest)
		} else {
			v.children[nextIdx].Insert(rest)
		}
	}

	if k > v.Max {
		v.Max = k
	}

}

func (*VanEmdeBoasTree) Delete(k float64) {
	panic("implement me")
}

func (v *VanEmdeBoasTree) Lookup(k float64) bool {
	if k == v.Max || k == v.Min {
		return true
	}
	if v.u > 2 {
		if sub := v.children[v.high(k)]; sub != nil {
			return sub.Lookup(v.low(k))
		}
		return false
	} else {
		return false
	}
}

func (*VanEmdeBoasTree) FindNext(k float64) {
	panic("implement me")
}

func (*VanEmdeBoasTree) FindPrevious(k float64) {
	panic("implement me")
}

func NewVanEmdeBoasTree(maxKeyLength float64) *VanEmdeBoasTree {
	maxTreeSize := math.Pow(2, maxKeyLength)
	return recursiveTreeInit(maxTreeSize)
}

func recursiveTreeInit(maxTreeSize float64) *VanEmdeBoasTree {
	u := higherSqrRoot(maxTreeSize)
	if maxTreeSize <= 2 {
		return &VanEmdeBoasTree{u, 2, nil, -2, -1, nil}
	} else {
		return &VanEmdeBoasTree{u, lowerSqrRoot(maxTreeSize), make([]*VanEmdeBoasTree, int64(u), int64(u)), -2, -1, recursiveTreeInit(u)}
	}
}
func lowerSqrRoot(i float64) float64 {
	return math.Pow(2, math.Floor(math.Log2(i)/2))
}

func higherSqrRoot(i float64) float64 {
	return math.Pow(2, math.Ceil(math.Log2(i)/2))
}

func (tree *VanEmdeBoasTree) printDetail() {
	fmt.Printf("%+v %+v ", tree.Min, tree.Max)
	if tree.summary != nil {
		tree.summary.printDetail()
		for _, c := range tree.summary.children {
			if c != nil {
				c.printDetail()
			}
		}
		fmt.Printf("\n")
	}
}
