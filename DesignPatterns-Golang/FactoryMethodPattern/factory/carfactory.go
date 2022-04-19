package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a instance of the car with the method NewProduct
type CarFactory struct {
}

// NewProduct with the method, you can get an instance of Car
func (c *CarFactory) NewProduct() interfaces.Vehicle {
	return &product.Car{}
}
