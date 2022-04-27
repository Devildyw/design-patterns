package lazysingleton

import (
	"fmt"
	"log"
	"sync"
)

var (
	instance *lazysingleton
	mutex    = sync.Mutex{}
)

type lazysingleton struct {
}

func GetInstance() *lazysingleton {
	mutex.Lock()
	defer mutex.Unlock()
	if instance == nil {
		log.Println("create the instance")
		instance = &lazysingleton{}
		return instance
	}
	log.Println("the instance is already created")
	return instance
}

func (s *lazysingleton) Work() {
	fmt.Println("lazysingleton is working")
}
