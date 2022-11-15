var fractionToDecimal = function(numerator, denominator) {
    if(!numerator) return '0'

    // 归一整数
    let sign = Math.sign(numerator) * Math.sign(denominator) > 0 ? ''  : '-'
    numerator = Math.abs(numerator)
    denominator = Math.abs(denominator)

    // 处理整除情况
    let str = '', reset
    reset = Math.floor(numerator / denominator)
    numerator %= denominator
    if(!numerator) return sign + reset + '' // 除尽了

    // 寻找重复的循环
    let index = 0, map = {}, result = reset + '.'
    while(map[numerator] === undefined){ // 没找到之前的除式
        map[numerator] = index++ // 记录除数位置
        numerator *= 10
        str += Math.floor(numerator / denominator)
        numerator %= denominator
        if(!numerator) return sign + result + str // 除尽了
    }

    let pos = map[numerator] 
    console.log(pos);
    
    return `${sign}${result}${str.slice(0, pos)}(${str.slice(pos)})`
}
