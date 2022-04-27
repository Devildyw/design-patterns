package hungrysingleton

import (
	"fmt"
)

// Declare an instance for global use
var instance = &hungrysingleton{}

type hungrysingleton struct {
}

// GetInstance Get an instance
func GetInstance() *hungrysingleton {
	return instance
}

func (s *hungrysingleton) Work() {
	fmt.Println("hungrysingleton is working")
}
