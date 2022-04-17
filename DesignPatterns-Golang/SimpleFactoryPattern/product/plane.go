package product

import "fmt"

type Plane struct {
}

func (p *Plane) Work() {
	fmt.Println("The plane is working")
}
