package main

import (
	"fmt"
	"golang-devildyw/middle"
)

//TIP <p>To run your code, right-click the code and select <b>Run</b>.</p> <p>Alternatively, click
// the <icon src="AllIcons.Actions.Execute"/> icon in the gutter and select the <b>Run</b> menu item from here.</p>

func main() {
	slice := []int{1, 2, 3, 2, 2}
	//target := 7
	//result := middle.MinSubArrayLen(target, arr[0:6])
	result := middle.TotalFruit(slice)
	fmt.Println(result)
}
