package product

import (
	"factorymethodpattern/factory"
	"testing"
)

func TestBike(t *testing.T) {
	factory.NewBikeFactory().NewProduct().Work()
}

func TestCar(t *testing.T) {
	factory.NewCarFactory().NewProduct().Work()
}

func TestTrain(t *testing.T) {
	factory.NewTrainFactory().NewProduct().Work()
}

func TestPlane(t *testing.T) {
	factory.NewPlaneFactory().NewProduct().Work()
}
