package lazysingleton

import (
	"sync"
	"testing"
)

var wg sync.WaitGroup

func TestLazySingletonMutex(t *testing.T) {
	wg.Add(30)
	for i := 0; i < 30; i++ {
		go func() {
			GetInstance()
			wg.Done()
		}()
	}
	wg.Wait()
}

func TestLazySingletonOnce(t *testing.T) {
	wg.Add(30)
	for i := 0; i < 30; i++ {
		go func() {
			GetIns()
			wg.Done()
		}()
	}
	wg.Wait()
}
