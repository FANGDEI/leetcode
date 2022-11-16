class Heap {
    data: number[]
    size: number
    constructor() {
        this.data = []
        this.size = 0
    }
    add(params: number) {
        this.data.push(params)
        let index = this.size
        while (this.data[index] > this.data[Math.floor((index - 1) / 2)]) {
            let temp = this.data[index]
            this.data[index] = this.data[Math.floor((index - 1) / 2)]
            this.data[Math.floor((index - 1) / 2)] = temp
            index = Math.floor((index - 1) / 2)
        }
        this.size++
    }

    delete() {
        let temp = this.data[0]
        this.data[0] = this.data[this.size - 1]
        this.data[this.size - 1] = temp
        this.data.pop()
        let i = 0

        while ((2 * i + 1) <= this.size) {
            let j = i * 2 + 1;
            // 让j指向他的孩子结点中的大的那一个
            if (j + 1 <= this.size && this.data[j] < this.data[j + 1]) {
                j = j + 1;
            }
            if (this.data[i] > this.data[j]) {
                break;
            }

            //元素下移
            let t = this.data[i];
            this.data[i] = this.data[j];
            this.data[j] = t;
            i = j;

        }
    }
}


let heap=new Heap()
heap.add(1)
heap.add(9)
heap.add(100)
heap.add(3)
heap.add(78)
heap.add(1000)
heap.add(89)

console.log(heap.data);

heap.delete()

console.log(heap.data);

