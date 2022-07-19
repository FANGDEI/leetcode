package main

import (
	"log"

	"github.com/robfig/cron"
)

func main() {
	i := 0
	c := cron.New()
	spec := "*/5 * * * *"
	c.AddFunc(spec, func() {
		i++
		log.Println("execute per 5 seconds", i)
	})
	c.Start()
	select {}
}
