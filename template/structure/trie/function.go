package trie

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

// PrefixMatch Get how many words start with the prefix
func (n *Node) PrefixMatch(prefix string) int {
	curr := n
	for _, char := range prefix {
		index := char - 'a'
		if curr.children[index] == nil {
			return 0
		}
		curr = curr.children[index]
	}

	cnt := 0
	if curr.isLeaf {
		cnt++
	}
	for i := 0; i < 26; i++ {
		if curr.children[i] != nil {
			cnt++
		}
	}
	return cnt
}
