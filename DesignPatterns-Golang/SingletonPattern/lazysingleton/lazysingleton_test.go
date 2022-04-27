package lazysingleton

import (
	"sync"
	"testing"
)

var wg sync.WaitGroup

func TestLazySingleton(t *testing.T) {
	wg.Add(30)
	for i := 0; i < 30; i++ {
		go func() {
			GetInstance()
			wg.Done()
		}()
	}
	wg.Wait()
}
