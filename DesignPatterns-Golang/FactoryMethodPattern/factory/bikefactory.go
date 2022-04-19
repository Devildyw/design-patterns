package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a instance of the bike with the method NewProduct
type BikeFactory struct {
}

// NewProduct with the method, you can get a instance of Bike
func (b *BikeFactory) NewProduct() interfaces.Vehicle {
	return &product.Bike{}
}
