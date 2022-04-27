package lazysingleton

import (
	"fmt"
	"log"
	"sync"
)

var (
	// Declare an instance for global use
	instance *lazysingleton
	// Use sync.Mutex to prevent objects from being instantiated more than once
	mutex = sync.Mutex{}
	// Use sync.Once to prevent the objects from being instantiated more than once
	once sync.Once
)

type lazysingleton struct {
}

// Recommend to use
// Get an instance, use the sync.Once
func GetIns() *lazysingleton {
	once.Do(func() {
		log.Println("create the instance")
		instance = &lazysingleton{}
	})
	return instance
}

// Get an instance, use the sync.Mutex
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
