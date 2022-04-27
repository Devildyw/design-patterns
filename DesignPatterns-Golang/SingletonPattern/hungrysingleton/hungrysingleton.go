package hungrysingleton

import (
	"fmt"
)

func init() {
	instance = &hungrysingleton{}
}

var instance *hungrysingleton

type hungrysingleton struct {
}

func GetInstance() *hungrysingleton {
	return instance
}

func (s *hungrysingleton) Work() {
	fmt.Println("hungrysingleton is working")
}
