package product

import "fmt"

// Train to implement the interface vehicle
type Train struct {
}

func (t *Train) Work() {
	fmt.Println("The train is working")
}
