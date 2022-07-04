function getNoZeroIntegers(n: number): number[] {
    let a = 1;
    let b = n - 1;
    while (a < b) {
        if (a.toString().includes('0') || b.toString().includes('0')) {
            a++;
            b--;
        } else {
            break;
        }
    }
    return [a, b]
};
console.log(getNoZeroIntegers(100));
