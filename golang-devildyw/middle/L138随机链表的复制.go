package main

func main() {

}

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

// 笨方法
func copyRandomListOn2(head *Node) *Node {
	m1 := make(map[*Node][]*Node)
	m2 := make(map[*Node]*Node)
	dummyNode := &Node{
		Val: 0,
	}
	cur := dummyNode

	for head != nil {
		// 创建节点
		temp := &Node{
			Val: head.Val,
		}

		m2[head] = temp
		if head.Random != nil {
			if list, exist := m1[head.Random]; exist {
				list = append(list, temp)
				m1[head.Random] = list
			} else {
				l := []*Node{temp}
				m1[head.Random] = l
			}
		}

		m2[head] = temp
		cur.Next = temp
		cur = cur.Next
		head = head.Next
	}

	// 在外层处理Random
	for key, value := range m1 {
		if random, exist := m2[key]; exist {
			for _, v := range value {
				v.Random = random
			}
		}
	}

	return dummyNode.Next

}

func copyRandomListOn(head *Node) *Node {
	m2 := make(map[*Node]*Node)
	dummyNode := &Node{
		Val: 0,
	}
	cur := dummyNode
	// 1.创建一个节点之前 需要判断这个节点是否已经被创建了
	// 2.创建每一个节点时 如果Random指针不等于 nil 那么把Random节点一起创建了
	// 3.创建一个节点后 判断random节点是否已经创建了
	// 4.创建一个节点时 需要把这个节点和原来节点的关系存入到 map中 key：原来节点 value 新建节点
	for head != nil {
		// 如果当前节点已经被创建了
		var temp *Node
		if node, exist := m2[head]; exist {
			// 那么就直接使用就行
			temp = node
		} else {
			// 没有创建就新建
			temp = &Node{
				Val: head.Val,
			}
			m2[head] = temp
		}
		// random指针不为空
		if head.Random != nil {
			// 看看这个random是否被创建
			if random, exist := m2[head.Random]; exist {
				temp.Random = random
			} else { // 没有创建 就创建
				newRandom := &Node{
					Val: head.Random.Val,
				}
				temp.Random = newRandom
				m2[head.Random] = newRandom
			}
		}
		cur.Next = temp
		cur = cur.Next
		head = head.Next
	}

	return dummyNode.Next

}
