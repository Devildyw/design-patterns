package product

import "fmt"

type Bike struct {
}

func (b *Bike) Work() {
	fmt.Println("The bike is working")
}
