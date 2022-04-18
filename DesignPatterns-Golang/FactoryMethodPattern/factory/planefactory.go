package factory

import (
	"factorymethodpattern/interfaces"
	"factorymethodpattern/product"
)

// The factory to create product
// You can get a factory with the function NewPlaneFactory which is provided by the package factory
// You can get a instance of the plane with the method NewProduct
type planeFactory struct {
}

// NewPlaneFactory with the function, you can get an instance of the factory
func NewPlaneFactory() *planeFactory {
	return &planeFactory{}
}

// NewProduct with the method, you can get an instance of the Plane
func (p *planeFactory) NewProduct() interfaces.Vehicle {
	return &product.Plane{}
}
