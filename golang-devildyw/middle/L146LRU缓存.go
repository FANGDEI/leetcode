package main

func main() {

	lru := Constructor3(2)
	lru.Put(1, 1)
	lru.Put(2, 2)
	lru.Get(1)
	lru.Put(3, 3)
	lru.Get(2)
	lru.Put(4, 4)
	lru.Get(1)
	lru.Get(3)
	lru.Get(4)
}

type LRUCache struct {
	//看标签想出的思路 也不能算是我想出来的了
	cache          map[int]*DLinkedNode
	head, tail     *DLinkedNode
	size, capacity int
}

// 定义一个双向链表
type DLinkedNode struct {
	key, value int
	prev, next *DLinkedNode
}

func Constructor3(capacity int) LRUCache {
	lru := LRUCache{
		size:     0,
		capacity: capacity,
		cache:    make(map[int]*DLinkedNode),
		head: &DLinkedNode{
			value: -1,
		},
		tail: &DLinkedNode{
			value: -1,
		},
	}
	lru.head.next = lru.tail
	lru.tail.prev = lru.head
	return lru
}

func (this *LRUCache) Get(key int) int {
	if node, exist := this.cache[key]; exist {
		// 节点存在 把这个节点 拿出来放到双向链表后面
		node.prev.next = node.next
		node.next.prev = node.prev

		node.prev = this.tail.prev
		node.prev.next = node
		this.tail.prev = node
		node.next = this.tail

		return node.value
	} else {
		// 不存在返回-1
		return -1
	}
}

func (this *LRUCache) Put(key int, value int) {
	if node, exist := this.cache[key]; exist {
		node.value = value
		// 节点存在 把这个节点 拿出来放到双向链表后面 并且更新值
		node.prev.next = node.next
		node.next.prev = node.prev

		node.prev = this.tail.prev
		node.prev.next = node
		this.tail.prev = node
		node.next = this.tail
	} else {
		// 不存在需要新增 直接增加到后面
		newNode := &DLinkedNode{
			key:   key,
			value: value,
			prev:  this.tail.prev,
			next:  this.tail,
		}
		newNode.prev.next = newNode
		this.tail.prev = newNode

		this.cache[key] = newNode
		this.size++
		// 判断是否超过容量
		if this.size > this.capacity {
			// 需要逐出 头节点后第一个节点
			deleteNode := this.head.next
			this.head.next = deleteNode.next
			deleteNode.next.prev = this.head

			// 删除cache中这个key
			delete(this.cache, deleteNode.key)
			this.size--
		}
	}
}
