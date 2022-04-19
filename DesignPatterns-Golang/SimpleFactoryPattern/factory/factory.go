package factory

import (
	"simplefactorypattern/interfaces"
	"simplefactorypattern/product"
)

// The factory to create product
// You can get the product with the name of the product which you need
// Or you can get the product with the method provided by the factory
type Factory struct {
}

// CreateProduct with the mothod, you can get product with name of the product
func (f *Factory) CreateProduct(productName string) interfaces.Vehicle {
	if productName == "Car" {
		return &product.Car{}
	} else if productName == "Bike" {
		return &product.Bike{}
	} else if productName == "Plane" {
		return &product.Plane{}
	} else if productName == "Train" {
		return &product.Train{}
	}
	return nil
}

// GetCarInstance with the mothed, you can get an instance of Car
func (f *Factory) GetCarInstance() *product.Car {
	return &product.Car{}
}

// GetBikeInstance with the mothed, you can get an instance of Bike
func (f *Factory) GetBikeInstance() *product.Bike {
	return &product.Bike{}
}

// GetPlaneInstance with the mothed, you can get an instance of Plane
func (f *Factory) GetPlaneInstance() *product.Plane {
	return &product.Plane{}
}

// GetTrainInstance with the mothed, you can get an instance of Train
func (f *Factory) GetTrainInstance() *product.Train {
	return &product.Train{}
}
