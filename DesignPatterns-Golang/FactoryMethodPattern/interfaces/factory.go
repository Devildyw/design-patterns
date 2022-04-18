package interfaces

// This interface represents an abstract class for all factories
type Factory interface {
	NewProduct() Vehicle
}
