function isHappy(n: number): boolean {

    let p: string = '' + n;
    let set:Set<number>=new Set<number>()
    while (true) {
        let num=0
        for (let i = 0; i < p.length; i++) {
            num += Math.pow(parseInt(p.charAt(i)), 2)
        }
        if(set.has(num)){
            return false
        }
        set.add(num)
        if (num == 1) {
            return true
        }
        
        if (num == parseInt(p)) {
            return false
        }
        p=''+num
    }
};

