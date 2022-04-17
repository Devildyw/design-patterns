package factory

import (
	"simplefactorypattern/interfaces"
	"simplefactorypattern/product"
)

type factory struct {
}

func New() *factory {
	return &factory{}
}

func (f *factory) CreateProduct(productName string) interfaces.Vehicle {
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

func (f *factory) GetCarInstance() *product.Car {
	return &product.Car{}
}

func (f *factory) GetBikeInstance() *product.Bike {
	return &product.Bike{}
}

func (f *factory) GetPlaneInstance() *product.Plane {
	return &product.Plane{}
}

func (f *factory) GetTrainInstance() *product.Train {
	return &product.Train{}
}
