package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(simplifyPath("/.../a/../b/c/../d/./"))
}

func simplifyPath(path string) string {

	stack := make([]byte, 0)

	i := 0
	for i < len(path) {
		if path[i] == '/' {
			start := i
			for i < len(path) && path[i] == '/' {
				i++
			}
			if i-start >= 1 {
				stack = append(stack, '/')
			}
		} else if path[i] == '.' {
			start := i - 1
			for i < len(path) && path[i] != '/' {
				stack = append(stack, path[i])
				i++
			}
			str := path[start:i]
			if str == "." {
				for {
					if len(stack) > 0 {
						if stack[len(stack)-1] == '/' {
							stack = stack[:len(stack)-1]
							break
						}
						if len(stack) > 0 {
							stack = stack[:len(stack)-1]
						}
					} else {
						break
					}
				}
			} else if str == ".." {
				count := 2
				for {
					if len(stack) > 0 {
						if stack[len(stack)-1] == '/' {
							stack = stack[:len(stack)-1]
							count--
							if count == 0 {
								break
							}
						}
						if len(stack) > 0 {
							stack = stack[:len(stack)-1]
						}
					} else {
						break
					}
				}
			}
		} else {
			// 我们只处理特殊的字符
			stack = append(stack, path[i])
			i++
		}
	}

	// 处理最后一个 /
	if len(stack) > 0 && stack[len(stack)-1] == '/' {
		stack = stack[:len(stack)-1]
	}
	if len(stack) == 0 {
		stack = append(stack, '/')
	}

	return string(stack)

}

// 简单做法 利用split的特性来做 一开始没想到
func simplifyPathSimple(path string) string {
	// 利用字符串分隔 '/' 得到的只剩下 目录、空字符串 . .. 了
	stack := []string{}
	for _, name := range strings.Split(path, "/") {
		if name == ".." {
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
		} else if name != "" && name != "." {
			stack = append(stack, name)
		}
	}

	return "/" + strings.Join(stack, "/")

}
