package product

import "fmt"

type Car struct {
}

func (c *Car) Work() {
	fmt.Println("The car is working")
}
