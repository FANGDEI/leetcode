package main

func main() {}

// 联想一下如果给你棵树会怎么做
func cloneGraph(node *Node) *Node {
	if node == nil {
		return nil
	}
	// 使用hash表避免因为图存在环而导致死循环 已经处理过的节点直接返回即可
	hash := make(map[*Node]*Node)

	result := dfs2(node, hash)
	return result
}

func dfs2(node *Node, hash map[*Node]*Node) *Node {
	if value, exist := hash[node]; exist {
		return value
	}

	result := &Node{
		Val:       node.Val,
		Neighbors: make([]*Node, len(node.Neighbors)),
	}

	hash[node] = result

	for i := 0; i < len(node.Neighbors); i++ {
		neighbor := dfs2(node.Neighbors[i], hash)
		if neighbor == nil {
			continue
		}
		result.Neighbors[i] = neighbor
	}
	return result
}
