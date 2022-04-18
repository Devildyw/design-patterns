package product

import "fmt"

// Bike to implement the interface vehicle
type Bike struct {
}

func (b *Bike) Work() {
	fmt.Println("The bike is working")
}
