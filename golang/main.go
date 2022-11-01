package main

import (
	"fmt"
	"sort"
)

func main() {
	sli := []int{1, 4, 2, 999, 23, 43}
	sort.Slice(sli, func(i, j int) bool {
		return sli[i] > sli[j]
	})
	fmt.Printf("%v", sli)
}
