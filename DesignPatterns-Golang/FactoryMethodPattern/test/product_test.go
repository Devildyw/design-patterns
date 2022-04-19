package product

import (
	"factorymethodpattern/factory"
	"testing"
)

func TestBike(t *testing.T) {
	f := factory.BikeFactory{}
	f.NewProduct().Work()
}

func TestCar(t *testing.T) {
	f := factory.CarFactory{}
	f.NewProduct().Work()
}

func TestTrain(t *testing.T) {
	f := factory.TrainFactory{}
	f.NewProduct().Work()
}

func TestPlane(t *testing.T) {
	f := factory.PlaneFactory{}
	f.NewProduct().Work()
}
