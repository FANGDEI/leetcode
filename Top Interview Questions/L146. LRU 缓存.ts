class LRUCache {
    capacity:number
    map:Map<number,number>
    constructor(capacity: number) {
        this.capacity= capacity
        this.map = new Map< number, number >()
    }

    get(key: number): number {
        if (this.map.has(key)) {
            let value=this.map.get(key)
            this.map.delete(key)
            this.map.set(key, value)
            return this.map.get(key)
        } else {
            return -1
        }
    }

    put(key: number, value: number): void {
        if(this.map.get(key)){
            this.map.delete(key)
            this.map.set(key, value)
        }else{
            this.map.set(key, value)
        }
        if(this.map.size>this.capacity){
            let iter=this.map.keys()
            this.map.delete(iter.next().value)
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */