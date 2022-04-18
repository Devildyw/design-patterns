package product

import "fmt"

// Car to implement the interface vehicle
type Car struct {
}

func (c *Car) Work() {
	fmt.Println("The car is working")
}
