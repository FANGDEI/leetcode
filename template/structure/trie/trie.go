package trie

// Node Define the node of Trie
type Node struct {
	// Pointer 26 character
	children [26]*Node
	// Whether the node is a leaf
	isLeaf bool
}

// NewNode Create the root node of the Trie
func NewNode() *Node {
	n := &Node{}
	n.isLeaf = false
	return n
}
