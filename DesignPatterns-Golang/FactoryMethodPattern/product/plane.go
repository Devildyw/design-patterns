package product

import "fmt"

// Plane to implement the interface vehicle
type Plane struct {
}

func (p *Plane) Work() {
	fmt.Println("The plane is working")
}
