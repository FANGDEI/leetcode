package main

func main() {}

func findOrder(numCourses int, prerequisites [][]int) []int {
	// 拓扑排序

	//1.入度数组
	inDegree := make([]int, numCourses)
	//2. 邻接表
	adj := make(map[int][]int)
	//3. 队列 记录入度为0的节点
	queue := []int{}

	//开始构建拓扑排序
	for _, edge := range prerequisites {
		cur := edge[0]
		pre := edge[1]
		inDegree[cur]++

		//记录边
		adj[pre] = append(adj[pre], cur)
	}

	// 把入度为0的节点装入队列
	for i := 0; i < len(inDegree); i++ {
		if inDegree[i] == 0 {
			queue = append(queue, i)
		}
	}

	result := []int{}
	count := 0

	for len(queue) > 0 {
		selected := queue[0]
		queue = queue[1:]

		count++
		result = append(result, selected)

		toEnQueue := adj[selected]
		for _, nextCourse := range toEnQueue {
			inDegree[nextCourse]--
			if inDegree[nextCourse] == 0 {
				queue = append(queue, nextCourse)
			}
		}
	}

	if count == numCourses {
		return result
	}
	return []int{}

}
