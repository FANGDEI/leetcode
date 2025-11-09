package main

func main() {
	print(romanToInt("MCMXCIV"))
}

func romanToInt(s string) int {
	var (
		n                       = len(s)
		romanMap map[string]int = make(map[string]int)
		result   int            = 0
	)

	romanMap["I"] = 1
	romanMap["V"] = 5
	romanMap["X"] = 10
	romanMap["L"] = 50
	romanMap["C"] = 100
	romanMap["D"] = 500
	romanMap["M"] = 1000
	romanMap["IV"] = 4
	romanMap["IX"] = 9
	romanMap["XL"] = 40
	romanMap["XC"] = 90
	romanMap["CD"] = 400
	romanMap["CM"] = 900

	for i := 0; i < n; i++ {
		if i+1 < n {
			if value, ok := romanMap[s[i:i+2]]; ok {
				result += value
				i++
				continue
			}
		}
		result += romanMap[s[i:i+1]]

	}
	return result
}
