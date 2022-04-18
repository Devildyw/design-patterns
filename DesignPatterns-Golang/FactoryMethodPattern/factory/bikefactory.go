package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)
// The factory to create product
// You can get a factory with the method New which is provided by the package factory
// You can get a instance of the bike with the method NewProduct
type bikeFactory struct {
}

// NewBikeFactory with the function, you can get a instance of factory
func NewBikeFactory() *bikeFactory {
	return &bikeFactory{}
}

// NewProduct with the method, you can get a instance of Bike
func (b *bikeFactory) NewProduct() interfaces.Vehicle {
	return &product.Bike{}
}
