package daily

func arrayStringsAreEqual(word1 []string, word2 []string) bool {
	w1, w2 := "", ""

	for _, v := range word1 {
		w1 += v
	}

	for _, v := range word2 {
		w2 += v
	}

	return w1 == w2
}
