package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a instance of the train with the method NewProduct
type TrainFactory struct {
}

// NewProduct with the method, you can get an instance of the Train
func (t *TrainFactory) NewProduct() interfaces.Vehicle {
	return &product.Train{}
}
