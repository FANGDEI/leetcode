package main

type Node struct {
	Val       int
	Next      *Node
	Random    *Node
	Left      *Node
	Right     *Node
	Neighbors []*Node
}
