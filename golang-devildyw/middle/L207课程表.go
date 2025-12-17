package main

func main() {}

func canFinish(numCourses int, prerequisites [][]int) bool {
	// 拓扑排序
	// 1. 入度数组 记录着节点的入度（代表着指向节点边的数量）
	// 2. 邻接表（记录着某一个节点 他的指向 可能有多个指向所以用map[int][]int 来保存）
	// 3. 队列（记录入度为0的节点）

	// 入度表
	inDegree := make([]int, numCourses)
	// 邻接表
	adj := make(map[int][]int)

	for _, edge := range prerequisites {
		cur := edge[0]
		pre := edge[1]
		inDegree[cur]++
		// 构建邻接表：pre 课指向cur课
		adj[pre] = append(adj[pre], cur)
	}

	//3. 将所有入度为0的课入列
	queue := []int{}
	for i := 0; i < len(inDegree); i++ {
		if inDegree[i] == 0 {
			queue = append(queue, i)
		}
	}

	//4. 开始选课
	count := 0
	for len(queue) > 0 {
		//出队
		selected := queue[0]
		queue = queue[1:]

		count++

		//学习了这门课之后需要减少相应的入度 这个从邻接表看
		toEnQueue := adj[selected]
		if len(toEnQueue) > 0 {
			for _, nextCourse := range toEnQueue {
				// 后续课程入度-1
				inDegree[nextCourse]--
				if inDegree[nextCourse] == 0 {
					//如果入度为0了 将课程加入队列 代表课学习
					queue = append(queue, nextCourse)
				}
			}
		}
	}
	//最后判断学习的课程是否等于所需学习的课程
	return count == numCourses
}
