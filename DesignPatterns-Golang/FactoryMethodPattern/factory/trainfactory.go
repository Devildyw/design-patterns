package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a factory with the method New which is provided by the package factory
// You can get a instance of the train with the method NewProduct
type trainFactory struct {
}

// NewTrainFactory with the function, you can get an instance of the factory
func NewTrainFactory() *trainFactory {
	return &trainFactory{}
}

// NewProduct with the method, you can get an instance of the Train
func (t *trainFactory) NewProduct() interfaces.Vehicle {
	return &product.Train{}
}
