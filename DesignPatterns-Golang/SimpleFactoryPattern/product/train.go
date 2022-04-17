package product

import "fmt"

type Train struct {
}

func (t *Train) Work() {
	fmt.Println("The train is working")
}
