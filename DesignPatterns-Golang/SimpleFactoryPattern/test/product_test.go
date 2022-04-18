package product_test

import (
	"fmt"
	"simplefactorypattern/factory"
	"testing"
)

func TestCreateProduct(t *testing.T) {
	f := factory.New()
	fmt.Println(f.CreateProduct("") == nil)
}

func TestCar(t *testing.T) {
	f := factory.New()
	f.CreateProduct("Car").Work()
	f.GetCarInstance().Work()
}

func TestBike(t *testing.T) {
	f := factory.New()
	f.CreateProduct("Bike").Work()
	f.GetBikeInstance().Work()
}

func TestPlane(t *testing.T) {
	f := factory.New()
	f.CreateProduct("Plane").Work()
	f.GetPlaneInstance().Work()
}

func TestTrain(t *testing.T) {
	f := factory.New()
	f.CreateProduct("Train").Work()
	f.GetTrainInstance().Work()
}
