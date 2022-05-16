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

// insert Insert a word into the Trie
func (n *Node) insert(s string) {
	curr := n
	for _, char := range s {
		index := char - 'a'
		if curr.children[index] == nil {
			curr.children[index] = NewNode()
		}
		curr = curr.children[index]
	}
	curr.isLeaf = true
}

// Insert Insert one word or more words into the Trie
func (n *Node) Insert(s []string) {
	for _, ss := range s {
		n.insert(ss)
	}
}

// Find Get a word whether is in the Trie
func (n *Node) Find(s string) bool {
	curr := n
	for _, char := range s {
		index := char - 'a'
		if curr.children[index] == nil {
			return false
		}
		curr = curr.children[index]
	}
	return curr.isLeaf
}

// remove Remove a word from the Trie
// It's not remove from the Trie actually, just modify the isLeaf to false
func (n *Node) remove(s string) {
	if len(s) == 0 {
		return
	}

	curr := n
	for _, char := range s {
		index := char - 'a'
		if curr.children[index] == nil {
			return
		}
		curr = curr.children[index]
	}
	curr.isLeaf = false
}

// Remove Remove one word or more words from the Trie
func (n *Node) Remove(s []string) {
	for _, ss := range s {
		n.remove(ss)
	}
}
