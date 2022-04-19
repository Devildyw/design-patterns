package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a instance of the plane with the method NewProduct
type PlaneFactory struct {
}

// NewProduct with the method, you can get an instance of the Plane
func (p *PlaneFactory) NewProduct() interfaces.Vehicle {
	return &product.Plane{}
}
