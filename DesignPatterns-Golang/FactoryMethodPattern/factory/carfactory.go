package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a factory with the method New which is provided by the package factory
// You can get a instance of the car with the method NewProduct
type carFactory struct {
}

// NewCarFactory with the function, you can get an instance of factory
func NewCarFactory() *carFactory {
	return &carFactory{}
}

// NewProduct with the method, you can get an instance of Car
func (c *carFactory) NewProduct() interfaces.Vehicle {
	return &product.Car{}
}
