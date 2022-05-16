package trie

import "testing"

func TestTrie(t *testing.T) {
	n := NewNode()
	n.Insert([]string{"hello", "world", "hellofang"})
	is := n.Find("hell")
	if is {
		t.Log("find")
	} else {
		t.Log("not find")
	}
}
